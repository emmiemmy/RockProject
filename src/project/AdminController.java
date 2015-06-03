package project;

import java.util.LinkedList;

public class AdminController {
	
	DatabaseConnector db = new DatabaseConnector();
	AdminUIWB ui;

	public AdminController(AdminUIWB ui) {
		this.ui = ui;
		db.setAdminUI(ui);
	}
	
	/**
	 * Metoden sätter in band i dropmenyn i ui
	 */
	public void getBandList(){
		LinkedList<String> s = new LinkedList<String>();
		ui.populateBandBox(db.getBandList());
	}
	
	/**
	 * Metoden hämtar en lista på alla scener
	 */
	public void getStageList(){
		ui.populateStageBox(db.getStageList());//IMPLEMENTERA DB METOD
		//Returnerar lista med samtliga scener
	}
	
	/**
	 * Metoden hämtar en lista på tillgängliga dagar för vald scen
	 * @param - scen som 
	 * uppdaterar cmbDays med dagar som är tillgängliga
	 */
	
	public void getStageAvailDay(String stage){
		ui.populateDayBox(db.getDayList(stage));//IMPLEMENTERA DB METOD
		//Returnerar lista med tillgängliga dagar för vald scen
		
	}
	/**
	 * Metoden hämtar en lista på tillgängliga pass för vald scen 
	 * och vald dag 
	 * @param scen -vald scen
	 * @param day - vald dag
	 * uppdaterar cmbTime med tidpunkter som är tillgängliga för bokning
	 */
	public void getStageAvailTime(String stage, String day){
		ui.populateTimeBox(db.getTimeList(stage, day));//IMPLEMENTERA DB METOD
		//Returnerar lista med tillgängliga tidpunkter för vald dag
	}
	
	public void getEmployeesList(){
		ui.populateContactBox(db.getEmployeeList());//IMPLEMENTERA DB METOD
	}
	
	public void insertBooking(String bandName, String stage, String day, String time){
		db.insertBooking(bandName, stage, day, time);//Insert information i respektive tabeller
		//IMPLEMENTERA DB METOD
	}
	
	

}
