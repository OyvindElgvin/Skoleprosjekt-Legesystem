class Lege implements Comparable<Lege> {

	// Lege tar inn navn som argument
	protected String navn;
	private Lenkeliste<Resept> legensReseptListe = new Lenkeliste<>();

	public Lege(String navnet) {
		navn = navnet;
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

	// Henter ut reseptlista til legen
	public Lenkeliste<Resept> utskrevdeResepter() {
		return legensReseptListe;
	}


	public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, ​int​ reit) throws UlovligUtskrift​ {
		HvitResept hvitResept = new HvitResept(legemiddel, this.lege, pasient, reit);
		legensReseptListe.leggTil(hvitResept);
	}
}
