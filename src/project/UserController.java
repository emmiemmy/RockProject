package project;

import java.util.LinkedList;

/**
 * 
 * @author emmashakespeare Metoderna i Controllern anropar metoder i DB klassen
 *         som returnerar Linked Lists innehållande önskad information
 */
public class UserController {

	DatabaseConnector db = new DatabaseConnector();
	UserUI2 ui;

	public UserController(UserUI2 userUI2) {//ANVÄNDS EJ ÄNNU
		ui = userUI2;
		db.setUserUI(userUI2);
	}

	/**
	 * Metod som hämtar bandschema för valt band: band, scen och tidpunkt EJ KLAR!!!
	 */
	public void getBandSchedule(String bandNamn) {

	}

	/**
	 * Skickar information om vilket band som DB skall hämta info om: Namn, KLAR, FUNGERAR
	 * Ursprungsland, Muskgenre, Medlemmar
	 * 
	 * @param bandNamn
	 */
	public void getBandInfo(String bandNamn) {
		db.getBandInfo(bandNamn);

	}

	/**
	 * @param choice
	 *            - Medlem som det skall hämtas information om DB-klassen lägger KLAR; FUNGERAR
	 *            in info i ui
	 */
	public void getMemberInfo(String medlem) {
		db.getMemberInfo(medlem);// metod i DB som skriver ut info om medlem
	}

	/**
	 * Metoden anropar metod i db klassen som returnerar en lista på alla band KLAR FUNGERAR, /////Återanvänd i Admincontroller!!!
	 * och lägger in dessa i ui combo_boxes
	 */
	public void getBandList() {
		ui.populateBandBox(db.getBandList());
	}
}