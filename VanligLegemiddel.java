class VanligLegemiddel extends Legemiddel {

	// Et legemiddel som tar inn navn, pris, og virkestoff. Har egen ID.


	public VanligLegemiddel(String navn, double pris, double virkestoff) {
		super(navn, pris, virkestoff);

	}

	

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return "LegemiddelID: "+hentId()+"\nNavn: "+hentNavn()+"\nOriginalpris: "+hentPris()+" kr"+
				"\nVirkestoff: "+hentVirkestoff()+" mg";
	}
}
