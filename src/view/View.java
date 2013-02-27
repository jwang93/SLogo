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
    private static final Location DEFAULT_POSITION = new Location(0, 0);

    private static final int DEFAULT_HEADING = 270;

    private static final long serialVersionUID = 401L;

    private static final String DEFAULT_RESOURCE_PACKAGE = "view.resources.";
    private static final String USER_DIR = "user.dir";
    private static final int FIELD_SIZE = 20;
    private static final Dimension CANVAS_BOUNDS = new Dimension(600, 400);
    private static final JFileChooser FILE_CHOOSER = new JFileChooser(System.getProperties()
            .getProperty(USER_DIR));
    
    private JTextArea myCommandHistoryTextArea;
    private JLabel myTurtlePositionLabel;
    private JLabel myTurtleHeadingLabel;

    private JTextField myTextField;

    
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
        JPanel commandHistoryPanel = new JPanel();
        commandHistoryPanel.setLayout(new BorderLayout());
        commandHistoryPanel.add(new JLabel(myResources.getString("CommandHistory")), BorderLayout.NORTH);
        myCommandHistoryTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
        myCommandHistoryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(myCommandHistoryTextArea);
        commandHistoryPanel.add(scrollPane, BorderLayout.CENTER);
        commandHistoryPanel.add(makeClearButton(), BorderLayout.SOUTH);

        return commandHistoryPanel;

    }

    private JComponent makeTurtleDisplay () {
        
        JPanel turtleInfoPanel = new JPanel();
        turtleInfoPanel.setLayout(new BorderLayout());
        
        JPanel canvasPanel = new JPanel();
        canvasPanel.add(myCanvas);
        canvasPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        turtleInfoPanel.add(canvasPanel, BorderLayout.CENTER);

        JPanel state = new JPanel();
        myTurtlePositionLabel = new JLabel();
        myTurtleHeadingLabel = new JLabel();
        state.add(myTurtlePositionLabel);
        state.add(myTurtleHeadingLabel);
        updateHeadingLabel(DEFAULT_HEADING);
        updatePositionLabel(DEFAULT_POSITION);
        turtleInfoPanel.add(state, BorderLayout.SOUTH);
        return turtleInfoPanel;

    }

    private JComponent makeCommandCenter () {
        JPanel result = new JPanel();
        result.setLayout(new BoxLayout(result, BoxLayout.LINE_AXIS));

        result.add(new JLabel(myResources.getString("CommandLine")));
        result.add(makeTextField());
        result.add(new JSeparator());
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

    // TODO so much repeated code here
    protected JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("File"));
        result.add(new AbstractAction(myResources.getString("LoadCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = FILE_CHOOSER.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = FILE_CHOOSER.getSelectedFile();

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
                    int response = FILE_CHOOSER.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = FILE_CHOOSER.getSelectedFile();

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
        myCommandHistoryTextArea.append(message + "\n");
    }

    @Override
    public void clearCommandWindow () {
        myCommandHistoryTextArea.setText("");
    }

    @Override
    public void updatePositionLabel (Location location) {
        myTurtlePositionLabel.setText(myResources.getString("Position") + " " +  location.getX() + ", " + location.getY());

    }

    @Override
    public void updateHeadingLabel (int heading) {
        myTurtleHeadingLabel.setText(myResources.getString("Heading") + " " + heading);

    }

    @Override
    public void setModel (IModel model) {
        myModel = model;
    }

}
