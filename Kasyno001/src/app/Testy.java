package app;

import app.bd.BazaDanych;

public class Testy {
	
	public Testy() {
		System.out.println("Start testow>");
		
		polaczenieZBD();
		
		System.out.println("Koniec testow<");
	}

	private void polaczenieZBD() {
		BazaDanych bd = new BazaDanych();
		System.out.println("Pobranie danych");
		System.out.println("Saldo gracza o id 1 = " + bd.getSaldo(1));
		System.out.println("..........");
//		bd.updateSaldo(1, -110);
//		System.out.println("Saldo gracza o id 1 = " + bd.getSaldo(1));
//		System.out.println("..........");	
//		bd.updateSaldo(1, 10);
//		System.out.println("Saldo gracza o id 1 = " + bd.getSaldo(1));
		System.out.println("Dodanie obstawien");
		bd.addObstawienie(1, 1, 10);
		bd.addObstawienie(1, 2, 23);
		bd.addObstawienie(1, 3, 14);
		bd.updateSaldo(1, -47);
		System.out.println("Saldo gracza o id 1 = " + bd.getSaldo(1));
		bd.getObstawienia(1).forEach((o) -> System.out.println(o.toString()));
		bd.deleteObstawienia(1);
		System.out.println("..........");	
	}
	
	/*
CREATE SCHEMA KASYNO;
USE KASYNO; 
CREATE TABLE gracze(gId INT AUTO_INCREMENT PRIMARY KEY, nazwa VARCHAR(15) NOT NULL, saldo INT NOT NULL);
CREATE TABLE obstawienia(oId INT NOT NULL, gId INT NOT NULL, wartosc INT NOT NULL);
INSERT INTO gracze(nazwa, saldo) VALUES('CYGUS',1000);
INSERT INTO gracze(nazwa, saldo) VALUES('SZAMAN',1000);
INSERT INTO obstawienia(oId, gId, wartosc) VALUES(1,1,10);
INSERT INTO obstawienia(oId, gId, wartosc) VALUES(2,1,20);
SELECT * FROM gracze;
SELECT * FROM obstawienia;
SELECT oId, wartosc FROM obstawienia WHERE gId = 1;
SELECT wartosc FROM obstawienia WHERE gId = 1 AND oId = 1;
DELETE FROM obstawienia WHERE gId = 1;
SELECT saldo FROM gracze WHERE gId = 1 LIMIT 1;
UPDATE gracze SET saldo = saldo - 100 WHERE gId = 1;
	 *
	 */
	

}
