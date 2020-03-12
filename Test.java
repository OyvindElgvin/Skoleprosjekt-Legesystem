import java.io.FileNotFoundException;

class Test {

	public static void main(String[] args) throws FileNotFoundException{

		Legesystem legesystemet = new Legesystem();

		try{
			legesystemet.lesFil("inndata.txt");
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		/*
		System.out.println();
		System.out.println("---OBJEKTENE I LISTENE---");
		System.out.println();
		System.out.println("Pasientlista:");
		for (int i = 0; i < legesystemet.pasienter.stoerrelse(); i++) {
			System.out.println(legesystemet.pasienter.hent(i).navn + " (fnr "+legesystemet.pasienter.hent(i).foedselsnummer+")");
		}

		System.out.println();
		System.out.println("Legemiddellista:");
		for (int i = 0; i < legesystemet.legemidler.stoerrelse(); i++) {
			if (legesystemet.legemidler.hent(i) == null) {
				System.out.println("null");
			} else {
				System.out.println(legesystemet.legemidler.hent(i).navn);
			}
		}

		System.out.println();
		System.out.println("Legelista:");
		for (int i = 0; i < legesystemet.leger.stoerrelse(); i++) {
			System.out.println(legesystemet.leger.hent(i).navn);
		}

		System.out.println();
		System.out.println("Reseptlista:");
		for (int i = 0; i < legesystemet.resepter.stoerrelse(); i++) {
			if (legesystemet.resepter.hent(i) == null) {
				System.out.println("null");
			}
			System.out.println(legesystemet.resepter.hent(i).farge());
		}
		*/

		legesystemet.ordrelokke();
	}
}
