class TestLegemiddel {
	public static void main(String[] arg) {

		// Oppretter ett objekt av hvert av de tre legemiddlene
		Narkotisk narko = new Narkotisk("Metadon", 1000, 147.9, 10);
		Vanedannende vane = new Vanedannende("Cosylan", 400, 25.4, 7);
		VanligLegemiddel vanlig = new VanligLegemiddel("Daktacort", 200, 2.5);

		// Testmetoder for alle metoder i de tre instansene
		testAvNarko(narko);
		testAvVanedannende(vane);
		testAvVanligLegemiddel(vanlig);
	}


	private static void testAvNarko(Narkotisk narko){
		// Sjekker alle metodene til Narkotisk legemiddel
		System.out.println();
		System.out.println("------------NARKOTEST------------");
		System.out.println("Forventet utskrift:\n"+
							"ID: 0\n"+
							"Navn: Metadon\n"+
							"Pris: 1000 kr\n"+
							"Virkestoff: 147.9 mg\n"+
							"Styrke: 10\n"+
							"ny pris på 1200 kr\n"+
							"sjekk av den nye prisen:\n"+
							"Pris: 1200 kr\n");
		System.out.println("Narkotest:");
		System.out.println("ID: " + narko.hentId());
		System.out.println("Navn: " + narko.hentNavn());
		System.out.println("Pris: " + narko.hentPris() + " kr");
		System.out.println("Virkestoff: " + narko.hentVirkestoff()+ " mg");
		System.out.println("Styrke: " + narko.hentStyrke());
		narko.settNyPris(1200);
		System.out.println("Pris: " + narko.hentPris() + " kr");
		System.out.println("\nTest av toString-metoden:");
		System.out.println(narko.toString());
	}

	private static void testAvVanedannende(Vanedannende vane){
		// Sjekker alle metodene til Vanedannende legemiddel
		System.out.println();
		System.out.println("------TEST-AV-VANEDANNENDE------");
		System.out.println("Forventet utskrift:\n"+
							"ID: 1\n"+
							"Navn: Cosylan\n"+
							"Pris: 400 kr\n"+
							"Virkestoff: 25.4 mg\n"+
							"Styrke: 7\n"+
							"ny pris 500 kr\n"+
							"sjekk av den nye prisen:\n"+
							"Pris: 500 kr\n");
		System.out.println("Test av Vanedannende:");
		System.out.println("ID: " + vane.hentId());
		System.out.println("Navn: " + vane.hentNavn());
		System.out.println("Pris: " + vane.hentPris() + " kr");
		System.out.println("Virkestoff: " + vane.hentVirkestoff()+ " mg");
		System.out.println("Styrke: " + vane.hentStyrke());
		vane.settNyPris(500);
		System.out.println("Pris: " + vane.hentPris() + " kr");
		System.out.println("\nTest av toString-metoden:");
		System.out.println(vane.toString());
	}

	private static void testAvVanligLegemiddel(VanligLegemiddel vanlig){
		// Sjekker alle metodene til Vanlig legemiddel
		System.out.println();
		System.out.println("------TEST-AV-VANLIG-LEGEMIDDEL-----");
		System.out.println("Forventet utskrift:\n"+
							"ID: 2\n"+
							"Navn: Daktacort\n"+
							"Pris: 200 kr\n"+
							"Virkestoff: 2.5 mg\n"+
							"ny pris på 300 kr\n"+
							"sjekk av den nye prisen:\n"+
							"Pris: 300 kr\n");
		System.out.println("Test av Vanlig Legemiddel:");
		System.out.println("ID: " + vanlig.hentId());
		System.out.println("Navn: " + vanlig.hentNavn());
		System.out.println("Pris: " + vanlig.hentPris() + " kr");
		System.out.println("Virkestoff: " + vanlig.hentVirkestoff()+ " mg");
		vanlig.settNyPris(300);
		System.out.println("Pris: " + vanlig.hentPris() + " kr");
		System.out.println("\nTest av toString-metoden:");
		System.out.println(vanlig.toString());
	}
}
