import java.awt.BorderLayout;
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
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.IModel;
import model.Model;

import util.Location;

public class View extends JFrame implements IView {
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	private static final String USER_DIR = "user.dir";
	private static final int FIELD_SIZE = 30;

	private JTextArea myTextArea;
	private JTextField myTextField;
	private JFileChooser myChooser;
	private ResourceBundle myResources;
	private ActionListener myActionListener;
	private KeyListener myKeyListener;
	private FocusListener myFocusListener;
	private JComponent myCanvas;

	private IModel myModel;

	public View(String title, IModel model) {
		setTitle(title);
		myModel = model;
		myCanvas = new Canvas(new Dimension(300, 300));// TODO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myChooser = new JFileChooser(System.getProperties().getProperty(
				USER_DIR));
		makeListeners();
		getContentPane().add(makeCommandHistory(), BorderLayout.WEST);
		getContentPane().add(makeTextField(), BorderLayout.SOUTH);
		getContentPane().add(myCanvas, BorderLayout.CENTER);

		pack();
		setVisible(true);

	}

	public void showMessage(String message) {
		myTextArea.append(message + "\n");
		myTextArea.setCaretPosition(myTextArea.getText().length());
	}

	private JComponent makeCommandHistory() {
		myTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
		myTextArea.setEditable(false);
		return new JScrollPane(myTextArea);

	}

	protected JTextField makeTextField() {
		myTextField = new JTextField(FIELD_SIZE);
		myTextField.addKeyListener(myKeyListener);
		// result.addFocusListener(myFocusListener);
		myTextField.addActionListener(myActionListener);
		return myTextField;
	}

	protected void makeListeners() {
		myKeyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// echo("pressed", e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					String givenCommand = myTextField.getText();
					showMessage("Enter pressed" + "  the given Command is:  "
							+ givenCommand);
					// myModel.executeCommand(givenCommand);
					myTextField.setText("");
				}
				// echo("released", e);
			}

			@Override
			public void keyTyped(KeyEvent e) {

				// echo("typed", e);
			}
		};
		// listener for low-level mouse events

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
	}

	public void updateHeadingLabel(int heading) {
	}

	public void setModel(IModel model) {
		myModel=model;
	}

	public static void main(String[] args) {
		Model model = new Model();
		new View("SLogo", model);
	}

}
