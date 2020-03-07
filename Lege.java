class Lege extends UlovligUtskrift implements Comparable<Lege> {

	// Lege tar inn navn som argument
	protected String navn;
	protected Lenkeliste<Resept> legensReseptListe;
	protected int ikkeSpesialist;


	public Lege(String navnet, int ikkeSpesialist) {
		navn = navnet;
		this.ikkeSpesialist = ikkeSpesialist;
		legensReseptListe = new Lenkeliste<>();
	}

	// Henter ut navn
	public String hentNavn() {
		return navn;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return "Lege: "+hentNavn()+"\nType: " + ikkeSpesialist;
	}

	// Henter ut reseptlista til legen
	public Lenkeliste<Resept> utskrevdeResepter() {
		return legensReseptListe;
	}

	public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			if (ikkeSpesialist != 0) { 			// hvis Narkotisk og spesialist
				HvitResept hvitResept = new HvitResept(legemiddel, this, pasient, reit);
				legensReseptListe.leggTil(hvitResept);
				return hvitResept;
			} else if (ikkeSpesialist == 0) {	// hvis Narkotisk, men ikke spesialist
				throw new UlovligUtskrift(this, legemiddel);
			}
		} else {								// hvis ikke Narkotisk
			HvitResept hvitResept = new HvitResept(legemiddel, this, pasient, reit);
			legensReseptListe.leggTil(hvitResept);
			return hvitResept;
		}
	}

	public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			if (ikkeSpesialist != 0) { 			// hvis Narkotisk og spesialist
				MilitaerResept militaerResept = new MilitaerResept(legemiddel, this, pasient, reit);
				legensReseptListe.leggTil(militaerResept);
				return militaerResept;
			} else if (ikkeSpesialist == 0) {	// Narkotisk, men ikke spesialist
				throw new UlovligUtskrift(this, legemiddel);
			}
		} else {								// hvis ikke Narkotisk
			MilitaerResept militaerResept = new MilitaerResept(legemiddel, this, pasient, reit);
			legensReseptListe.leggTil(militaerResept);
			return militaerResept;
		}
	}

	public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			if (ikkeSpesialist != 0) { 			// hvis Narkotisk og spesialist
				PResept pResept = new PResept(legemiddel, this, pasient);
				legensReseptListe.leggTil(pResept);
				return pResept;
			} else if (ikkeSpesialist == 0) {	// Narkotisk, men ikke spesialist
				throw new UlovligUtskrift(this, legemiddel);
			}
		} else {								// hvis ikke Narkotisk
			PResept pResept = new PResept(legemiddel, this, pasient);
			legensReseptListe.leggTil(pResept);
			return pResept;
		}
	}

	public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			if (ikkeSpesialist != 0) { 			// hvis Narkotisk og spesialist
				BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient, reit);
				legensReseptListe.leggTil(blaaResept);
				return blaaResept;
			} else if (ikkeSpesialist == 0) {	// Narkotisk, men ikke spesialist
				throw new UlovligUtskrift(this, legemiddel);
			}
		} else {								// hvis ikke Narkotisk
			BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient, reit);
			legensReseptListe.leggTil(blaaResept);
			return blaaResept;
		}
	}
}
