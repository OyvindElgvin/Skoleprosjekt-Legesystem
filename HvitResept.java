class HvitResept extends Resept {

	// Resept med egen ID uten avslag.

	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		super(legemiddel, utskrivendeLege, pasient, reit);
	}

	// Henter ut fargen på resepten
	@Override
	public String farge() {
		return "hvit";
	}

	// Henter prisen på legemiddelet uten noen avslag
	@Override
	public double prisAaBetale() {
		return legemiddelet.hentPris();
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return hentLegemiddel()+"\nLege: "+hentLege()+"\nPasientID: "+
			   hentPasientId()+"\nReit: "+hentReit()+"\nReseptID: "+
			   hentId()+"\nFarge: "+farge()+"\nPris: "+prisAaBetale()+" kr";
	}
}
