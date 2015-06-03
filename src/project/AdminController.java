package project;

import java.util.LinkedList;

public class AdminController {
	
	DatabaseConnector db = new DatabaseConnector();
	AdminUIWB ui;

	public AdminController(AdminUIWB ui) {
		ui = ui;
		db.setAdminUI(ui);
	}
	
	/**
	 * Metoden sätter in band i dropmenyn i ui
	 */
	public void getBandList(){
		LinkedList<String> s = new LinkedList<String>();
		ui.populateBandBox();//Ej ännu implementerad
		db.getBandList();
	}
	
	/**
	 * Metoden hämtar en lista på alla scener
	 */
	public void getStageList(){
		
	}
	
	/**
	 * Metoden hämtar en lista på tillgängliga dagar för vald scen
	 * @param - scen som 
	 * uppdaterar combo_box med dagar som är tillgängliga
	 */
	
	public void getStageAvailDay(String scen){
		
	}
	/**
	 * Metoden hämtar en lista på tillgängliga pass för vald scen 
	 * och vald dag 
	 * @param scen -vald scen
	 * @param dag - vald dag
	 * uppdaterar combo_box_
	 */
	public void getStageAvailTime(String scen, String dag){
		
	}

}
