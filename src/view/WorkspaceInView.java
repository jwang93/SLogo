package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.IModel;

import util.DataSource;
import util.Location;

public class WorkspaceInView extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int myID;
	private static final int FIELD_SIZE = 20;
	private static final String DEFAULT_RESOURCE_PACKAGE = "view.resources.";
	
	
	private JTextArea myCommandHistoryTextArea;
    private JLabel myTurtlePositionLabel;
    private JLabel myTurtleHeadingLabel;
    private JTextField myCommandLineTextField;
    private JButton myClearButton;
    
    private ResourceBundle myResources;
    private IModel myModel;
    private Canvas myCanvas;
    private DataSource myDataSource;
    
    public WorkspaceInView(IModel model, Dimension canvasBounds,String language, int id){
    	myID=id;
    	myModel=model;
    	myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
                + language);
    	myCanvas = new Canvas(canvasBounds);
    	myDataSource=myModel.getDataSource();
    	this.setLayout(new BorderLayout());
    	this.add(makeCommandLinePanel(), BorderLayout.SOUTH);
        this.add(makeCommandHistory(), BorderLayout.WEST);
        this.add(makeTurtleDisplay(), BorderLayout.CENTER);
        this.setVisible(true);
        myCanvas.update(myDataSource.getPaintableIterator(), null);
    	
    }
    
    
    private JComponent makeCommandHistory () {
        JPanel commandHistoryPanel = new JPanel();
        commandHistoryPanel.setLayout(new BorderLayout());
        commandHistoryPanel.add(
                                new JLabel(myResources.getString("CommandHistory")),
                                BorderLayout.NORTH);
        myCommandHistoryTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
        myCommandHistoryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(myCommandHistoryTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        commandHistoryPanel.add(scrollPane, BorderLayout.CENTER);
        commandHistoryPanel.add(makeClearButton(), BorderLayout.SOUTH);

        return commandHistoryPanel;

    }

    /**
     * Displays the canvas and the heading and position label for the turtle on
     * the canvas.
     * 
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
        updateHeadingLabel(myDataSource.getTurtleHeading());
        updatePositionLabel(myDataSource.getTurtlePosition());
        turtleInfoPanel.add(state, BorderLayout.SOUTH);

        return turtleInfoPanel;

    }

    /**
     * Creates the comand line, including a typable command line text box and a
     * label.
     * 
     * @return JComponent representing the command line panel
     */
    private JComponent makeCommandLinePanel () {
        JPanel commandLinePanel = new JPanel();
        commandLinePanel.setLayout(new BoxLayout(commandLinePanel,
                                                 BoxLayout.LINE_AXIS));

        commandLinePanel.add(new JLabel(myResources.getString("CommandLine")));
        commandLinePanel.add(makeCommandLine());
        return commandLinePanel;
    }

    /**
     * Creates a command line that passes info to the Model and clears the text
     * field upon hitting enter.
     * 
     * @return JTextField representing the command line text field
     */
    private JTextField makeCommandLine () {
        myCommandLineTextField = new JTextField(FIELD_SIZE);
        myCommandLineTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String givenCommand = myCommandLineTextField.getText();
                showMessage(myResources.getString("TextBoxCommand")
                            + givenCommand);
                myModel.executeCommand(givenCommand);
                myCommandLineTextField.setText("");

            }
        });
        return myCommandLineTextField;
    }
    
    /**
     * Makes the button that clears the command history.
     * 
     * @return JButton representing the clear button
     */
    private JButton makeClearButton () {
        myClearButton = new JButton(myResources.getString("ClearCommand"));
        myClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                clearCommandWindow();
            }
        });
        return myClearButton;
    }
    
    public void showMessage (String message) {
        myCommandHistoryTextArea.append(message + "\n");
    }

    /**
     * Clears the command window.
     */
    private void clearCommandWindow () {
        myCommandHistoryTextArea.setText("");
    }

    /**
     * Updates the position label with the new location.
     * 
     * @param location
     */
    public void updatePositionLabel (Location location) {
        myTurtlePositionLabel.setText(myResources.getString("Position") + " "
                                      + location.getX() + ", " + location.getY());
    }

    /**
     * updates the heading label with the new heading.
     * 
     * @param heading
     */
    public void updateHeadingLabel (int heading) {
        myTurtleHeadingLabel.setText(myResources.getString("Heading") + " "
                                     + heading);

    }
    
    public void update () {
        myCanvas.update(myDataSource.getPaintableIterator(), myDataSource.getBackgroundImage());
        updateHeadingLabel(myDataSource.getTurtleHeading());
        updatePositionLabel(myDataSource.getTurtlePosition());
        showMessage("" + myDataSource.getReturnValue());
        showMessage(myDataSource.showMessage());

    }

   
	

}
