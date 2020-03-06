import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Legesystem{
    Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
    Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    Liste<Lege> leger = new SortertLenkeliste<Lege>();
    Liste<Resept> resepter = new Lenkeliste<Resept>();


    public void LesFil(String filnavn) throws FileNotFoundException{
        File fil = new File(filnavn);
        Scanner scanner = new Scanner(fil);

        int objekttype = 0;
        

        while(scanner.hasNextLine()){
            if(scanner.nextLine().startsWith("#")){
                objekttype++;
            } else {
                String[] data = scanner.nextLine().split(",");
                if(objekttype == 0){ //Pasient
                    Pasient pasient = new Pasient(data[0], data[1]);
                    pasienter.leggTil(pasient);
                } else if(objekttype == 1){ //Legemidler
                    if(data[1] == "a"){ //Narkotisk
                        Narkotisk legemiddel = new Narkotisk(data[0], data[2], data[3], data[4]);

                    } else if(data[1] == "b"){ //Vanedannende
                        Vanedannende legemiddel= new Vanedannende(data[0], data[2], data[3], data[4]);
                        
                    } else if(data[1] == "c"){ //Vanlig
                        VanligLegemiddel legemiddel = new VanligLegemiddel(data[0], data[2], data[3]);
                    }
                legemidler.leggTil(legemiddel);
                } else if(objekttype == 2){ //Leger
                    Lege lege = new Lege(data[0], data[1]);
                    leger.leggTil(lege);
                } else if(objekttype == 3){ //Resepter
                    ...
                }
            }
        }
    }
}