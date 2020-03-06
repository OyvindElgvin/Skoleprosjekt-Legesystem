class Lege implements Comparable<Lege> {

	// Lege tar inn navn som argument
	protected String navn;
	private Lenkeliste<Resept>

	public Lege(String navnet) {
		navn = navnet;
	}

	// Henter ut navn
	public String hentNavn() {
		return navn;
	}

	// Override av toString for å skrive ut relevant info som String
	@Override
	public String toString() {
		return "Lege: "+hentNavn();
	}
}
