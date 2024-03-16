package app.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PolaczenieZH2 {

	private static PolaczenieZH2 bd = null; // konstrukcja singeltona !!! wazne jest jedna istancja tylko;

	private Connection polaczenie;

	private PolaczenieZH2() {
		String jdbcURL = "jdbc:h2:./lbd";
		String userBD = "sa";
		String hasloBD = "0202";
		String nazwaBD = "KASYNO";

		try {
			polaczenie = DriverManager.getConnection(jdbcURL, userBD, hasloBD);
			sprawdzBazeDanych(nazwaBD);
		} catch (SQLException e) {
			System.out.println("<PolaczenieZH2> probelem z polaczenie z baza danych!!!");
			e.printStackTrace();
		}
	}

	private void sprawdzBazeDanych(String nazwaBD) {
		Statement statement;
		try {
			statement = polaczenie.createStatement();
			statement.execute(
					String.format("USE %s;", nazwaBD)
					);
		} catch (SQLException e) {
			System.out.println("Tworzenie Bazy Danych!");
			updateDB("CREATE SCHEMA KASYNO;");
			updateDB("USE KASYNO;"); 
			updateDB("CREATE TABLE gracze(gId INT AUTO_INCREMENT PRIMARY KEY, nazwa VARCHAR(15) NOT NULL, saldo INT NOT NULL);"); 
			updateDB("CREATE TABLE obstawienia(oId INT NOT NULL, gId INT NOT NULL, wartosc INT NOT NULL);");
			updateDB("INSERT INTO gracze(nazwa, saldo) VALUES('CYGUS',1000);");
		}
	}

	public static PolaczenieZH2 getInstance() {
		if (bd == null) {
			bd = new PolaczenieZH2();
		}
		return bd;
	}

	public int updateDB(String sql) { // wykonywanie zapytan do aktulizowania Bazy daynych!!!
		int wynik = -1;
		Statement statment;
		try {
			statment = polaczenie.createStatement();
			wynik = statment.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("<PolaczenieZH2> probelem z aktulizacja bazy danych!!!");
			e.printStackTrace();
		}

		return wynik;
	}

	public ResultSet getData(String sql) {
		ResultSet rs = null;
		Statement statment;
		try {
			statment = polaczenie.createStatement();
			rs = statment.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("<PolaczenieZH2> probelem z pobraniem danych z bazy danych!!!");
			e.printStackTrace();
		}	
		return rs;
	}

}
