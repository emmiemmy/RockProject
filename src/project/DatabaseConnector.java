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

	public void setAdminUI(AdminUIWB ui) {
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
		userUI.textArea.append("\nMedlem: \t" + membername + "\nPartytrick: \t"
				+ partytrick);
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
		userUI.textArea.append("" + "Band: \t\t" + bandname
				+ "\nUrsprungsland: \t" + country + "\nMusikstil: \t\t" + genre
				+ "\nMedlemmar:\n\t\t");
		for (String medlem : medlemmar) {
			userUI.textArea.append(medlem + "\n\t\t");
		}
		userUI.populateMemberBox(medlemmar);
		System.out.println(bandname + country + genre);
	}

	/**
	 * Söker efter spelschema relaterat till band, scen och tid.
	 */
	public void getGigSchedule(String name) {
		String bandname = "", stagename = "", day = "", time = "";
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT sc.Namn, sp.Dag, sp.Tid, b.Namn FROM scen sc INNER JOIN spelarPa sp ON sc.ScenID = sp.ScenID "
					+ "INNER JOIN band b ON sp.BandID = b.BandID WHERE b.Namn = '"
					+ name + "'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				bandname = rs.getString("b.Namn");
				stagename = rs.getString("sc.Namn");
				day = rs.getString("sp.Dag");
				time = rs.getString("sp.Tid");
				userUI.textArea.append("\n" + bandname + "\t" + stagename
						+ "\t" + day + "\t" + time + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(bandname + stagename + day + time);
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
	 * Metoden returnerar en lista på samtliga scener.
	 * 
	 * @return
	 */
	public LinkedList<String> getStageList() {
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
	 * 
	 * @param stage
	 * @return
	 */
	public LinkedList<String> getDayList(String stage) {
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT DISTINCT sp.Dag "
					+ "FROM spelarPa sp "
					+ "INNER JOIN scen s "
					+ "ON s.ScenID = sp.ScenID "
					+ "WHERE sp.ScenID IN (SELECT ScenID FROM scen WHERE Namn = '"
					+ stage + "') " + "AND sp.BandID IS NULL";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Dag"));
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
	 * 
	 * @param stage
	 * @return
	 */
	public LinkedList<String> getTimeList(String stage, String day) {
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT sp.Tid "
					+ "FROM spelarPa sp "
					+ "INNER JOIN scen s "
					+ "ON s.ScenID = sp.ScenID "
					+ "WHERE sp.ScenID IN (SELECT ScenID FROM scen WHERE Namn = '"
					+ stage + "') " + "AND sp.BandID IS NULL "
					+ "AND sp.Dag = '" + day + "'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				s.add(rs.getString("Tid"));
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
	 * 
	 * @return
	 */
	public LinkedList<String> getEmployeeList() {
		LinkedList<String> s = new LinkedList<String>();
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			String sql = "SELECT Namn FROM anstalld";
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
	 * Metoden skriver ut bandnamn och respektive kontaktperson i AdminUI.
	 */
	public void getBandContactList() {
		adminUI.textArea.append(null);
	}

	/**
	 * Metoden lagrar information i respektive tabell
	 * 
	 * @param bandName
	 * @param stage
	 * @param day
	 * @param time
	 */
	public void insertBooking(String bandName, String stage, String day,
			String time) {
		int bandID = 0;
		int stageID = 0;
		try {
			conn = connectToDatabase();
			conn.setAutoCommit(false);

			stat = conn.createStatement();
			String sql = "SELECT BandID " + "FROM band " + "WHERE Namn = '"
					+ bandName + "'";

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				bandID = rs.getInt("BandID");
				System.out.println(bandID);
			}
			stat.close();

			stat = conn.createStatement();
			String sql1 = "SELECT ScenID " + "FROM scen " + "WHERE Namn = '"
					+ stage + "'";

			rs = stat.executeQuery(sql1);

			while (rs.next()) {
				stageID = rs.getInt("ScenID");
				System.out.println(stageID);
			}
			stat.close();

			stat = conn.createStatement();
			String sql2 = "UPDATE spelarPa " + "SET BandID = '" + bandID + "'"
					+ "WHERE ScenID = '" + stageID + "' AND " + "Tid = '"
					+ time + "' AND " + "Dag = '" + day + "'";
			stat.executeUpdate(sql2);
			conn.commit();
			stat.close();
			adminUI.lblConfirmBand.setText("Bokning genomförd.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lägger till kontaktperson för band.
	 * 
	 * @param band
	 * @param employee
	 */
	public void insertContactForBand(String band, String employee) {
		int employeeID = 0;
		int bandID = 0;

		try {
			conn = connectToDatabase();
			conn.setAutoCommit(false);

			stat = conn.createStatement();
			String sql = "SELECT AnstID "
					+ "FROM anstalld "
					+ "WHERE Namn = '"
					+ employee + "'";

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				employeeID = rs.getInt("AnstID");
				System.out.println(employeeID);
			}
			stat.close();

			stat = conn.createStatement();
			String sql1 = "SELECT BandID " + "FROM band " + "WHERE Namn = '"
					+ band + "'";

			rs = stat.executeQuery(sql1);

			while (rs.next()) {
				bandID = rs.getInt("BandID");
				System.out.println(bandID);
			}
			stat.close();

			stat = conn.createStatement();
			String sql2 = "UPDATE band " + "SET KontaktpersonID = '"
					+ employeeID + "'" + "WHERE BandID = '" + bandID + "'";
			stat.executeUpdate(sql2);
			conn.commit();
			stat.close();
			adminUI.lblConfirmPerson.setText("Kontaktperson tillagd.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DatabaseConnector dc = new DatabaseConnector();
		dc.insertContactForBand("Slipknot", "Stacy Månfare");
		// dc.insertBooking("No Doubt", "Dieselfabriken", "Fredag",
		// "23:00-01:00");
		// dc.getGigSchedule("Nirvana");
		// dc.getGigSchedule("Nirvana");
		// dc.getStageList();
		// dc.getEmployeeList();
		// dc.getTimeList("Blomsterscenen", "Torsdag");
		// dc.getDayList("Blomsterscenen");
		// dc.getMemberInfo("Kurt Cobain");
		// dc.getBandInfo("Nirvana");
		// dc.getBandList();
	}
}