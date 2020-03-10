import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Legesystem{
    //Liste som holder på ulike objekter
    protected Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
    protected Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    protected Liste<Lege> leger = new SortertLenkeliste<Lege>();
    protected Liste<Resept> resepter = new Lenkeliste<Resept>();

    Scanner scan = new Scanner(System.in);

    //Metode som leser fra fil og setter objekter inn i listene
    //MANGLER UNNTAK...
    public void lesFil(String filnavn) throws FileNotFoundException{
        Scanner scanner = null;
        try{
            File fil = new File(filnavn);
            scanner =  new Scanner(fil);
        } catch(FileNotFoundException e){
            System.out.println("Fant ikke fil");
            return;
        }

        int objekttype = 0; //Sier hvilke type objekt som leses


        while(scanner.hasNextLine()){
            String linje = scanner.nextLine();
            if(linje.startsWith("#")){ //Ny type objekt
                objekttype++;

            } else {
                String[] data = linje.trim().split("\\s*,\\s*"); //Må fjerne tomme tegn

                /*
                for(int i = 0; i < data.length; i++){ //Tester innlesing
                    System.out.print(data[i] + ", ");
                }
                System.out.println();
                */


                if(objekttype == 1){ //Pasient
                    Pasient pasient = new Pasient(data[0], data[1]);
                    pasienter.leggTil(pasient);

                } else if(objekttype == 2){ //Legemidler
                    String navn = data[0];
                    String type = data[1];
                    float pris = Float.parseFloat(data[2]);
                    float virkestoff = Float.parseFloat(data[3]);
                    Legemiddel legemiddel = null;

                    if(type.equals("a")){ //Narkotisk
                        int styrke = Integer.parseInt(data[4]);
                        legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);

                    } else if(type.equals("b")) { //Vanedannende
                        int styrke = Integer.parseInt(data[4]);
                        legemiddel= new Vanedannende(navn, pris, virkestoff, styrke);

                    } else if(type.equals("c")){ //Vanlig
                        legemiddel = new VanligLegemiddel(navn, pris, virkestoff);
                    }
                legemidler.leggTil(legemiddel);

                } else if(objekttype == 3){ //Leger
                    Lege lege = new Lege(data[0], Integer.parseInt(data[1])); // denne funker ikke når data[1] = 0, ganske rart..
                    leger.leggTil(lege);

                } else if(objekttype == 4){ //Resepter
                    Legemiddel legemiddel = legemidler.hent(Integer.parseInt(data[0]));
                    String legeNavn = data[1];
                    Lege ritkigLege = null;
                    for(Lege enLege : leger){
                        if(legeNavn.equals(enLege.hentNavn())){
                            ritkigLege = enLege;
                        }
                    }
                    Pasient pasient = pasienter.hent(Integer.parseInt(data[2]));
                    int reit = 0;
                    Resept resepten = null;
                    if(data.length == 4){
                        reit = Integer.parseInt(data[3]);
                    }
                    if (data[3].equals("hvit")){
                        try {
                            resepten = ritkigLege.skrivHvitResept(legemiddel, pasient, reit);
                        } catch (UlovligUtskrift u) {
                            System.out.println(u.getMessage());
                        }
                    } else if (data[3].equals("militaer")) {
                        try {
                            resepten = ritkigLege.skrivMilitaerResept(legemiddel, pasient, reit);
                        } catch (UlovligUtskrift u) {
                            System.out.println(u.getMessage());
                        }
                    } else if (data[3].equals("p")) {
                        try {
                            resepten = ritkigLege.skrivPResept(legemiddel, pasient);
                        } catch (UlovligUtskrift u) {
                            System.out.println(u.getMessage());
                        }
                    } else if (data[3].equals("blaa")) {
                        try {
                            resepten = ritkigLege.skrivBlaaResept(legemiddel, pasient, reit);
                        } catch (UlovligUtskrift u) {
                            System.out.println(u.getMessage());
                        }
                    }
                    resepter.leggTil(resepten);
                }
            }
        }
    }



    // kan være det er en del å hente fra trix 3.01 studentsystem-fila
    public void meny(){
        System.out.println("Hovedmeny:");
        System.out.println("1: Skriv ut fullstendig liste over pasienter, lege, legemidler, og resepter.");
        System.out.println("2: Skriv ut en resept.");
        System.out.println("3: Bruk en resept.");
        System.out.println("4: Skriv ut statestikk om systemet.");
        System.out.println("5: Skriv alle data til fil."); // frivillig oppgave
        System.out.println("0: Avslutt.");
    }



    public void ordrelokke(){

        int inputFraBruker = -1;

        while(inputFraBruker != 0){
            if(inputFraBruker == 1){
                seFullstendigListe();
            } else if(inputFraBruker == 2){
                skrivUtEnResept();
            } else if(inputFraBruker == 3){
                brukEnResept();
            } else if(inputFraBruker == 4){
                skrivUtStatestikk();
            } else if(inputFraBruker == 5){
                //skrivDataTilFil();
            }
            meny();
            inputFraBruker = Integer.parseInt(scan.nextLine());
        }
    }

    private static void seFullstendigListe(){
      System.out.println("--- Liste over leger ---");
  		for (int i = 0; i < leger.stoerrelse(); i++) {
  			System.out.println(leger.hent(i).navn);
  		}
    }

    private static void skrivUtEnResept(){}
    private static void brukEnResept(){}
    private static void skrivUtStatestikk(){}
    private static void skrivDataTilFil(){}
    protected static void seFullstendigListe(){}
    protected static void skrivUtEnResept(){}

    protected static void brukEnResept(){
        skrivUtPasientListe();
    }

    protected static void skrivUtStatestikk(){}
    protected static void skrivDataTilFil(){}

    protected static String skrivUtPasientListe() {
        System.out.println("Hvilken pasient vil du se resepter for?");
        for (int i = 0; i < legesystemet.pasienter.stoerrelse(); i++) {
			System.out.println(i +": "+ legesystemet.pasienter.hent(i).navn + " (fnr "+legesystemet.pasienter.hent(i).foedselsnummer+")");
		}
    }
}
