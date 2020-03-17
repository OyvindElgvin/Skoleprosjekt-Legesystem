import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

class Legesystem{
    //Liste som holder på ulike objekter
    protected Liste<Pasient> pasienter = new Lenkeliste<Pasient>();
    protected Liste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    protected Liste<Lege> leger = new SortertLenkeliste<Lege>();
    protected Liste<Resept> resepter = new Lenkeliste<Resept>();

    Scanner scan = new Scanner(System.in);

    //Metode som leser fra fil og setter objekter inn i listene
    public void lesFil(String filnavn) throws FileNotFoundException{
        Scanner scanner = null;
        try{
            File fil = new File(filnavn);
            scanner =  new Scanner(fil);
        } catch(FileNotFoundException e){
            System.out.println("Fant ikke fil");
            return;
        }
        int objekttype = 0; // Sier hvilke type objekt som leses
        int index = 262;    // til å debugge reseptene

        while(scanner.hasNextLine()){
            String linje = scanner.nextLine();
            if(linje.startsWith("#")){ //Ny type objekt
                objekttype++;

            } else {
                String[] data = linje.trim().split("\\s*,\\s*"); //Må fjerne tomme tegn

                if(objekttype == 1 && data.length == 2){ //Pasient
                    leggTilPasientliste(data[0], data[1]);

                } else if(objekttype == 2){ //Legemidler
                    if(data.length == 4){
                        leggTilLegemiddelliste(data[0],data[1],data[2], data[3],  "vanlig");
                    } else if(data.length == 5){
                        leggTilLegemiddelliste(data[0], data[1], data[2], data[3], data[4]);
                    }

                } else if(objekttype == 3 && data.length == 2){ //Leger
                    leggTilLegeliste(data[0], data[1]);

                } else if(objekttype == 4 && data.length == 5){ //Resepter
                    //index++;
                    //System.out.println(index);
                    //System.out.println(data[0]+", "+data[1]+", "+data[2]+", "+data[3]+", "+data[4]);
                    leggTilReseptliste(data[0], data[1], data[2], data[3], data[4]);
                }
            }
        }
    }


    public void ordrelokke(){
        int inputFraBruker = -1;

        while(inputFraBruker != 0){
            if(inputFraBruker == 1){
                seFullstendigListe();
            } else if(inputFraBruker == 2){
                leggTilElement();
            } else if(inputFraBruker == 3){
                brukEnResept();
            } else if(inputFraBruker == 4){
                skrivUtStatestikk();
            } else if(inputFraBruker == 5){
                skrivFil(pasienter, legemidler, leger, resepter, "utdata.txt");
            } else if (6 < inputFraBruker || inputFraBruker < -1) {
                System.out.println("Velg en av de fem alternativene");
            }
            System.out.println();
            System.out.println("Hovedmeny:");
            System.out.println("1: Skriv ut fullstendig liste over pasienter, lege, legemidler, og resepter.");
            System.out.println("2: Legg til pasient, lege, legemiddel eller resept.");
            System.out.println("3: Bruk en resept.");
            System.out.println("4: Skriv ut statestikk om systemet.");
            System.out.println("5: Skriv alle data til fil."); // frivillig oppgave
            System.out.println("0: Avslutt.");
            inputFraBruker = Integer.parseInt(scan.nextLine());
        }
    }


    // Hovedmetode i ordreløkka
    protected void seFullstendigListe(){
      int inputFraBruker = -1;

      while(inputFraBruker != 0){
        if(inputFraBruker == 1){
          System.out.println("--- Liste over leger ---");
          seLegeliste();
          System.out.println("\n\n");

          System.out.println("--- Liste over pasienter ---");
          sePasientListe();
          System.out.println("\n\n");

          System.out.println("--- Liste over legemiddler ---");
          seLegemiddelListe();
          System.out.println("\n\n");

          System.out.println("--- Liste over resepter ---");
          seReseptListe();
          System.out.println("\n\n");
        }
        else if(inputFraBruker == 2){
          for (int i = 0; i < leger.stoerrelse(); i++){
            System.out.println(i+1 + ": " + leger.hent(i).toString() + "\n");
          }
        }
        else if(inputFraBruker == 3){
          for (int i = 0; i < pasienter.stoerrelse(); i++) {
              System.out.println(i+1 +": "+ pasienter.hent(i).toString() + "\n");
          }
        }
        else if(inputFraBruker == 4){
          for (int i = 0; i < legemidler.stoerrelse(); i++){
            System.out.println(i+1 + ":\n" + legemidler.hent(i).toString() + "\n");
          }
        }
        else if(inputFraBruker == 5){
          for (int i = 0; i < resepter.stoerrelse(); i++){
            System.out.println(i+1 + ": " + resepter.hent(i).toString() + "\n");
          }
        }
        else if(inputFraBruker == 0){
          ordrelokke();
        }
        else if(inputFraBruker < -1 || inputFraBruker > 6){
          System.out.println("Velg et av de seks alternativene.");
        }

        System.out.println("Velg et av alternativene");
        System.out.println("1: Full oversikt.");
        System.out.println("2: Info om leger.");
        System.out.println("3: Info om pasienter.");
        System.out.println("4: Info om legemidler.");
        System.out.println("5: Info om resepter.");
        System.out.println("0: Tilbake.");

        inputFraBruker = Integer.parseInt(scan.nextLine());
      }
    }


    // Hovedmetode i ordreløkka
    protected void leggTilElement(){
        int inputFraBruker = -1;

        while(inputFraBruker != 0){
            if(inputFraBruker == 1){ //Legger til pasient
                System.out.println();
                System.out.println("Hva heter pasienten?");
                String pasientNavn = scan.nextLine();

                System.out.println("Hva er fødselsnummeret til pasienten?");
                String foedselsnummer = scan.nextLine();

                if(leggTilPasientliste(pasientNavn, foedselsnummer)){
                    System.out.println("Pasienten er lagt til i systemet.");
                } else{
                    System.out.println("Kunne ikke legge pasienten til i systemet.");
                }
            } else if(inputFraBruker == 2){ //Legger til lege
                System.out.println();
                System.out.println("Hva heter legen?");
                String legeNavn = scan.nextLine();

                System.out.println("Hva er kontrollID til legen? (0 hvis ingen)");
                String kontrollId = scan.nextLine();

                if(leggTilLegeliste(legeNavn, kontrollId)){
                    System.out.println("Legen er lagt til i systemet.");
                } else{
                    System.out.println("Kunne ikke legge legen til i systemet.");
                }
            } else if(inputFraBruker == 3){ //Legger til legemiddel
                System.out.println();
                System.out.println("Hvilke type legemiddel vil du legge til?");
                System.out.println("1: Narkotisk.");
                System.out.println("2: Vanedannende.");
                System.out.println("3: Vanlig.");
                String type = scan.nextLine();

                String styrke = "vanlig";
                if(type == "1" || type == "2"){
                    System.out.println("Hva er styrken på legemiddelet?");
                    styrke = scan.nextLine();
                }

                System.out.println("Hva heter legemiddelet?");
                String legemiddelNavn = scan.nextLine();

                System.out.println("Hva er prisen på legemiddelet?");
                String pris = scan.nextLine();

                System.out.println("Hvor mye virkestoff?");
                String virkestoff = scan.nextLine();

                if(leggTilLegemiddelliste(legemiddelNavn, type, pris, virkestoff, styrke)){
                    System.out.println("Legemiddelet er lagt til i systemet.");
                } else{
                    System.out.println("Kunne ikke legge legemiddelet til i systemet.");
                }
            } else if(inputFraBruker == 4){
                System.out.println();
                System.out.println("Hvilke type resept vil du legge til?");
                System.out.println("1: Hvit");
                System.out.println("2: Militær");
                System.out.println("3: P");
                System.out.println("4: Blå");
                String type = scan.nextLine();

                System.out.println("\nHvilke legemiddel vil du bruke?");
                seLegemiddelListe();
                String legemiddelIndeks = scan.nextLine();

                System.out.println("\nHvilken lege skriver ut resepten?");
                seLegeliste();
                int legeIndeks = Integer.parseInt(scan.nextLine());
                String legeNavn = leger.hent(legeIndeks).hentNavn();

                System.out.println("\nHvilken pasient skrives resepten ut til?");
                sePasientListe();
                String pasientIndeks = scan.nextLine();

                System.out.println("\nHva skal reiten være på?");
                String reit = scan.nextLine();

                if(leggTilReseptliste(legemiddelIndeks, legeNavn, pasientIndeks, type, reit)){
                    System.out.println("Resepten er lagt til.");
                } else {
                    System.out.println("Kunne ikke legge til resepten.");
                }
            } else if(inputFraBruker == 0){
                ordrelokke(); //Går tilbake
            } else if (5 < inputFraBruker || inputFraBruker < -1) {
                System.out.println("Velg et av de fem alternativene!");
            }
            System.out.println();
            System.out.println("Hva vil du legge til?");
            System.out.println("1: Pasient.");
            System.out.println("2: Lege.");
            System.out.println("3: Legemiddel.");
            System.out.println("4: Resept.");
            System.out.println("0: Gå tilbake.");

            inputFraBruker = Integer.parseInt(scan.nextLine());
        }
    }


    // Hovedmetode i ordreløkka
    protected void brukEnResept(){
        System.out.println("Hvilken pasient vil du se resepter for?");
        for (int i = 0; i < pasienter.stoerrelse(); i++) {
            System.out.println(i +": "+ pasienter.hent(i).toString()); // Lister opp pasientene
		}
        int inputFraBruker = Integer.parseInt(scan.nextLine());
        if ((pasienter.stoerrelse()-1) < inputFraBruker || inputFraBruker < -1) { // hvis utenfor lista
            System.out.println("Feil inntasting! Tallet var utenfor lista.");
            System.out.println("Velg et tall fra 0 til " + (pasienter.stoerrelse()-1));
            ordrelokke();
        }
        Pasient pasient = pasienter.hent(inputFraBruker);
        System.out.println("Valgt pasient: " + pasient);

        System.out.println("Hvilken resept vil du bruke?");
        Stabel<Resept> reseptstabel = pasient.hentResepter();   // Oppretter en stabel med reseptene til pasienten
        if (reseptstabel.stoerrelse() == 0) {                   // hvis det er 0 resepter
            System.out.println("Pasienten har ingen resepter.");
            System.out.println();
            ordrelokke();
        } else {
            int index = 0;
            for (Resept resept : reseptstabel) {                // lister opp pasientens reseptene med reit
                System.out.println(index+": "+resept.legemiddelet.navn +" ("+ resept.reit+" reit)");
                index ++;
            }
        }
        int reseptIndex = Integer.parseInt(scan.nextLine());
        if ((pasient.resepter.stoerrelse()-1) < reseptIndex || reseptIndex < -1) { // hvis utenfor lista
            System.out.println("Feil inntasting! Tallet var utenfor lista.");
            System.out.println("Trykk en tast for å komme tilbake til hovedmeny");
            String ventHer = scan.nextLine();
            ordrelokke();
        }else {
            System.out.println("Hvor mange reit ønsker du å bruke?");
            int reitOnske = Integer.parseInt(scan.nextLine());
            if ((pasient.resepter.hent(reseptIndex).reit - reitOnske) >= 0) {
                pasient.resepter.hent(reseptIndex).bruk(reitOnske); // bruker ønsket reit på valgt resept
                System.out.println("Brukte resept på " + pasient.resepter.hent(reseptIndex).legemiddelet.navn+". Antall gjenvarende reit: "+ pasient.resepter.hent(reseptIndex).reit);
                System.out.println("Trykk en tast for å komme tilbake til hovedmeny");
                String ventHer = scan.nextLine();
            } else {
                System.out.println("Det er ikke nok reit på resepten.");
                System.out.println("Trykk en tast for å komme tilbake til hovedmeny");
                String ventHer = scan.nextLine();
            }
        }
    }


    // Hovedmetode i ordreløkka
    protected void skrivUtStatestikk() {
        int inputFraBruker = -1;

        while(inputFraBruker != 0){
            if(inputFraBruker == 1){
                // antall Vanedannende resepter
                int antallVane = 0;
                for (Resept r : resepter) {
                    if (r.legemiddelet instanceof Vanedannende) {
                        antallVane ++;
                    }
                }
                System.out.println("Det er skrevet ut "+antallVane+ " vanedannende resepter.");
                System.out.println("Trykk en tast for å komme tilbake til hovedmeny");
                String ventHer = scan.nextLine();
            } else if(inputFraBruker == 2){
                // antall Narkotiske resepter
                int antallNarko = 0;
                for (Resept r : resepter) {
                    if (r.legemiddelet instanceof Narkotisk) {
                        antallNarko ++;
                    }
                }
                System.out.println("Det er skrevet ut "+antallNarko+ " narkotiske resepter.");
                System.out.println("Trykk en tast for å komme tilbake til meny for statestikk");
                String ventHer = scan.nextLine();
            } else if(inputFraBruker == 3){
                // narkotisk Misbruk
                System.out.println("Skriv ut statestikk om:");
                System.out.println("1: Leger");
                System.out.println("2: Pasienter");
                int valg = Integer.parseInt(scan.nextLine());
                if (valg == 1) {
                    // skriver ut statestikk for leger
                    System.out.println("# (Lege, antall resepter med narkotisk legemiddel)");
                    for (Lege lege : leger) {       // for hver lege
                        int antallNarkotiskResept = 0;
                        Lenkeliste<Resept> enkeltlegesReseptListe = lege.utskrevdeResepter(); // Oppretter lenkeliste med reseptene til legen
                        for (Resept resept : enkeltlegesReseptListe) { // for hver resept til legen
                            if (resept.legemiddelet instanceof Narkotisk) {    // hvis narkotisk
                                antallNarkotiskResept ++;
                            }
                        }
                        System.out.println(lege.navn + ", " + antallNarkotiskResept);
                    }
                    System.out.println("Trykk en tast for å gå tilbake");
                    String ventHer = scan.nextLine();
                } else if (valg == 2) {
                    // skriver ut statestikk for pasienter
                    System.out.println("# (Pasient, antall reit på narkotiske legemidler)");
                    for (Pasient pasient : pasienter) {             // for hver pasient
                        int totaltAntallNarkotiskReit = 0;
                        Stabel<Resept> pasientReseptListe = pasient.hentResepter(); // lager en reseptliste
                        boolean narko = false;
                        for (Resept resept : pasientReseptListe) {  // for hver resept
                            int antallNarkotiskReit = 0;
                            if (resept.legemiddelet instanceof Narkotisk) {
                                antallNarkotiskReit += resept.reit;
                                narko = true;                       // Hvis pasienten her noen narkotiske resepter
                            }
                            totaltAntallNarkotiskReit += antallNarkotiskReit;
                        }
                        if (narko) {                                // så skrives de ut
                            System.out.println(pasient.navn + ", (" + totaltAntallNarkotiskReit + " reit)");
                        }
                    }
                }
            } else if (3 < inputFraBruker || inputFraBruker < -1) {
                System.out.println("Velg en av de fire alternativene");
                System.out.println("Trykk en tast for å komme tilbake til meny for statestikk");
                String ventHer = scan.nextLine();
            }
            System.out.println();
            System.out.println("Skriv ut statestikk om:");
            System.out.println("1: Totatlt antall utskrevne resepter på vanedannende legemidler.");
            System.out.println("2: Totatlt antall utskrevne resepter på narkotiske legemidler.");
            System.out.println("3: Narkotisk misbruk.");
            System.out.println("0: Gå tilbake.");
            inputFraBruker = Integer.parseInt(scan.nextLine());
        }
    }

    // Hovedmetode for å skrive ut data til fil
    protected void skrivFil(Liste<Pasient> pasientListe,Liste<Legemiddel> legemiddelListe, Liste<Lege> legeListe, Liste<Resept> reseptListe, String utfil){
        File fil = new File(utfil);
        try{
            PrintWriter skriver = new PrintWriter(fil);

            skriver.append("# Pasienter (navn, fnr)\n");
            for(int i = 0; i < pasientListe.stoerrelse(); i++){
                Pasient pasient = pasientListe.hent(i);
                String pasientNavn = pasient.hentNavn();
                String foedselsnummer = pasient.hentFødselsnr();
                skriver.append(pasientNavn + ", " + foedselsnummer + "\n");
            }

            skriver.append("# Legemidler (navn, type, pris, virkestoff [, styrke])\n");
            for(int i = 0; i < legemiddelListe.stoerrelse(); i++){
                Legemiddel legemiddel = legemiddelListe.hent(i);
                String legemiddelNavn = legemiddel.hentNavn();
                String type = "";
                String styrke = "";
                if(legemiddel instanceof Narkotisk){
                    type = "narkotisk";
                    styrke = Integer.toString(legemiddel.hentStyrke());
                } else if (legemiddel instanceof Vanedannende){
                    type = "vanedannende";
                    styrke = Integer.toString(legemiddel.hentStyrke());
                } else if ( legemiddel instanceof VanligLegemiddel){
                    type = "vanlig";
                }
                String pris = Double.toString(legemiddel.hentPris());
                String virkestoff = Double.toString(legemiddel.hentVirkestoff());
                skriver.append(legemiddelNavn + ", " + type +", "+ pris +", "+ virkestoff +", "+ styrke +"\n");
            }

            skriver.append("# Leger (navn, kontrollid / 0 hvis vanlig lege)\n");
            for(int i = 0; i < legeListe.stoerrelse(); i++){
                Lege lege = legeListe.hent(i);
                String legeNavn = lege.hentNavn();
                String kontrollId = Integer.toString(lege.hentKontrollId());
                skriver.append(legeNavn + ", " + kontrollId + "\n");
            }

            skriver.append("# Resepter (legemiddelNummer, legeNavn, pasientID, typeresept, reit)\n");
            for(int i = 0; i < reseptListe.stoerrelse(); i++){
                Resept resept = reseptListe.hent(i);
                String legemiddelNummer = resept.hentLegemiddelNr();
                String legeNavn = resept.hentLege();
                String pasientId = Integer.toString(resept.hentPasientId());
                String type = "";
                if(resept instanceof MilitaerResept){
                    type = "militaer";
                } else if(resept instanceof PResept){
                    type = "p";
                } else if(resept instanceof HvitResept){
                    type = "hvit";
                } else if (resept instanceof BlaaResept){
                    type = "blaa";
                } 
                String reit = Integer.toString(resept.hentReit());
                skriver.append(legemiddelNummer + ", " + legeNavn + ", " + pasientId + ", " + type + ", " + reit +"\n");
            }
        skriver.close();
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    protected void seLegeliste(){
      for (int i = 0; i < leger.stoerrelse(); i++) {
        System.out.print(i+" "+leger.hent(i).navn);
        System.out.print(", "+leger.hent(i).ikkeSpesialist+"\n");}
    }

    protected void sePasientListe(){
      for (int i = 0; i < pasienter.stoerrelse(); i++) {
          System.out.println(i +": "+ pasienter.hent(i).toString());}
    }

    protected void seLegemiddelListe(){
      for (int i = 0; i < legemidler.stoerrelse(); i++) {
        System.out.println(i + ": " + legemidler.hent(i).navn);}
    }

    protected void seReseptListe(){
      for (int i = 0; i < resepter.stoerrelse(); i++) {
        System.out.println(i +": "+ resepter.hent(i).legemiddelet.navn +" "+ resepter.hent(i).reit);}
    }

    protected boolean leggTilPasientliste(String navn, String fnr){
        Pasient pasient = new Pasient(navn, fnr);
        pasienter.leggTil(pasient);
        return true;
    }

    protected boolean leggTilLegeliste(String navn, String kontrollId){
        Lege lege = new Lege(navn, Integer.parseInt(kontrollId));
        leger.leggTil(lege);
        return true;
    }

    protected boolean leggTilLegemiddelliste(String navn, String type, String pris, String virkestoff, String styrke){
        Legemiddel legemiddel = null;

        if(type.equals("narkotisk") || type.equals("1")){ //Narkotisk
            legemiddel = new Narkotisk(navn, Double.parseDouble(pris), Double.parseDouble(virkestoff), Integer.parseInt(styrke));

        } else if(type.equals("vanedannende") || type.equals("2")) { //Vanedannende
            legemiddel= new Vanedannende(navn, Double.parseDouble(pris), Double.parseDouble(virkestoff), Integer.parseInt(styrke));

        } else if(type.equals("vanlig") || type.equals("3")){ //Vanlig
            legemiddel = new VanligLegemiddel(navn, Double.parseDouble(pris), Double.parseDouble(virkestoff));
        } else{
            return false;
        }
        legemidler.leggTil(legemiddel);
        return true;
    }

    protected boolean leggTilReseptliste(String legemiddelNummer, String legeNavn, String pasientId, String typeresept, String reit){
        if(Integer.parseInt(legemiddelNummer) > (legemidler.stoerrelse()-1) || Integer.parseInt(pasientId) > (pasienter.stoerrelse()-1)){
            return false;
        }
        Legemiddel legemiddel = legemidler.hent(Integer.parseInt(legemiddelNummer));
        Lege ritkigLege = null;

        for(Lege enLege : leger){
            if(legeNavn.equals(enLege.hentNavn())){
                ritkigLege = enLege;
            }
        }
        Pasient pasient = pasienter.hent(Integer.parseInt(pasientId));
        Resept resepten = null;
        if (typeresept.equals("hvit") || typeresept.equals("1")){
            try {
                resepten = ritkigLege.skrivHvitResept(legemiddel, pasient, Integer.parseInt(reit));
            } catch (UlovligUtskrift u) {
                System.out.println(u.getMessage());
                return false;
            }
        } else if (typeresept.equals("militaer") || typeresept.equals("2")) {
            try {
                resepten = ritkigLege.skrivMilitaerResept(legemiddel, pasient, Integer.parseInt(reit));
            } catch (UlovligUtskrift u) {
                System.out.println(u.getMessage());
                return false;
            }
        } else if (typeresept.equals("p") || typeresept.equals("3")) {
            try {
                resepten = ritkigLege.skrivPResept(legemiddel, pasient);
            } catch (UlovligUtskrift u) {
                System.out.println(u.getMessage());
                return false;
            }
        } else if (typeresept.equals("blaa") || typeresept.equals("4")) {
            try {
                resepten = ritkigLege.skrivBlaaResept(legemiddel, pasient, Integer.parseInt(reit));
            } catch (UlovligUtskrift u) {
                System.out.println(u.getMessage());
                return false;
            }
        }
        resepter.leggTil(resepten);
        pasient.leggTilResept(resepten);
        return true;
    }
}
