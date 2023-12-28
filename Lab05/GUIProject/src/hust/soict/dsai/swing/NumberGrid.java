package hust.soict.dsai.swing;


import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
// Number Grid using Swing
public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10]; // array for the digit buttons
	private JButton btnDelete, btnReset; // buttons for the DEL button and for the C button
	private JTextField tfDisplay; // top display
	// constructor to set up the GUI components and event handlers
	public NumberGrid() {
		// A JTextField for the display text field
		tfDisplay = new JTextField(); // text field for output
		// set orientation to RIGHT_TO_LEFT which mean number
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// A JPanel, which will group all of the buttons and put them in a grid layout
		JPanel panelButtons = new JPanel(new GridLayout(4, 3)); // set layout to GridLayout
		addButtons(panelButtons); // add buttons to it
		//
		Container cp = getContentPane(); // get the content-pane of the top-level container
		cp.setLayout(new BorderLayout()); // set layout so that there will be no gap between components
		cp.add(tfDisplay, BorderLayout.NORTH); // add tfDisplay to the North of the stage
		cp.add(panelButtons, BorderLayout.CENTER); // add panelButtons to the Center of the stage

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set it close on clicking exit
		setTitle("Nguyen Xuan Hung 's Number Grid"); // set title
		setSize(200, 200); // set size
		setVisible(true); // set visible
	}
	public static void main(String[] args) {
		new NumberGrid();
	}
	// method to add buttons
	void addButtons(JPanel panelButtons ) {
		ButtonListener btnListener = new ButtonListener();
		// add 1-9 buttons
		for (int i = 1; i <= 9; i++) {
			btnNumbers[i] = new JButton("" + i); // create new button
			panelButtons.add(btnNumbers[i]); // add it to the panel
			btnNumbers[i].addActionListener(btnListener); // add listener to it
		}
		// add Delete button
		btnDelete = new JButton("DEL"); // create new button
		panelButtons.add(btnDelete); // add it to the panel
		btnDelete.addActionListener(btnListener); // add listener to it
		// add 0 button
		btnNumbers[0] = new JButton("0"); // create new button
		panelButtons.add(btnNumbers[0]); // add it to the panel
		btnNumbers[0].addActionListener(btnListener); // add listener to it
		// add Reset button
		btnReset = new JButton("C"); // create new button
		panelButtons.add(btnReset); // add it to the panel
		btnReset.addActionListener(btnListener); // add listener to it
	}
	// event handler
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand(); // parse the input button
			// if it belong to 0-9 then add it to the right and display the string
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			// if it is delete button, display the substring from the first to last - 1
			else if (button.equals("DEL")) {
				String tmp = tfDisplay.getText(); // get the old text
				tfDisplay.setText(tmp.substring(0, tmp.length() - 1)); // return new text
			}
			// if it is reset button, display ""
			else {
				tfDisplay.setText("");
			}
		}
	}
}
