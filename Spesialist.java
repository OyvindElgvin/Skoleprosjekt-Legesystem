class Spesialist extends Lege implements Godkjenningsfritak {

	// Spesialist tar inn navn og fra interfacen; kontrollID
	protected int spesialistKontrollID;

	public Spesialist(String navnet, int kontrollID) {
		super(navnet, kontrollID);
		spesialistKontrollID = kontrollID;
	}

	// Henter ut kontrollID gjennom en interface
	@Override
	public int hentKontrollID() {
		return spesialistKontrollID;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return "Spesialist: "+hentNavn() + "\nKontroll ID: "+hentKontrollID();
	}
}
