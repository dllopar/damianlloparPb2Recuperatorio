package ar.edu.unlam.pb2.marvel;

public class Villano extends Personaje {


	public Villano(Integer poder, String tipo, String nombre, Gema gema) {
		super(poder, tipo, nombre, gema);

	}

	@Override
	public int compareTo(Personaje o) {
		// TODO Auto-generated method stub
		return super.getNombre().compareTo(o.getNombre());
	}


}
