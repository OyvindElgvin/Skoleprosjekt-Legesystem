public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

	/*
	legger til elementer i en sortert lenkeliste hvor de første i alfabetet
	ligger til venstre og bakerst i alfabetet til høyre. Fjern() fjerner det
	siste elementet, altså det helt til høyre.
	*/

	// legger til element i sorte rekkefølge fra minst til størst, etter at
	// det er lagt til er lista sortert
	@Override
	public void leggTil(T x) {
		if (start == null) {			// hvis lista er tom, legg til element
			start = new Node(x);
		} else {						// hvis ikke tom, legg til på riktig plass
			Node p = start;
			int pos = 0;
			while (x.compareTo(p.data) > 0 && p.neste != null) {	// mens x er større enn pekerens.data og neste element ikke er null
				p = p.neste;										// flytter pekeren til etter dette
				pos ++;												// tar vare på indexen
			}
			if (p.neste == null && x.compareTo(p.data) > 0) { 		// hvis x er større enn det siste elementet, flytter pekere til etter dette
				pos ++;
			}
			super.leggTil(pos, x);		// legger til på vanlig måte med posisjon
		}
	}

	// fjerner det største elementet, det lengst til høyre
	@Override
	public T fjern() {
		T returneres = super.fjern(stoerrelse()-1);
		return returneres;
	}

	// det er ikke lov til å overskrive elementer ved en gitt posisjon fordi lista skal være sortert
	@Override
	public void sett(int pos, T x) {
		throw new UnsupportedOperationException();
	}

	// det er ikke lov til å legge till elementer ved en gitt posisjon fordi lista skal være sortert
	@Override
	public void leggTil(int pos, T x) {
		throw new UnsupportedOperationException();
	}
}
