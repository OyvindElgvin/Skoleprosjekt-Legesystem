import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Legesystem{
    //Liste som holder på ulike objekter
    Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
    Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    Liste<Lege> leger = new SortertLenkeliste<Lege>();
    Liste<Resept> resepter = new Lenkeliste<Resept>();

    //Metode som leser fra fil og setter objekter inn i listene
    //MANGLER UNNTAK...
    public void LesFil(String filnavn) throws FileNotFoundException{
        File fil = new File(filnavn);
        Scanner scanner = new Scanner(fil);

        int objekttype = 0; //Sier hvilke type objekt som leses


        while(scanner.hasNextLine()){
            if(scanner.nextLine().startsWith("#")){ //Ny type objekt
                objekttype++;

            } else {
                String[] data = scanner.nextLine().split(",");

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

                } else if(objekttype == 3){ //Leger
                    Lege lege = new Lege(data[0], Integer.parseInt(data[1]));
                    leger.leggTil(lege);

                } else if(objekttype == 4){ //Resepter
                    Legemiddel legemiddel = legemidler.hent(Integer.parseInt(data[0]));
                    String legeNavn = data[1];
                    Lege ritkigLege;
                    for(Lege enLege : leger){
                        if(legeNavn == enLege.hentNavn()){
                            ritkigLege = enLege;
                        }
                    }
                    Pasient pasient = pasienter.hent(Integer.parseInt(data[2]));
                    int reit;
                    if(data.length == 4){
                        reit = Integer.parseInt(data[3]);
                    }

                    //Lager resept-objekt
                    //Legger objektet i listen resepter
                    
                    // veldig bra! tror skrivReseptene i Lege skal funke nå
                }
            }
        }
    }
}
