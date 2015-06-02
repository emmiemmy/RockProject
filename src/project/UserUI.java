package project;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.*;

 class UserUI extends JPanel{
	 String[] bandString = {"Nirvana", "Suede", "Metallica", "Greenday"};//temp
	 private JComboBox bandBox = new JComboBox(bandString);
	 
	 
/**
 * Här startas User appen där användaren kan söka efter information i databasen.
 * Det finns diverse dropdown menyer och knappar för önskad sökning samt ett textfält 
 * som visar resultatet hämtat från databasen.
 * 
 * Besökarkrav
 *Söka bandinformation, vilket band som spelar på vilken scen vid vilken tidpunkt.
 *Söka spelschema för band, välj bandnamn från dropmeny och se ursprungsland, musikstil, bandmedlemmar.
 *Söka information om enskilda medlemmar genom att klicka på namnen.
 *Dropmenyerna skall uppdateras med aktuell information i databasen. 
 */
	 
	 public UserUI(){
			setPreferredSize(new Dimension(800, 600));
			setLayout(new FlowLayout());
			bandBox.setSelectedIndex(0);
			

	 }
	
	
	
	
	
	
	public static void main(String[]args){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new UserUI());
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		
	}
}
