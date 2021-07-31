package ar.edu.unlam.pb2.marvel;

public class Heroe extends Personaje {

	public Heroe(Integer poder, String nombre, String tipo, Gema gema) {
		super(poder, tipo, nombre, gema);

	}

	@Override
	public int compareTo(Personaje o) {
		// TODO Auto-generated method stub
		return super.getNombre().compareTo(o.getNombre());
	}
	
	

}
