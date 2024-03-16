package app.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		} catch (SQLException e) {
			System.out.println("<PolaczenieZH2> probelem z polaczenie z baza danych!!!");
			e.printStackTrace();
		}
	}
	
	public static PolaczenieZH2 getInstance() {
		if(bd == null) {
			bd = new PolaczenieZH2();
		}
		return bd;
	}
	
	
}
