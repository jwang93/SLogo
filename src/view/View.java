package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField myCommandLineTextField;
    private JButton myClearButton;
    
    private ResourceBundle myResources;
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
        getContentPane().add(makeCommandLinePanel(), BorderLayout.SOUTH);
        getContentPane().add(new JSeparator());
        getContentPane().add(makeCommandHistory(), BorderLayout.WEST);
        getContentPane().add(new JSeparator());
        setJMenuBar(makeMenuBar());

        getContentPane().add(makeTurtleDisplay(), BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    /**
     * Creates the command history part of the window, including a label at the top, a non-user-editable text area to display the history and a clear button that clears the command history.
     * @return JComponent representing the command history
     */
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

    /**
     *  Displays the canvas and the heading and position label for the turtle on the canvas.
     * @return JComponent representing the canvas and turtle state information
     */
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

    private JComponent makeCommandLinePanel () {
        JPanel commandLinePanel = new JPanel();
        commandLinePanel.setLayout(new BoxLayout(commandLinePanel, BoxLayout.LINE_AXIS));

        commandLinePanel.add(new JLabel(myResources.getString("CommandLine")));
        commandLinePanel.add(makeCommandLine());
        commandLinePanel.add(new JSeparator());
        return commandLinePanel;
    }

    
    private JTextField makeCommandLine () {
        myCommandLineTextField = new JTextField(FIELD_SIZE);
        myCommandLineTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String givenCommand = myCommandLineTextField.getText();
                returnMessage(myResources.getString("TextBoxCommand")
                              + givenCommand);
                //TODO connect with Model
                // myModel.executeCommand(givenCommand);
                myCommandLineTextField.setText("");

            }
        });
        return myCommandLineTextField;
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

                int response = FILE_CHOOSER.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    File file = FILE_CHOOSER.getSelectedFile();

                    myModel.saveFunctionsAndVariables(file);
                    returnMessage(myResources.getString("FileSaved") + file.getName());
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
