import java.io.FileNotFoundException;

class Test {

	public static void main(String[] args) throws FileNotFoundException{

		Legesystem legesystemet = new Legesystem();

		try{
			legesystemet.lesFil("inndata.txt");
		}
		catch (FileNotFoundException e){

		}

		System.out.println();
		System.out.println("Pasientlista:");
		for (int i = 0; i < legesystemet.pasienter.stoerrelse(); i++) {
			System.out.println(legesystemet.pasienter.hent(i).navn); // henter ut objektet pasient og så navnet
		}

		System.out.println();
		System.out.println("Legemiddel-lista:");
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
			//System.out.println(legesystemet.leger.hent(i).navn);
		}

		System.out.println();
		System.out.println("Reseptlista:");
		for (int i = 0; i < legesystemet.resepter.stoerrelse(); i++) {
			//System.out.println(legesystemet.resepter.hent(i).navn);
		}


		//System.out.println("Antallet pasienter: " + legesystemet.pasienter.stoerrelse());
		//System.out.println("Antallet legemidler: " + legesystemet.legemidler.stoerrelse());
		//System.out.println("Antallet leger: " + legesystemet.leger.stoerrelse());
		//System.out.println("Antallet resepter: " + legesystemet.resepter.stoerrelse());

	}
}
