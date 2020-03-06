class Lege extends UlovligUtskrift implements Comparable<Lege> {

	// Lege tar inn navn som argument
	protected String navn;
	protected Lenkeliste<Resept> legensReseptListe = new Lenkeliste<>();
	protected Lege[] legen;
	protected ikkeSpesialist;

	public Lege(String navnet, int ikkeSpesialist) {
		navn = navnet;
		this.ikkeSpesialist = ikkeSpesialist;
	}

	// Henter ut navn
	public String hentNavn() {
		return navn;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return "Lege: "+hentNavn();
	}

	/*
	public int sorterLege(String navnet){
		if (navnet.compareTo(this.navn) > 0) return -1;
		if (navnet.compareTo(this.navn) < 0) return 1;
		return 0;
	}
	*/

	// Henter ut reseptlista til legen
	public Lenkeliste<Resept> utskrevdeResepter() {
		return legensReseptListe;
	}

	public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (ikkeSpesialist != 0) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		HvitResept hvitResept = new HvitResept(legemiddel, this, pasient, reit);
		legensReseptListe.leggTil(hvitResept);
	}
}
