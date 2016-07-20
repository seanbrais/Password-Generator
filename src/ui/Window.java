package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> invalidIntegers = new ArrayList<Integer>();
	private JTextField passwordLabel = new JTextField(30);
	private int passwordLength = 8;
	JTextField sizeField = new JTextField(30);

	public Window(ArrayList<Integer> invalidIntegers) {
		this.invalidIntegers = invalidIntegers;

		Container panel1 = checkBoxContainer(this.invalidIntegers,
				Component.TOP_ALIGNMENT);
		Container panel2 = attributesContainer(Component.TOP_ALIGNMENT);
		Container panel3 = passwordContainer(Component.CENTER_ALIGNMENT);

		setLayout(new GridLayout(1, 3));
		add(panel1);
		add(panel2);
		add(panel3);

		setSize(1200, 300);
		setVisible(true);
	}

	private Container checkBoxContainer(ArrayList<Integer> invalidCharacters,
			float alignment) {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory
				.createTitledBorder("Characters to include"));
		GridLayout layout = new GridLayout(4, 4);
		System.out.println(invalidCharacters.size());
		container.setLayout(layout);
		for (int i = 0; i < invalidCharacters.size(); i++) {
			int invalidInt = invalidCharacters.get(i);
			char character = (char) invalidInt;
			JCheckBox check = new JCheckBox();
			check.addActionListener(new CheckBoxHandler(this, invalidInt));
			check.setText("" + character);
			check.setAlignmentX(alignment);
			container.add(check);
		}
		return container;
	}

	private Container attributesContainer(float alignment) {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder("Attributes"));
		GridLayout layout = new GridLayout(2, 2);
		container.setLayout(layout);
		JPanel panel = new JPanel();
		JLabel text = new JLabel("Size");
		panel.add(text);
		panel.add(sizeField);
		container.add(panel);
		JButton button = new JButton("Generate Password");
		button.addActionListener(new GenerateHandler(this));
		container.add(button);
		return container;
	}

	private Container passwordContainer(float alignment) {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder("Password"));
		BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
		container.add(passwordLabel);
		passwordLabel.setSize(100, 100);
		Font font = new Font("SansSerif", Font.BOLD, 20);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(font);
		container.setLayout(layout);
		return container;
	}

	public ArrayList<Integer> getInvalidIntegerList() {
		return invalidIntegers;
	}

	public void removeInt(int value) {
		int indexOf = invalidIntegers.indexOf(value);
		invalidIntegers.remove(indexOf);
	}

	public void addInt(int value) {
		invalidIntegers.add(value);
	}

	public void setPasswordText(String passwordText) {
		passwordLabel.setText(passwordText);
	}

	public int getPasswordLength() {
		return passwordLength;
	}

	public void setPasswordLength(int length) {
		passwordLength = length;
	}

	public void setSizeLabelText(int size) {
		sizeField.setText("" + size);
	}

	public int getSizeLabelText() {
		return Integer.parseInt(sizeField.getText());
	}
}
