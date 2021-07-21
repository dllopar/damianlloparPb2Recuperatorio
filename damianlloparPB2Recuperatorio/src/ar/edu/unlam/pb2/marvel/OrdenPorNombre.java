package ar.edu.unlam.pb2.marvel;

import java.util.Comparator;

public class OrdenPorNombre implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}



}
