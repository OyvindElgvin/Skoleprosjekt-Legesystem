class Hovedprogram {
	public static void main(String[] arg) {

		// Oppretter behandlere
		Lege lege = new Lege("Doktor Jørgen Skavlan");
		Spesialist spesialist = new Spesialist("Spesialist Tanja Kalchenko", 1234);

		// Oppretter legemidler
		Narkotisk narkotisk = new Narkotisk("Metadon", 1000, 90, 20);
		Vanedannende vanedannende = new Vanedannende("Cosylan", 500, 0.01, 9);
		Vanedannende vanedannende2 = new Vanedannende("Cosylan", 500, 0.01, 9);
		VanligLegemiddel vanligLegemiddel = new VanligLegemiddel("P-piller", 120, 0.002);

		// Oppretter resepter
		HvitResept hvitResept = new HvitResept(vanedannende, lege, 123, 12);
		MillaResept millaResept = new MillaResept(vanedannende2, lege, 234, 23);
		PResept pResept = new PResept(vanligLegemiddel, spesialist, 345);
		BlaaResept blaaResept = new BlaaResept(narkotisk, spesialist, 456, 34);

		// tester toString-metoden
		testToString(lege, spesialist, narkotisk, vanedannende, vanedannende2,
					 vanligLegemiddel, hvitResept, millaResept, pResept, blaaResept);
	}



	// statisk testmetode
	public static void testToString(Lege lege, Spesialist spesialist, Narkotisk narkotisk,
									Vanedannende vanedannende, Vanedannende vanedannende2,
									VanligLegemiddel vanligLegemiddel, HvitResept hvitResept,
									MillaResept millaResept,PResept pResept, BlaaResept blaaResept) {
		// Skriver ut relevant informasjon om alle instansene
		System.out.println();
		System.out.println("-----------LEGE-----------");
		System.out.println(lege.toString()+"\n");
		System.out.println("-----------SPESIALIST-----------");
		System.out.println(spesialist.toString()+"\n");
		System.out.println("-----------NARKOTISK-LEGEMIDDEL----------");
		System.out.println(narkotisk.toString()+"\n");
		System.out.println("-----------VANEDANNENDE-LEGEMIDDEL-----------");
		System.out.println(vanedannende.toString()+"\n");
		System.out.println("-----------VANEDANNENDE2-LEGEMIDDEL-----------");
		System.out.println(vanedannende2.toString()+"\n");
		System.out.println("-----------VANLIGLEGEMIDDEL-----------");
		System.out.println(vanligLegemiddel.toString()+"\n");
		System.out.println("-----------HVIT-RESEPT-----------");
		System.out.println(hvitResept.toString()+"\n");
		System.out.println("-----------MILITÆR-RESEPT-----------");
		System.out.println(millaResept.toString()+"\n");
		System.out.println("-----------P-RESEPT-----------");
		System.out.println(pResept.toString()+"\n");
		System.out.println("-----------BLÅ-RESEPT-----------");
		System.out.println(blaaResept.toString()+"\n");
		System.out.println("-----------BLÅ-RESEPT-BRUKT-REIT----------");
		blaaResept.bruk(35);
		System.out.println(blaaResept.toString()+"\n");

	}
}
