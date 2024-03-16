package app.modele;

public class Obstawienie {

	private int oId;
	private int wartosc;
	
	public Obstawienie(int oId, int wartosc) {
		this.oId = oId;
		this.wartosc = wartosc;
	}

	public int getoId() {
		return oId;
	}

	public int getWartosc() {
		return wartosc;
	}

	@Override
	public String toString() {
		return "Obstawienie [oId=" + oId + ", wartosc=" + wartosc + "]";
	}
	
	
}
