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
		
	}

}
