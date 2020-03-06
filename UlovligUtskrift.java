class UlovligUtskrift extends Exception{
  UlovligUtskrift(Lege l, Legemiddel lm){
    super("legen " + l.hentNavn() + "har ikke lov aa skrive ut " + lm.hentNavn());
  }
}
