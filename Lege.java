class Lege implements Comparable<Lege> {

	// Lege tar inn navn som argument
	protected String navn;
	protected Lenkeliste<Resept> legensReseptListe;
	protected int ikkeSpesialist;


	public Lege(String navn, int ikkeSpesialist) {
		this.navn = navn;
		this.ikkeSpesialist = ikkeSpesialist;
		legensReseptListe = new Lenkeliste<Resept>();
	}

	// Henter ut navn
	public String hentNavn() {
		return navn;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		//return "Lege: "+hentNavn()+"\nType: " + ikkeSpesialist;
		return navn + " (id " + ikkeSpesialist + ")";
	}

	// Henter ut reseptlista til legen
	public Lenkeliste<Resept> utskrevdeResepter() {
		return legensReseptListe;
	}

	public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk && ikkeSpesialist == 0) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		HvitResept hvitResept = new HvitResept(legemiddel, this, pasient, reit);
		legensReseptListe.leggTil(hvitResept);
		return hvitResept;
	}

	public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk && ikkeSpesialist == 0) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		MilitaerResept militaerResept = new MilitaerResept(legemiddel, this, pasient, reit);
		legensReseptListe.leggTil(militaerResept);
		return militaerResept;
	}

	public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk && ikkeSpesialist == 0) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		PResept pResept = new PResept(legemiddel, this, pasient);
		legensReseptListe.leggTil(pResept);
		return pResept;
	}

	public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk && ikkeSpesialist == 0) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient, reit);
		legensReseptListe.leggTil(blaaResept);
		return blaaResept;
	}

	@Override
	public int compareTo(Lege other){
		return this.hentNavn().compareTo(other.hentNavn());
	}
}
