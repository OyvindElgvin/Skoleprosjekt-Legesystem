class TestResepter {
	public static void main(String[] arg) {

		// legemidler
		Narkotisk metadon = new Narkotisk("Metastodon", 10000, 9000, 100);
		VanligLegemiddel pPille = new VanligLegemiddel("P-piller", 100, 0.002);
		Vanedannende vane = new Vanedannende("Cosylan", 1000, 0.01, 9);

		// lege
		Lege legen = new Lege("Bjørn");
		Spesialist spesialist = new Spesialist("Spesialist Werner", 128932);

		// pasient
		Pasient pasient0 = new Pasient("Georg", "241356");
		Pasient pasient1 = new Pasient("Georgeous", "241856");

		// resepter
		MillaResept millaResept = new MillaResept(metadon, legen, pasient0, 10);
		PResept pResept = new PResept(pPille, legen, pasient1);
		BlaaResept blaaResept = new BlaaResept(metadon, spesialist, pasient0, 7);

		// testmetoder for metodene i de forskjellige instansene
		System.out.println();
		System.out.println("-----------------HVITRESEPT-TEST-----------------");
		testMillaResept(millaResept);
		testPResept(pResept);
		testBlaaResept(blaaResept);

		System.out.println();
		System.out.println("------------BEHANDLERE-TOSTRING-TEST-------------");
		System.out.println(legen.toString());
		System.out.println(spesialist.toString());
	}




	public static void testMillaResept(MillaResept millaResept) {
		System.out.println();
		System.out.println("------MILLARESEPT-TEST------");
		System.out.println(millaResept.hentLegemiddel()+"\n");
		System.out.println("Lege: " + millaResept.hentLege());
		System.out.println("PasientID: " + millaResept.hentPasientId());
		System.out.println("Reit: " + millaResept.hentReit());
		millaResept.bruk(2);
		System.out.println("Bruker to doser og sitter igjen med");
		System.out.println("Reit: " + millaResept.hentReit());
		System.out.println("ReseptID: " + millaResept.hentId());
		System.out.println("Farge: " + millaResept.farge());
		System.out.println("Pris å betale: " + millaResept.prisAaBetale() + " kr");
		System.out.println();
		System.out.println("Test av millaResept-toString");
		System.out.println(millaResept.toString());
	}

	public static void testPResept(PResept PResept) {
		System.out.println();
		System.out.println("------P-PILLE-TEST------");
		System.out.println(PResept.hentLegemiddel()+"\n");
		System.out.println("Lege: " + PResept.hentLege());
		System.out.println("PasientID: " + PResept.hentPasientId());
		System.out.println("Reit: " + PResept.hentReit());
		PResept.bruk(2);
		System.out.println("Bruker to doser og sitter igjen med");
		System.out.println("Reit: " + PResept.hentReit());
		System.out.println("ReseptID: " + PResept.hentId());
		System.out.println("Farge: " + PResept.farge());
		System.out.println("Pris å betale: " + PResept.prisAaBetale() + " kr");
		System.out.println();
		System.out.println("Test av PResept-toString");
		System.out.println(PResept.toString());
	}

	public static void testBlaaResept(BlaaResept blaaResept) {
		System.out.println();
		System.out.println("-----------------BLAARESEPT-TEST-----------------");
		System.out.println(blaaResept.hentLegemiddel()+"\n");
		System.out.println("Lege: " + blaaResept.hentLege());
		System.out.println("PasientID: " + blaaResept.hentPasientId());
		System.out.println("Reit: " + blaaResept.hentReit());
		blaaResept.bruk(2);
		System.out.println("Bruker to doser og sitter igjen med");
		System.out.println("Reit: " + blaaResept.hentReit());
		System.out.println("ReseptID: " + blaaResept.hentId());
		System.out.println("Farge: " + blaaResept.farge());
		System.out.println("Pris å betale: " + blaaResept.prisAaBetale() + " kr");
		System.out.println();
		System.out.println("Test av blaaResept-toString");
		System.out.println(blaaResept.toString());
	}
}
