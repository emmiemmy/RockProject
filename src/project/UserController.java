package project;

import java.util.LinkedList;

/**
 * 
 * @author emmashakespeare
 * Metoderna i Controllern anropar metoder i DB klassen som returnerar 
 * Linked Lists innehållande önskad information
 */
public class UserController {
	
	DatabaseConnector db = new DatabaseConnector();
	UserUI2 ui ;
	Information info = new Information();
	

	public UserController(UserUI2 userUI2) {
		ui = userUI2;
		db.setUI(userUI2);
	}
	/**
	 * Metod som hämtar bandschema för valt band
	 */
	public LinkedList getBandSchedule(String bandNamn) {
		//länkad lista innehåller Scen, Dag och tidpunkt
		LinkedList<String> s = new LinkedList<String>();
		
		return s;
	}
	/**
	 * Hämtar en lista med information om bandet: Namn, Ursprungsland, Muskgenre, Medlemmar
	 * @param bandNamn
	 * @return
	 */
	public LinkedList getBandInfo(String bandNamn){
		LinkedList<String> s = new LinkedList<String>();
		db.getBandInfo(bandNamn);
		return s;
	
	}
/**
 * Hämtar en lista med information om specifik medlem
 * @param choice - Medlem som det skall hämtas information om
 * @return
 */
	public void getMemberInfo(String medlem) {
		db.getMemberInfo(medlem);//metod i DB som skriver ut info om medlem
	}
	
	public void getBandList(){
		ui.populateBandBox(db.getBandList());
	}
	
	
	

}


