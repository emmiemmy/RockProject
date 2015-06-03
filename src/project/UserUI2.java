package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class UserUI2 {

	UserController controller;
	String band, medlem;

	private JButton btnClear = new JButton("Ny sökning");
	private JButton btnShowSchedule = new JButton("Hämta spelschema");

	JTextArea textArea = new JTextArea();
	JComboBox<String> combo_box_medlem = new JComboBox<String>();
	JComboBox<String> combo_box_band = new JComboBox<String>();

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI2 window = new UserUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		controller = new UserController(this);

		combo_box_band.setBounds(6, 54, 190, 27);

		frame.getContentPane().add(combo_box_band);
		combo_box_band.addActionListener(new ComboBox());
		controller.getBandList();// fyller i listan med band som finns i DB

		textArea.setBounds(215, 20, 367, 357);
		frame.getContentPane().add(textArea);

		btnClear.addActionListener(new ButtonListener());
		btnClear.setBounds(0, 350, 135, 27);
		frame.getContentPane().add(btnClear);

		combo_box_medlem.setBounds(6, 93, 190, 27);
		frame.getContentPane().add(combo_box_medlem);
		btnShowSchedule.setBounds(6, 147, 129, 27);
		btnShowSchedule.addActionListener(new ButtonListener());

		frame.getContentPane().add(btnShowSchedule);
		combo_box_medlem.addActionListener(new ComboBox_medlem());
	}

	public void populateBandBox(LinkedList<String> s) {
		combo_box_band.addItem("Välj band");
		for (String name : s) {
			combo_box_band.addItem(name);

		}

	}

	public void populateMemberBox(LinkedList<String> s) {
		combo_box_medlem.addItem("Medlemmar");
		for (String name : s) {
			combo_box_medlem.addItem(name);
		}

	}

	/**
	 * Lyssnare till ComboBoxen
	 * 
	 * @author emmashakespeare
	 *
	 */
	public class ComboBox implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			String choice = (String) cb.getSelectedItem();
			System.out.println(choice);
			band = choice;
			if (!choice.equals("Välj band")) {
				LinkedList<String> s = new LinkedList<String>();
				controller.getBandInfo(choice);
				combo_box_band.setEnabled(false);
				combo_box_medlem.setEnabled(true);

			}

		}

	}

	/**
	 * 
	 * @author emmashakespeare Lyssnare som hämtar information om medlem
	 */
	public class ComboBox_medlem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Combo_medlem");
			JComboBox cb = (JComboBox) e.getSource();
			String choice = (String) cb.getSelectedItem();
			System.out.println(choice);
			medlem = choice;
			if((choice!="Medlemmar" && choice!=null))
			controller.getMemberInfo(choice);// Metod som
												// returnerar en
												// LinkedList som
												// innehåller
												// info om vald
			// medlem

		}

	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnClear) {
				textArea.setText("");
				combo_box_band.setSelectedIndex(0);
				// combo_box_medlem.setSelectedIndex(0);
				combo_box_band.setEnabled(true);
				combo_box_medlem.setEnabled(false);
				combo_box_medlem.removeAllItems();

			}

			if (e.getSource() == btnShowSchedule) {
				textArea.setText("");
				controller.getBandSchedule(band);
			}
		}
	}
}
