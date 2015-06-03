package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class AdminUIWB {
	
	private JButton btnNewButton = new JButton("Boka");


	private JFrame frame;

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
		
		btnNewButton.setBounds(10, 306, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(293, 162, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblNewLabel = new JLabel("Boka band och spelning");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 159, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lägg till kontaktperson");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(293, 12, 159, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblVljBand = new JLabel("Välj band:");
		lblVljBand.setBounds(10, 36, 89, 14);
		frame.getContentPane().add(lblVljBand);
		
		JLabel lblVljBand_1 = new JLabel("Välj band:");
		lblVljBand_1.setBounds(293, 37, 89, 14);
		frame.getContentPane().add(lblVljBand_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 61, 159, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(293, 62, 159, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblVljScen = new JLabel("Välj scen:");
		lblVljScen.setBounds(10, 92, 46, 14);
		frame.getContentPane().add(lblVljScen);
		
		JLabel lblVljKontaktperson = new JLabel("Välj kontaktperson:");
		lblVljKontaktperson.setBounds(293, 93, 159, 14);
		frame.getContentPane().add(lblVljKontaktperson);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 117, 159, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(293, 118, 159, 20);
		frame.getContentPane().add(comboBox_3);
	}
}
