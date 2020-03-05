class HvitResept extends Resept {

	// Resept med egen ID uten avslag.

	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
		super(legemiddel, utskrivendeLege, pasientId, reit);
	}

	// Henter ut fargen på resepten
	@Override
	public String farge() {
		return "Dette er en hvit resept";
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
