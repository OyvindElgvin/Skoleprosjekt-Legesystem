class PResept extends HvitResept {

	// Resept med et avslag på 108 kr og egen ID.

	public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
		super(legemiddel, utskrivendeLege, pasient, 3);
	}

	// Henter ut fargen på resepten
	@Override
	public String farge() {
		return "Dette er en pResept";
	}

	// Setter ny pris etter avslaget, og gratis hvis avslaget > prisen
	@Override
	public double prisAaBetale() {
		double pPris;
		if (legemiddelet.hentPris() - 108 > 0) {
			pPris = legemiddelet.hentPris() - 108;
		} else {
			System.out.println("Legemiddelet er gratis");
			pPris = 0.0;
		}
		return pPris;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return hentLegemiddel()+"\nLege: "+hentLege()+"\nPasientID: "+hentPasientId()+
				"\nReit: "+hentReit()+"\nReseptID: "+hentId()+"\nFarge: "+farge()+"\nRabattert pris: "+prisAaBetale()+" kr";
	}
}
