package project;

import java.util.LinkedList;

public class UserController {
	
	DatabaseConnector db = new DatabaseConnector();

	/**
	 * Metod som hämtar band schema från DB
	 */
	public LinkedList getBandSchedule() {
		
		LinkedList<String> s = new LinkedList<String>();
		s.add("Nirvana");
		s.add("DieselStudion");
		s.add("Torsdag 18.00-20.00");
		return s;
	}
	
	public LinkedList getBandInfo(String bandNamn){
		LinkedList<String> s = new LinkedList<String>();
		return s;
	
	}

	public String[] getMemberInfo(String choice) {
		String[]  s = {"Cobbe", "Spela på elgitarr upp och ner"};
		return s;
	}

}
