abstract class Legemiddel {

	// Abstrakt klasse som tar inn navn, pris og virkestoff til legemiddelet.

	protected String navn;
	protected double pris;
	protected double virkestoff;
	protected static int IDTeller = 0;
	protected int ID;


	public Legemiddel(String navnet, double prisen, double virkestoffet) {
		navn = navnet;
		pris = prisen;
		virkestoff = virkestoffet;
		ID = IDTeller;
		IDTeller ++;

	}

	// Henter ID til legemiddelet
	public int hentId() {
		return ID;
	}

	// Henter navnet til legemiddelet
	public String hentNavn() {
		return navn;
	}

	// Henter prisen til legemiddelet
	public double hentPris() {
		return pris;
	}

	// Henter virkestoffet til legemiddelet
	public double hentVirkestoff() {
		return virkestoff;
	}

	// Setter argumentet til ny pris
	public void settNyPris(double pr) {
		pris = pr;
	}
}
