package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {

	private static Connection conn;
	private static Statement stat;
	private static ResultSet rs;
	private static final String DATABASE_URL = "jdbc:mysql://94.254.94.236:51515/rockproject";
	private static final String USERNAME = "Evelyn";
	private static final String PASSWORD = "emma";
	private UserController userController;
	private AdminController adminController;

	public void setControllers(UserController uc, AdminController ac) {
		userController = uc;
		adminController = ac;
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

	public void getEmployedDatabase() {
		System.out.println("DatabaseConnector: getEmployedDatabase()");
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from anstalld");
			while (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getBandDatabase() {
		System.out.println("DatabaseConnector: getBandDatabase()");
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from band");
			while (rs.next()) {
				Information info = new Information(
				rs.getInt("BandID"),
				rs.getString("Namn"),
				rs.getString("Musikstil"),
				rs.getString("Ursprungsland"));
				System.out.println(info.getBandName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getMemberDatabase() {
		System.out.println("DatabaseConnector: getMemberDatabase()");
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from medlem");
			while (rs.next()) {
				Information info = new Information(
						rs.getInt("MedlemID"),
						rs.getString("Namn"),
						rs.getInt("BandID"),
						rs.getString("Partytrick"));
				System.out.println(info.getMemberName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getStageDatabase() {
		System.out.println("DatabaseConnector: getStageDatabase()");
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from scen");
			while (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getGigDatabase() {
		System.out.println("DatabaseConnector: getGigDatabase()");
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from spelarpa");
			while (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPhoneNumberDatabase() {
		System.out.println("DatabaseConnector: getPhoneNumberDatabase()");
		try {
			conn = connectToDatabase();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from telefon");
			while (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DatabaseConnector databaseConnector = new DatabaseConnector();
		databaseConnector.connectToDatabase();
		databaseConnector.getBandDatabase();
		databaseConnector.getMemberDatabase();
	}
}