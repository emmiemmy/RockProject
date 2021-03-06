package project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUIWB {
	private JFrame frame;
	private JButton btnBook = new JButton("Boka");
	private JButton btnOK = new JButton("OK");
	private JButton btnList = new JButton("Skapa lista");
	private JButton btnNewBand = new JButton("Lägg till band");
	private JLabel lblBookAGig = new JLabel("Boka band och spelning");
	private JLabel lblAddPerson = new JLabel("Lägg till kontaktperson");
	private JLabel lblContactperson = new JLabel("Välj kontaktperson:");
	private JLabel lblBand = new JLabel("Välj band:");
	private JLabel lblBandForPerson = new JLabel("Välj band:");
	private JLabel lblStage = new JLabel("Välj scen:");
	private JLabel lblDay = new JLabel("Välj dag:");
	private JLabel lblTime = new JLabel("Välj tid:");
	private JLabel lblListContact = new JLabel("Lista Kontaktersoner och antal medlemmar:");
	JLabel lblConfirmBand = new JLabel("");
	JLabel lblConfirmPerson = new JLabel("");
	private JComboBox cmbBandA = new JComboBox();
	private JComboBox cmbBandContact = new JComboBox();
	private JComboBox cmbStage = new JComboBox();
	private JComboBox cmbContact = new JComboBox();
	private JComboBox cmbDay = new JComboBox();
	private JComboBox cmbTime = new JComboBox();
	private String bandName, stage, day, time, employee, bandNameContact;
	JTextArea textArea = new JTextArea();

	AdminController controller;
	private final JButton btnClear = new JButton("Rensa");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUIWB window = new AdminUIWB();
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
	public AdminUIWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		controller = new AdminController(this);

		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.insertBooking(bandName, stage, day, time);
				System.out.println("INSERT INTO DB : " + bandName + " " + stage
						+ " " + day + " " + time);
			}
		});

		btnBook.setBounds(10, 275, 100, 23);
		frame.getContentPane().add(btnBook);
		
		btnNewBand.setBounds(369, 508, 150, 23);
		frame.getContentPane().add(btnNewBand);
		
		btnNewBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.getContentPane().add(new NewBand(controller));
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);	
			}
		});

		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.insertContact(bandNameContact, employee);// SKAPA
																	// METOD I
																	// CONTROLLER
																	// OCH DB
			}
		});

		btnOK.setBounds(10, 474, 100, 23);
		frame.getContentPane().add(btnOK);

		lblBookAGig.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBookAGig.setBounds(10, 11, 159, 14);
		frame.getContentPane().add(lblBookAGig);

		lblAddPerson.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddPerson.setBounds(10, 309, 159, 14);
		frame.getContentPane().add(lblAddPerson);

		lblBand.setBounds(10, 36, 89, 14);
		frame.getContentPane().add(lblBand);

		lblBandForPerson.setBounds(10, 334, 89, 14);
		frame.getContentPane().add(lblBandForPerson);

		cmbBandA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String choice = (String) cb.getSelectedItem();
				bandName = choice;
				if (!choice.equals("Välj band"))
					controller.getStageList();

			}
		});

		cmbBandA.setBounds(10, 61, 159, 20);
		frame.getContentPane().add(cmbBandA);
		controller.getBandList();

		cmbBandContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String choice = (String) cb.getSelectedItem();
				bandNameContact = choice;
				controller.getEmployeesList();
			}
		});

		cmbBandContact.setBounds(10, 360, 159, 20);
		frame.getContentPane().add(cmbBandContact);

		lblStage.setBounds(10, 92, 60, 14);
		frame.getContentPane().add(lblStage);

		lblContactperson.setBounds(10, 400, 159, 14);
		frame.getContentPane().add(lblContactperson);

		cmbStage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String choice = (String) cb.getSelectedItem();
				stage = choice;

				if (choice != ("Välj scen")) {
					controller.getStageAvailDay(stage);
					System.out.println("cmbStage");
				}
			}
		});

		cmbStage.setBounds(10, 117, 159, 20);
		frame.getContentPane().add(cmbStage);

		cmbContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String choice = (String) cb.getSelectedItem();
				employee = choice;
			}
		});

		cmbContact.setBounds(10, 429, 159, 20);
		frame.getContentPane().add(cmbContact);

		lblDay.setBounds(10, 148, 60, 14);
		frame.getContentPane().add(lblDay);

		cmbDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String choice = (String) cb.getSelectedItem();
				day = choice;
				System.out.println("Dag:" + day);
				controller.getStageAvailTime(stage, day);
			}
		});

		cmbDay.setBounds(10, 175, 159, 20);
		frame.getContentPane().add(cmbDay);

		lblTime.setBounds(10, 206, 89, 14);
		frame.getContentPane().add(lblTime);

		cmbTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String choice = (String) cb.getSelectedItem();
				time = choice;

			}
		});

		cmbTime.setBounds(10, 231, 159, 20);
		frame.getContentPane().add(cmbTime);

		lblListContact.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListContact.setBounds(269, 11, 270, 14);
		frame.getContentPane().add(lblListContact);

		/**
		 * Knapp som hämtar
		 */
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.getBandContactList();
			}
		});

		btnList.setBounds(546, 8, 100, 23);
		frame.getContentPane().add(btnList);

		textArea.setBounds(202, 70, 561, 420);
		frame.getContentPane().add(textArea);
		lblConfirmBand.setBounds(133, 279, 115, 14);

		frame.getContentPane().add(lblConfirmBand);
		lblConfirmPerson.setBounds(123, 478, 125, 14);

		frame.getContentPane().add(lblConfirmPerson);
		
		JButton btnEraseLabels = new JButton("Lägg till ny");
		btnEraseLabels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblConfirmBand.setText("");
				lblConfirmPerson.setText("");
			}
		});
		btnEraseLabels.setBounds(10, 508, 100, 23);
		frame.getContentPane().add(btnEraseLabels);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setBounds(269, 508, 100, 23);
		
		frame.getContentPane().add(btnClear);
		
		JButton btnListaSkerhetsansvariga = new JButton("Lista säkerhetsansvariga");
		btnListaSkerhetsansvariga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(" ");
				controller.getSecurityList();
			}
		});
		btnListaSkerhetsansvariga.setBounds(273, 533, 227, 29);
		frame.getContentPane().add(btnListaSkerhetsansvariga);
	}

	public void populateBandBox(LinkedList<String> s) {
		cmbBandA.addItem("Välj band");
		for (String name : s) {
			cmbBandA.addItem(name);
		}
	}

	public void populateStageBox(LinkedList<String> s) {
		System.out.println("Adminui: populateStageBox()");
		cmbStage.removeAllItems();

		cmbStage.addItem("Välj scen");
		for (String name : s) {
			cmbStage.addItem(name);
		}
	}

	public void populateDayBox(LinkedList<String> s) {
		cmbDay.removeAllItems();

		cmbDay.addItem("Välj dag");
		for (String name : s) {
			cmbDay.addItem(name);
		}
	}

	public void populateTimeBox(LinkedList<String> s) {
		cmbTime.removeAllItems();

		cmbTime.addItem("Välj tidpunkt");
		for (String name : s) {
			cmbTime.addItem(name);
		}
	}

	public void populateBandBox2(LinkedList<String> s) {
		cmbBandContact.removeAllItems();

		cmbBandContact.addItem("Välj band");
		for (String name : s) {
			cmbBandContact.addItem(name);
		}
	}

	public void populateContactBox(LinkedList<String> s) {
		cmbContact.removeAllItems();

		cmbContact.addItem("Välj kontaktperson");
		for (String name : s) {
			cmbContact.addItem(name);
		}
	}
}
