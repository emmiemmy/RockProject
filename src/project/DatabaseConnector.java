package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class DatabaseConnector {

	private static Connection conn;
	private static Statement stat;
	private static ResultSet rs;
	private static final String DATABASE_URL = "jdbc:mysql://94.254.94.236:51515/rockproject";
	private static final String USERNAME = "Evelyn";
	private static final String PASSWORD = "emma";
	private UserController userController;
	private AdminController adminController;
	private UserUI2 userUI;
	private AdminUIWB adminUI;

	public void setControllers(UserController uc, AdminController ac) {
		userController = uc;
		adminController = ac;
	}

	public void setUserUI(UserUI2 ui) {
		this.userUI = ui;
	}
	
	public void setAdminUI(AdminUIWB ui){
		this.adminUI = ui;
	}

	/**
	 * Gör en uppkoppling till databasen.
	 * 
	 * @return
	 */
	public Connection connectToDatabase() {
		try {
			conn = DriverManager
					.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Uppkopplingen misslyckades...");
		}
		return conn;
	}

	/**
	 * Visar medlemsinfo om namn och partytrick.
	 * 
	 * @param name
	 */
	public void getMemberInfo(String name) {
		String membername = "", partytrick = "";
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT Namn, Partytrick FROM Medlem WHERE Namn = '"
					+ name + "'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				membername = rs.getString("Namn");
				partytrick = rs.getString("Partytrick");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userUI.textArea.append("\nMedlem: \t" + membername + "\nPartytrick: \t" + partytrick);
		System.out.println(membername + partytrick);
	}

	/**
	 * Visar bandinfo om namn, ursprungsland, musikstil och medlemmar.
	 * 
	 * @param name
	 */
	public void getBandInfo(String name) {
		String bandname = "", membername = "", country = "", genre = "";
		LinkedList<String> medlemmar = new LinkedList<String>();

		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT b.Namn, m.Namn, b.Ursprungsland, b.Musikstil FROM band b INNER JOIN medlem m ON b.BandID = m.BandID WHERE b.BandID IN (SELECT BandID FROM Band WHERE Namn = '"
					+ name + "')";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				bandname = rs.getString("b.Namn");
				membername = rs.getString("m.Namn");
				country = rs.getString("Ursprungsland");
				genre = rs.getString("Musikstil");
				medlemmar.add(membername);
				System.out.println(membername);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		userUI.textArea.append(""
				+ "Band: \t\t" + bandname + 
				"\nUrsprungsland: \t" + country + 
				"\nMusikstil: \t\t" + genre + "\nMedlemmar:\n\t\t");
		for(String medlem : medlemmar){
			userUI.textArea.append(medlem + "\n\t\t");
		}
		userUI.populateMemberBox(medlemmar);
		System.out.println(bandname + country + genre);
	}

	/**
	 * Söker efter spelschema relaterat till band, scen och tid.
	 */
	public void getGigSchedule(String name) {
		String bandname = "", stagename = "", day = "";
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT SELECT b.Namn, s.Namn, Dag FROM Band b INNER JOIN SpelarPa s ON b.BandID = s.BandID FROM Scen INNER JOIN Tidschema t ON s.ScenID = t.ScenID WHERE b.Namn = '"
					+ name + "'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				bandname = rs.getString("b.Namn");
				stagename = rs.getString("s.Namn");
				day = rs.getString("Dag");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(bandname + stagename + day);
	}

	/**
	 * Metoden hämtar samtliga band i tabellen
	 * 
	 * @return - en lista med samtliga namn
	 */
	public LinkedList<String> getBandList() {
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT Namn FROM band";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Namn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String band : s) {
			System.out.println(band);
		}
		return s;
	}
	/**
	 * Metoden returnerar en lista på samtliga scener
	 * @return
	 */
	public LinkedList<String> getStageList(){
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT Namn FROM scen";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Namn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String scen : s) {
			System.out.println(scen);
		}
		return s;
	}
	/**
	 * Metoden returnerar en lista på tillgängliga dagar för vald scen
	 * @param stage OCH TID??????
	 * @return
	 */
	public LinkedList<String> getDayList(String stage){
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT Dag FROM spelarPa";//ANPASSA
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Namn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String dag : s) {
			System.out.println(dag);
		}
		return s;
	}
	/**
	 * Metoden returnerar en lista på tillgängliga tider för vald dag
	 * @param stage
	 * @return
	 */
	public LinkedList<String> getTimeList(String stage, String day){
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT starttid, sluttid FROM spelarPa sp"
					+ "INNER JOIN Scen sc"
					+ "ON sp.ScenID = sc.ScenID"
					+ " WHERE sc.Namn = '" + stage + "' "
							+ "AND Dag = day";//MÅSTE SKRIVAS OM
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Namn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String tid : s) {
			System.out.println(tid);
		}
		return s;
	}
	/**
	 * Metoden returnerar en lista på alla anställda
	 * @return
	 */
	public LinkedList<String> getEmployeeList(){
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "";//MÅSTE SKRIVAS OM
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Namn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String tid : s) {
			System.out.println(tid);
		}
		return s;
	}
	/**
	 * Metoden skrivr ut bandnamn och respektive kontaktperson i Adminui
	 */
	public void getBandContactList(){
		AdminUI.textArea.append();
	}
	/**
	 * Metoden lagrar information i respektive tabell
	 * @param bandName
	 * @param stage
	 * @param day
	 * @param time
	 */
	public void insertBooking(String bandName,String stage ,String day,String time){
		
	}

	public static void main(String[] args) {
		DatabaseConnector databaseConnector = new DatabaseConnector();
		// databaseConnector.getMemberInfo("Kurt Cobain");
		databaseConnector.getBandInfo("Nirvana");
		// databaseConnector.getBandList();
	}
}