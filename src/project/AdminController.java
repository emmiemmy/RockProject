package project;

public class AdminController {
	
	DatabaseConnector db = new DatabaseConnector();
	AdminUIWB ui;

	public AdminController(AdminUIWB ui) {//ANVÄNDS EJ ÄNNU
		ui = ui;
		db.setUI(ui);
	}

/**
 * 
 */
}
