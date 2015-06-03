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
		ui.populateBandBox(db.getBandList());//Ej ännu implementerad
	}
	
	/**
	 * Metoden hämtar en lista på alla scener
	 */
	public void getStageList(){
		ui.populateStageBox();
		db.getStageList();//Returnerar lista med samtliga scener
	}
	
	/**
	 * Metoden hämtar en lista på tillgängliga dagar för vald scen
	 * @param - scen som 
	 * uppdaterar cmbDays med dagar som är tillgängliga
	 */
	
	public void getStageAvailDay(String stage){
		ui.populateDayBox();
		db.getDayList(stage);//Returnerar lista med tillgängliga dagar för vald scen
		
	}
	/**
	 * Metoden hämtar en lista på tillgängliga pass för vald scen 
	 * och vald dag 
	 * @param scen -vald scen
	 * @param day - vald dag
	 * uppdaterar cmbTime med tidpunkter som är tillgängliga för bokning
	 */
	public void getStageAvailTime(String stage, String day){
		ui.populateTimeBox();
		db.getTimeList(scen, day);//Returnerar lista med tillgängliga tidpunkter för vald dag
	}
	
	public void insertBooking(String bandName, String stage, String day, String time){
		db.insertBooking(bandName, stage, day, time);//Insert information i respektive tabeller
	}
	
	

}
