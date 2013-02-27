package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.IModel;
import util.Location;


/**
 * The View for this simulation. Contains a Canvas to draw sprites on, information about positions
 * and heading of the turtle, a command window with history, a command line to type in commands, and
 * options to load and save.
 * 
 * @author Zhen Gou
 * @author David Winegar
 * 
 */
public class View extends JFrame implements IView {
    private static final long serialVersionUID = 401L;

    private static final String DEFAULT_RESOURCE_PACKAGE = "view.resources.";
    private static final String USER_DIR = "user.dir";
    private static final int FIELD_SIZE = 30;
    private static final Dimension CANVAS_BOUNDS = new Dimension(600, 400);

    private JTextArea myTextArea;
    private JTextArea myTurtleState;
    private String myTurtlePositionLabel;
    private String myTurtleHeadingLabel;

    private JTextField myTextField;
    private JFileChooser myChooser;
    private ResourceBundle myResources;
    private KeyListener myKeyListener;

    private MouseListener myMouseListener;

    private JButton myClearButton;

    private IModel myModel;
    private JComponent myCanvas;

    /**
     * Creates the view window.
     * 
     * @param title title of window
     * @param language localization language for configuration file
     */
    public View (String title, String language) {
        setTitle(title);
        
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myCanvas = new Canvas(CANVAS_BOUNDS);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myChooser = new JFileChooser(System.getProperties().getProperty(
                                                                        USER_DIR));
        getContentPane().add(makeCommandCenter(), BorderLayout.SOUTH);
        getContentPane().add(new JSeparator());
        getContentPane().add(makeCommandHistory(), BorderLayout.WEST);
        getContentPane().add(new JSeparator());
        setJMenuBar(makeMenuBar());

        getContentPane().add(makeTurtleDisplay(), BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    private JComponent makeCommandHistory () {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(new JLabel(myResources.getString("CommandHistory")), BorderLayout.NORTH);
        myTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
        myTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(myTextArea);
        result.add(scrollPane);

        return result;

    }

    private JComponent makeTurtleDisplay () {
        JPanel result = new JPanel();
        JPanel state = new JPanel();
        state.setSize(10, 10);
        result.setBorder(BorderFactory.createLineBorder(Color.black));
        state.setBorder(BorderFactory.createLineBorder(Color.black));
        result.setLayout(new BoxLayout(result, BoxLayout.PAGE_AXIS));
        state.setLayout(new BoxLayout(state, BoxLayout.LINE_AXIS));
        result.add(myCanvas);

        myTurtleState = new JTextArea();
        myTurtleState.setEditable(false);
        state.add(myTurtleState);
        updateHeadingLabel(270);
        updatePositionLabel(new Location(0, 0));
        result.add(state);
        return result;

    }

    private JComponent makeCommandCenter () {
        JPanel result = new JPanel();
        result.setLayout(new BoxLayout(result, BoxLayout.LINE_AXIS));

        result.add(new JLabel(myResources.getString("CommandLine")));
        result.add(makeTextField());
        result.add(new JSeparator());
        result.add(makeClearButton());
        return result;
    }

    private JTextField makeTextField () {
        myTextField = new JTextField(FIELD_SIZE);
        myTextField.addKeyListener(myKeyListener);
        // result.addFocusListener(myFocusListener);
        myTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String givenCommand = myTextField.getText();
                returnMessage(myResources.getString("TextBoxCommand")
                              + givenCommand);
                // myModel.executeCommand(givenCommand);
                myTextField.setText("");

            }
        });
        return myTextField;
    }

    private JMenuBar makeMenuBar () {
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        return result;

    }

    //TODO so much repeated code here
    protected JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("File"));
        result.add(new AbstractAction(myResources.getString("LoadCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = myChooser.getSelectedFile();

                        myModel.loadFunctionsAndVariables(file);
                        returnMessage(myResources.getString("FileLoaded") + file.getName());
                        echo(new FileReader(file));
                    }
                }
                catch (IOException io) {
                    // let user know an error occurred, but keep going
                    returnMessage(io.toString());
                }
            }
        });
        result.add(new AbstractAction(myResources.getString("SaveCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {

                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = myChooser.getSelectedFile();

                        myModel.saveFunctionsAndVariables(file);
                        returnMessage(myResources.getString("FileSaved") + file.getName());
                        echo(new FileReader(file));
                    }
                }
                catch (IOException io) {
                    // let user know an error occurred, but keep going
                    returnMessage(io.toString());
                }
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction(myResources.getString("Quit")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                // clean up any open resources, then
                // end program
                System.exit(0);
            }
        });
        return result;
    }

    private JButton makeClearButton () {
        myClearButton = new JButton(myResources.getString("ClearCommand"));
        myClearButton.addMouseListener(myMouseListener);
        myClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                clearCommandWindow();
            }
        });
        myClearButton.setActionCommand("clear");
        return myClearButton;

    }

    private void echo (Reader r) {
        try {
            String s = "";
            BufferedReader input = new BufferedReader(r);
            String line = input.readLine();
            while (line != null) {
                s += line + "\n";
                line = input.readLine();
            }
            returnMessage(s);
        }
        catch (IOException e) {
            returnMessage(e.toString());
        }
    }

    private void echo (String s, KeyEvent e) {
        returnMessage(s + " char:" + e.getKeyChar() + " mod: "
                      + KeyEvent.getKeyModifiersText(e.getModifiers()) + " mod: "
                      + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void returnMessage (String message) {
        myTextArea.append(message + "\n");
    }

    @Override
    public void clearCommandWindow () {
        myTextArea.setText("");
    }

    // TODO this needs to be done better
    @Override
    public void updatePositionLabel (Location location) {
        myTurtlePositionLabel =
                " current turtle position: ( " + location.getX() + " , " + location.getY() +
                        " )      ";
        updateTurtleState();

    }

    // TODO this needs to be done better
    private void updateTurtleState () {
        myTurtleState.setText(myTurtlePositionLabel + myTurtleHeadingLabel);
    }

    // TODO this needs to be done better
    @Override
    public void updateHeadingLabel (int heading) {
        myTurtleHeadingLabel = "     current heading direction: " + heading + " degrees";
        updateTurtleState();
    }

    @Override
    public void setModel (IModel model) {
        myModel = model;
    }

}
