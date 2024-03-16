package app.bd;

public class BazaDanych {

	private PolaczenieZH2 bd;
	
	public BazaDanych() {
		
		bd = PolaczenieZH2.getInstance();
	}
	
}
