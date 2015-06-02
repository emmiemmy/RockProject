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

	UserController controller = new UserController();
	String[] bandList = { "Metallica", "Nirvana", "Greenday", "Muse", "Oasis" };
	String[] nirvanaList = { "Kurt Cobain1", "Kurt Cobain2" };
	String[] metallicaList = { "Metallica1", "Metallica2", "Metallica3" };

	private JButton btnClear = new JButton("Ny sökning");
	private JButton btnShowSchedule = new JButton("Hämta spelschema");

	JTextArea textArea = new JTextArea();
	JComboBox combo_box_medlem = new JComboBox();

	private JFrame frame;

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

		controller = new UserController();

		JComboBox combo_box_band = new JComboBox(bandList);
		combo_box_band.setBounds(6, 54, 190, 27);
		frame.getContentPane().add(combo_box_band);
		combo_box_band.addActionListener(new ComboBox());

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

			textArea.setText("Här visas " + choice
					+ "och information om bandet");
			combo_box_medlem.removeAllItems();
			combo_box_medlem.addItem(null);

			if (choice.equals("Nirvana")) {
				for (String name : nirvanaList)
					combo_box_medlem.addItem(name);

			}
			if(choice.equals("Metallica")){
				for (String name : metallicaList)
					combo_box_medlem.addItem(name);
			}
		}

	}

	/**
	 * 
	 * @author emmashakespeare Lyssnare som hämtar information om medlem
	 */
	public class ComboBox_medlem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			String choice = (String) cb.getSelectedItem();
			System.out.println(choice);
			String[] medlemInfo = new String[1];
			medlemInfo = controller.getMemberInfo(choice);// Metod som
															// returnerar en
															// sträng[2] som
															// innehåller
															// info om vald
															// medlem
			textArea.setText("Namn:" + medlemInfo[0] + "\n" + "Partytrick:"
					+ medlemInfo[1]);

		}

	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnClear)
				textArea.setText("");
			if (e.getSource() == btnShowSchedule) {
				LinkedList<String> schema = new LinkedList<String>();
				schema = controller.getBandSchedule();// Metod som hämtar
														// bandschema för
				// specifikt
				// band
				textArea.setText("Band: " + schema.get(0) + "\nScen: "
						+ schema.get(1) + "\nDag och tid:");
			}
		}
	}
}
