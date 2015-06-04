package project;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewBand extends JPanel{
	/**
	 * @wbp.nonvisual location=-37,431
	 */
	private final JSpinner spinner = new JSpinner();
	private JTextField tfBandName;
	private JTextField tfCountry;
	private JTextField tfType;
	private JTextField tfMember;
	AdminController controller;
	
	public NewBand(AdminController controller){
		setPreferredSize(new Dimension(274, 332));
		setLayout(null);
		
		this.controller = controller;
		JLabel lblCountry = new JLabel("Land:");
		lblCountry.setBounds(16, 75, 83, 16);
		add(lblCountry);
		
		JLabel lblBandName = new JLabel("Bandnamn:");
		lblBandName.setBounds(16, 41, 83, 16);
		add(lblBandName);
		
		JLabel lblType = new JLabel("Genre:");
		lblType.setBounds(16, 109, 83, 16);
		add(lblType);
		
		tfBandName = new JTextField();
		tfBandName.setBounds(94, 35, 149, 28);
		add(tfBandName);
		tfBandName.setColumns(10);
		
		tfCountry = new JTextField();
		tfCountry.setBounds(94, 69, 149, 22);
		add(tfCountry);
		tfCountry.setColumns(10);
		
		tfType = new JTextField();
		tfType.setBounds(94, 103, 149, 28);
		add(tfType);
		tfType.setColumns(10);
		
		JButton btnLggTillBand = new JButton("Lägg till band");
		btnLggTillBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.insertBandCont(tfBandName.getText(), tfType.getText(), tfCountry.getText());
			}
		});
		btnLggTillBand.setBounds(94, 143, 142, 28);
		add(btnLggTillBand);
		
		JButton btnAddMember = new JButton("Lägg till medlem");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddMember.setBounds(94, 224, 149, 28);
		add(btnAddMember);
		
		tfMember = new JTextField();
		tfMember.setBounds(94, 184, 149, 28);
		add(tfMember);
		tfMember.setColumns(10);	

	}
	
//	public static void main(String[] args){
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new NewBand());
//		frame.pack();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);		
//	}
}


