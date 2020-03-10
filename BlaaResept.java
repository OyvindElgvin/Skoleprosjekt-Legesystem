class BlaaResept extends Resept {

	// Resept med 75% avslag og egen ID.

	protected double blaaPris;

	public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		super(legemiddel, utskrivendeLege, pasient, reit);
		blaaPris = legemiddelet.hentPris()*0.25;
	}

	// Henter ut fargen på resepten
	@Override
	public String farge() {
		return "Dette er en blaaResept";
	}

	// Henter prisen på legemiddelet med avslaget
	@Override
	public double prisAaBetale() {
		return blaaPris;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return hentLegemiddel()+"\nLege: "+hentLege()+"\nPasientID: "+hentPasientId()+
				"\nReit: "+hentReit()+"\nReseptID: "+hentId()+"\nFarge: "+farge()+"\nRabattert pris: "+prisAaBetale()+" kr";
	}
}
