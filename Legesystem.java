import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Legesystem{
    //Liste som holder på ulike objekter
    protected Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
    protected Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    protected Liste<Lege> leger = new SortertLenkeliste<Lege>();
    protected Liste<Resept> resepter = new Lenkeliste<Resept>();

    //Metode som leser fra fil og setter objekter inn i listene
    //MANGLER UNNTAK...
    public void lesFil(String filnavn) throws FileNotFoundException{
        File fil = new File(filnavn);
        Scanner scanner = new Scanner(fil);



        int objekttype = 0; //Sier hvilke type objekt som leses


        while(scanner.hasNextLine()){
            String linje = scanner.nextLine();
            if(linje.startsWith("#")){ //Ny type objekt
                objekttype++;
                System.out.println("\n" + linje); //Tester innlesing

            } else {
                String[] data = linje.split(", ");

                for(int i = 0; i < data.length; i++){ //Tester innlesing
                    System.out.print(data[i] + ", ");
                }
                System.out.println();

                if(objekttype == 1){ //Pasient
                    Pasient pasient = new Pasient(data[0], data[1]);
                    pasienter.leggTil(pasient);

                } else if(objekttype == 2){ //Legemidler
                    String navn = data[0];
                    String type = data[1];
                    float pris = Float.parseFloat(data[2]);
                    float virkestoff = Float.parseFloat(data[3]);
                    Legemiddel legemiddel = null; // måtte visst opprette legemiddelet her for at det skulle kunne legges til lista uten at if-testene slår til, og da måtte jeg fjerne typen før legemiddel-variabelen når legemidlene opprettes i if-løkkene :)

                    if(type == "a"){ //Narkotisk
                        int styrke = Integer.parseInt(data[4]);
                        legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);

                    } else if(type == "b"){ //Vanedannende
                        int styrke = Integer.parseInt(data[4]);
                        legemiddel= new Vanedannende(navn, pris, virkestoff, styrke);

                    } else if(type == "c"){ //Vanlig
                        legemiddel = new VanligLegemiddel(navn, pris, virkestoff);
                    }
                legemidler.leggTil(legemiddel);
                //System.out.println(legemiddel);

                } else if(objekttype == 3){ //Leger
                    //System.out.println(data[0]+" "+data[1]);
                    //Lege lege = new Lege(data[0], Integer.parseInt(data[1])); // denne funker ikke når data[1] = 0, ganske rart..
                    //leger.leggTil(lege);

                } else if(objekttype == 4){ //Resepter
                    Legemiddel legemiddel = legemidler.hent(Integer.parseInt(data[0]));
                    String legeNavn = data[1];
                    Lege ritkigLege = null;
                    for(Lege enLege : leger){
                        if(legeNavn == enLege.hentNavn()){
                            ritkigLege = enLege;
                        }
                    }
                    //System.out.println(ritkigLege);
                    Pasient pasient = pasienter.hent(Integer.parseInt(data[2]));
                    int reit;
                    if(data.length == 4){
                        reit = Integer.parseInt(data[3]);
                    }
                    //System.out.println(pasient);

                    //Lager resept-objekt
                    //Legger objektet i listen resepter
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
}
