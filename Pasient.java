class Pasient{
    //Passient som tar inn navn og fødselsnummer
    protected String navn, foedselsnummer;

    //Gir pasienten unik id
    private static int teller = 0;
    private int id;

    //Oppretter en stabel som resepter skal samles i
    private Stabel<Resept> resepter = new Stabel<Resept>();

    public Pasient(String navn, String foedselsnummer){
        this.navn = navn;
        this.foedselsnummer = foedselsnummer;
        id = teller;
        teller++;
    }

    public String hentNavn(){
        return navn;
    }

    public String hentFødselsnr(){
        return foedselsnummer;
    }

    public int hentId(){
        return id;
    }

    public Stabel<Resept> hentResepter(){
        return resepter;
    }

    public void leggTilResept(Resept resept){
        resepter.leggPaa(resept);
    }
}
