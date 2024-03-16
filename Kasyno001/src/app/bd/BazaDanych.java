package app.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import app.modele.Obstawienie;

public class BazaDanych {

	private PolaczenieZH2 bd;
	
	public BazaDanych() {
		
		bd = PolaczenieZH2.getInstance();
		
	}
	

	public ResultSet pobierzDane(String sql) {
		return bd.getData(sql);
	}
	
	public int aktulizuj(String sql) {
		return bd.updateDB(sql);
	}
	
	public int getSaldo(int kogo) {
		ResultSet rs = bd.getData("SELECT saldo FROM gracze WHERE gId = " + kogo + " LIMIT 1;");
		int saldo = 0;
		try {
			while(rs.next()) {
				saldo = rs.getInt("saldo");
			}
		} catch (SQLException e) {
			System.out.println("Problem z zapytaniem o saldo od BD!");
			e.printStackTrace();
		}
		return saldo;
	}
	
	public void updateSaldo(int kogo, int delta) {
		bd.updateDB(
				String.format("UPDATE gracze SET saldo = saldo + %d WHERE gId = %d;",
						delta, kogo)
				);
	}
	
	public void addObstawienie(int kogo, int ktore, int ile) {
		bd.updateDB(
				String.format("INSERT INTO obstawienia(oId, gId, wartosc) VALUES(%d,%d,%d);",
						ktore, kogo, ile)
				);
	}
	
	public ArrayList<Obstawienie> getObstawienia(int kogo){
		//SELECT oId, wartosc FROM obstawienia WHERE gId = 1;
		ArrayList<Obstawienie> wykaz = new ArrayList<Obstawienie>();
		ResultSet rs = bd.getData(
				"SELECT oId, wartosc FROM obstawienia WHERE gId = " + kogo + ";"
				);
		try {
			while(rs.next()) {
				wykaz.add(
						new Obstawienie(
								rs.getInt("oId"),
								rs.getInt("wartosc")
								)
						);
			}
		} catch (SQLException e) {
			System.out.println("Problem z zapytaniem o obstawienia od BD!");
			e.printStackTrace();
		}
		return wykaz;
	}
	
	public void deleteObstawienia(int kogo) {
		bd.updateDB("DELETE FROM obstawienia WHERE gId = " + kogo + ";");
		System.out.println("Usuniecie wpisow");
	}
}
