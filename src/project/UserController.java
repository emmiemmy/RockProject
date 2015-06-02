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
	Information info = new Information();

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
		db.getBandDatabase(bandNamn);
		return s;
	
	}
/**
 * Hämtar en lista med information om specifik medlem
 * @param choice - Medlem som det skall hämtas information om
 * @return
 */
	public LinkedList getMemberInfo(String medlem) {
		LinkedList<String> s = new LinkedList<String>();
		//s = db.getMemberDatabase(medlem);//metod i DB som returnerar Länkad lista med information om medlemmen
		return s;
	}
	

}
