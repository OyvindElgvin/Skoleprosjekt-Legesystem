abstract class Resept {

	// Abstrakt klasse som tar inn legemiddel, utskrivendeLege, pasientId,
	// og en reit, som forteller hvor mange ganger en resept kan brukes.

	Legemiddel legemiddelet;
	Lege utskrivendeLege;
	protected int pasientId;
	protected int reit;
	protected static int IDTeller = -1;
	protected int ID;

	public Resept(Legemiddel legemiddel, Lege utskrivendeLege0, int pasientId0, int reit0) {
		legemiddelet = legemiddel;
		utskrivendeLege = utskrivendeLege0;
		pasientId = pasientId0;
		reit = reit0;
		IDTeller ++;
		ID = IDTeller;
	}

	// Abstrakte metoder subklassene skal implementere
	abstract public String farge();
	abstract public double prisAaBetale();

	// Henter ID'n til resepten
	public int hentId() {
		return ID;
	}

	// Henter info om legemiddelet fra en overridet toString
	public String hentLegemiddel() {
		return legemiddelet.toString();
	}

	// Henter navnet til Lege eller Spesialist
	public String hentLege() {
		return utskrivendeLege.hentNavn();
	}

	// Henter PasientID'n fra pasienten
	public int hentPasientId() {
		return pasientId;
	}

	// Henter ut hvor mange reit det er igjen
	public int hentReit() {
		return reit;
	}

	// Metode for bruk av resepten. Inputen settes til antall ganger resepten er
	// brukt, og det trekkes fra reiten til resepten er tom.
	public boolean bruk(int antallBruk) {
		int teller = 0;
		if (reit-antallBruk > 0) {
			reit -= antallBruk;
			return true;
		} else {
			while (reit != 0) {
				teller ++;
				reit -= 1;
			}
			System.out.println("Du får det som var igjen på resepten, altså " +
								teller + " ganger. \nNå er resepten utløpt.\n");
			return false;
		}
	}
}
