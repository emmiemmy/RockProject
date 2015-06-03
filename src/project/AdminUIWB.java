package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JComboBox;

public class AdminUIWB {
	private JFrame frame;
	private JButton btnBook = new JButton("Boka");
	private JButton btnOK = new JButton("OK");
	private JLabel lblBookAGig = new JLabel("Boka band och spelning");
	private JLabel lblAddPerson = new JLabel("Lägg till kontaktperson");
	private JLabel lblContactperson = new JLabel("Välj kontaktperson:");
	private JLabel lblBand = new JLabel("Välj band:");
	private JLabel lblBandForPerson = new JLabel("Välj band:");
	private JLabel lblStage = new JLabel("Välj scen:");
	private JLabel lblDay = new JLabel("Välj dag:");
	private JLabel lblTime = new JLabel("Välj tid:");
	private JLabel lblConfirmBand = new JLabel("");
	private JLabel lblConfirmPerson = new JLabel("");
	private JComboBox cmbBandA = new JComboBox();
	private JComboBox cmbBandContact = new JComboBox();
	private JComboBox cmbStage = new JComboBox();
	private JComboBox cmbContact = new JComboBox();
	private JComboBox cmbDay = new JComboBox();
	private JComboBox cmbTime = new JComboBox();
	private String bandName, stage, day, time;

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
		frame.setBounds(100, 100, 538, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnBook.setBounds(10, 275, 89, 23);
		frame.getContentPane().add(btnBook);
		
		btnOK.setBounds(293, 162, 89, 23);
		frame.getContentPane().add(btnOK);
		
		lblBookAGig.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBookAGig.setBounds(10, 11, 159, 14);
		frame.getContentPane().add(lblBookAGig);
		
		lblAddPerson.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddPerson.setBounds(293, 12, 159, 14);
		frame.getContentPane().add(lblAddPerson);
		
		lblBand.setBounds(10, 36, 89, 14);
		frame.getContentPane().add(lblBand);
		
		lblBandForPerson.setBounds(293, 37, 89, 14);
		frame.getContentPane().add(lblBandForPerson);
		
		cmbBandA.setBounds(10, 61, 159, 20);
		frame.getContentPane().add(cmbBandA);
		
		cmbBandContact.setBounds(293, 62, 159, 20);
		frame.getContentPane().add(cmbBandContact);
		
		lblStage.setBounds(10, 92, 60, 14);
		frame.getContentPane().add(lblStage);
		
		lblContactperson.setBounds(293, 93, 159, 14);
		frame.getContentPane().add(lblContactperson);
		
		cmbStage.setBounds(10, 117, 159, 20);
		frame.getContentPane().add(cmbStage);
		
		cmbContact.setBounds(293, 118, 159, 20);
		frame.getContentPane().add(cmbContact);
		
		lblDay.setBounds(10, 148, 60, 14);
		frame.getContentPane().add(lblDay);
		
		cmbDay.setBounds(10, 175, 159, 20);
		frame.getContentPane().add(cmbDay);
		
		lblTime.setBounds(10, 206, 89, 14);
		frame.getContentPane().add(lblTime);
		
		cmbTime.setBounds(10, 231, 159, 20);
		frame.getContentPane().add(cmbTime);
		
		lblConfirmBand.setBounds(10, 309, 46, 14);
		frame.getContentPane().add(lblConfirmBand);
		
		lblConfirmPerson.setBounds(293, 206, 46, 14);
		frame.getContentPane().add(lblConfirmPerson);
	}
	
	public void populateBandBox(LinkedList<String> s) {
		cmbBandA.addItem("Välj band");
		for (String name : s) {
			cmbBandA.addItem(name);

		}

	}
	
	public void populateStageBox(LinkedList<String> s) {
		cmbStage.addItem("Välj scen");
		for (String name : s) {
			cmbStage.addItem(name);

		}

	}
	
	public void populateDayBox(LinkedList<String> s) {
		cmbDay.addItem("Välj dag");
		for (String name : s) {
			cmbDay.addItem(name);

		}

	}
	
	
	public void populateTimeBox(LinkedList<String> s) {
		cmbTime.addItem("Välj tidpunkt");
		for (String name : s) {
			cmbTime.addItem(name);

		}

	}
	
	
	public void populateBandBox2(LinkedList<String> s) {
		cmbBandContact.addItem("Välj band");
		for (String name : s) {
			cmbBandContact.addItem(name);

		}

	}
	
	public void populateContactBox(LinkedList<String> s) {
		cmbContact.addItem("Välj kontaktperson");
		for (String name : s) {
			cmbContact.addItem(name);

		}

	}
	
	
	
	
}
