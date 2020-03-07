class Lege extends UlovligUtskrift implements Comparable<Lege> {

	// Lege tar inn navn som argument
	protected String navn;
	protected Lenkeliste<Resept> legensReseptListe = new Lenkeliste<>();
	protected int ikkeSpesialist;

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

	// Henter ut reseptlista til legen
	public Lenkeliste<Resept> utskrevdeResepter() {
		return legensReseptListe;
	}

	public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		// LEGG INN UlovligUtskrift HER
		HvitResept hvitResept = new HvitResept(legemiddel, this, pasient, reit);
		legensReseptListe.leggTil(hvitResept);
		return hvitResept;
	}

	public MillitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		// LEGG INN UlovligUtskrift HER
		MillitaerResept millitaerResept = new MillitaerResept(legemiddel, this, pasient, reit); // sjekk om det er riktig argumenter
		legensReseptListe.leggTil(millitaerResept);
		return millitaerResept;
	}

	public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
		// LEGG INN UlovligUtskrift HER
		PResept pResept = new PResept(legemiddel, this, pasient); // fyll inn her
		legensReseptListe.leggTil(pResept);
		return pResept;
	}

	public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		// LEGG INN UlovligUtskrift HER
		BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient); // fyll inn her
		legensReseptListe.leggTil(blaaResept);
		return blaaResept;
	}


}
