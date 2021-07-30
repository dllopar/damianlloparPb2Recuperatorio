package ar.edu.unlam.pb2.marvel;

public class Heroe extends Personaje {

	
	private Gema tipoGema;

	public Heroe(Integer poder, String nombre, String tipo) {
		super(poder, tipo, nombre);
		this.tipoGema = null;

	}


	public Gema getTipoGema() {
		return tipoGema;
	}

	public void setTipoGema(Gema tipoGema) {
		this.tipoGema = tipoGema;
	}
	
	



}
