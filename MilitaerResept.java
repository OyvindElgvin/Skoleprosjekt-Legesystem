class MilitaerResept extends HvitResept {

	// Kort for militærResept.
	// Resept med egen ID uten avnslag.

	public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		super(legemiddel, utskrivendeLege, pasient, reit);
	}

	// Henter ut fargen på resepten
	@Override
	public String farge() {
		return "militaer";
	}

	// Henter prisen på legemiddelet uten noen avslag
	@Override
	public double prisAaBetale() {
		return 0;
	}


	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return hentLegemiddel()+"\nLege: "+hentLege()+"\nPasientID: "+hentPasientId()+
				"\nReit: "+hentReit()+"\nReseptID: "+hentId()+"\nFarge: "+farge()+"\nPris: "+prisAaBetale()+" kr";
	}
}
