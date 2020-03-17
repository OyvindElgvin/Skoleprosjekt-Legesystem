class Vanedannende extends Legemiddel {

	// Et legemiddel som tar inn navn, pris, virkestoff, og styrke. Har egen ID.

	protected int styrke;

	public Vanedannende(String navn, double pris, double virkestoff, int styrke0) {
		super(navn, pris, virkestoff);
		styrke = styrke0;
	}

	// Henter ut styrken
	public int hentStyrke() {
		return styrke;
	}



	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return "LegemiddelID: "+hentId()+"\nNavn: "+hentNavn()+"\nType legemiddel: Vanedannende \nOriginalpris: "+hentPris()+" kr"+
				"\nVirkestoff: "+hentVirkestoff()+" mg\nStyrke: "+hentStyrke();
	}
}
