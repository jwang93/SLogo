package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javax.swing.SpringLayout;

import model.IModel;
import model.Model;

import util.Location;

public class View extends JFrame implements IView {
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	private static final String USER_DIR = "user.dir";
	private static final int FIELD_SIZE = 30;

	private JTextArea myTextArea;
	private JTextArea myTurtleState;
	private String myTurtlePositionLabel;
	private String myTurtleHeadingLabel;
	
	private JTextField myTextField;
	private JFileChooser myChooser;
	private ResourceBundle myResources;
	private KeyListener myKeyListener;
	private FocusListener myFocusListener;

	private MouseListener myMouseListener;

	private JButton myClearButton;

	private IModel myModel;
	private JComponent myCanvas;

	public View(String title, IModel model) {
		setTitle(title);
		myModel = model;
		myCanvas = new Canvas(new Dimension(600, 600));// TODo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myChooser = new JFileChooser(System.getProperties().getProperty(
				USER_DIR));
		makeListeners();
		getContentPane().add(makeCommandCenter(), BorderLayout.SOUTH);
		getContentPane().add(new JSeparator());
		getContentPane().add(makeCommandHistory(), BorderLayout.WEST);
		getContentPane().add(new JSeparator());
		setJMenuBar(makeMenuBar());

		getContentPane().add(makeTurtleDisplay(), BorderLayout.CENTER);

		pack();
		setVisible(true);

	}

	public void showMessage(String message) {
		myTextArea.append(message + "\n");
		myTextArea.setCaretPosition(myTextArea.getText().length());
	}

	private JComponent makeCommandHistory() {
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());
		result.add(new JLabel("Command History"), BorderLayout.NORTH);
		myTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
		myTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(myTextArea);
		result.add(scrollPane);

		return result;

	}
	private JComponent makeTurtleDisplay(){
		JPanel result=new JPanel();
		JPanel state=new JPanel();
		state.setSize(10, 10);
		result.setBorder(BorderFactory.createLineBorder(Color.black));
		state.setBorder(BorderFactory.createLineBorder(Color.black));
		result.setLayout(new BoxLayout(result,BoxLayout.PAGE_AXIS));
		state.setLayout(new BoxLayout(state,BoxLayout.LINE_AXIS));
		result.add(myCanvas);
		
		myTurtleState=new JTextArea();
		myTurtleState.setEditable(false);
		state.add(myTurtleState);
		updateHeadingLabel(270);
		updatePositionLabel(new Location(0,0));
		result.add(state);
		return result;
		
	}

	private JComponent makeCommandCenter() {
		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result,BoxLayout.LINE_AXIS));
		
		result.add(new JLabel("Command-Line"));
		result.add(makeTextField());
		result.add(new JSeparator());
		result.add(makeClearButton());
		return result;
	}

	private JTextField makeTextField() {
		myTextField = new JTextField(FIELD_SIZE);
		myTextField.addKeyListener(myKeyListener);
		// result.addFocusListener(myFocusListener);
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String givenCommand = myTextField.getText();
				showMessage("Enter pressed" + "  the given Command is:  "
						+ givenCommand);
				// myModel.executeCommand(givenCommand);
				myTextField.setText("");

			}
		});
		return myTextField;
	}

	private JMenuBar makeMenuBar() {
		JMenuBar result = new JMenuBar();
		result.add(makeFileMenu());
		return result;

	}

	protected JMenu makeFileMenu() {
		JMenu result = new JMenu("File");
		result.add(new AbstractAction("LoadCommand") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int response = myChooser.showOpenDialog(null);
					if (response == JFileChooser.APPROVE_OPTION) {
						File file = myChooser.getSelectedFile();

						myModel.loadFunctionsAndVariables(file);
						showMessage("file loaded:  " + file.getName());
						echo(new FileReader(file));
					}
				} catch (IOException io) {
					// let user know an error occurred, but keep going
					showMessage(io.toString());
				}
			}
		});
		result.add(new AbstractAction("saveCommand") {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int response = myChooser.showOpenDialog(null);
					if (response == JFileChooser.APPROVE_OPTION) {
						File file = myChooser.getSelectedFile();

						myModel.saveFunctionsAndVariables(file);
						showMessage("file saved at:  " + file.getName());
						echo(new FileReader(file));
					}
				} catch (IOException io) {
					// let user know an error occurred, but keep going
					showMessage(io.toString());
				}
			}
		});
		result.add(new JSeparator());
		result.add(new AbstractAction("Quit") {
			@Override
			public void actionPerformed(ActionEvent e) {
				// clean up any open resources, then
				// end program
				System.exit(0);
			}
		});
		return result;
	}

	private JButton makeClearButton() {
		myClearButton = new JButton("Clear");
		myClearButton.addMouseListener(myMouseListener);
		myClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCommandWindow();
			}
		});
		myClearButton.setActionCommand("clear");
		return myClearButton;

	}

	private void echo(Reader r) {
		try {
			String s = "";
			BufferedReader input = new BufferedReader(r);
			String line = input.readLine();
			while (line != null) {
				s += line + "\n";
				line = input.readLine();
			}
			showMessage(s);
		} catch (IOException e) {
			showMessage(e.toString());
		}
	}

	protected void makeListeners() {
		myKeyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
		};
		myMouseListener = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}
		};

	}

	private void echo(String s, KeyEvent e) {
		showMessage(s + " char:" + e.getKeyChar() + " mod: "
				+ KeyEvent.getKeyModifiersText(e.getModifiers()) + " mod: "
				+ KeyEvent.getKeyText(e.getKeyCode()));
	}

	public void returnMessage(String message) {
	}

	public void clearCommandWindow() {
		myTextArea.setText("");
	}

	public void updatePositionLabel(Location location) {
		myTurtlePositionLabel=" current turtle position: ( "+location.getX()+" , "+location.getY()+" )      ";
		updateTurtleState();
		
	}

	private void updateTurtleState() {
		myTurtleState.setText(myTurtlePositionLabel+myTurtleHeadingLabel);
	}

	public void updateHeadingLabel(int heading) {
		myTurtleHeadingLabel="     current heading direction: "+heading+" degrees";
		updateTurtleState();
	}

	public void setModel(IModel model) {
		myModel = model;
	}

	public static void main(String[] args) {
		Model model = new Model();
		new View("SLogo", model);
	}

}
