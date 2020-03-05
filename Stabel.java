class Stabel <T> extends Lenkeliste <T> {

	/*
	En liggende stabel med toppen på høyre side. Elementer legges på og
	fjernes på høyre side
	*/

	// legger på elementer på slutten av lista, til høyre
	public void leggPaa(T x) {
		super.leggTil(x);
	}

	// tar av elementer på høyre side, helt sist
	public T taAv() {
		T returneres = super.fjern(stoerrelse()-1);
		return returneres;
	}
}
