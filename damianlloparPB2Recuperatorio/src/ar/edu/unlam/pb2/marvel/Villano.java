package ar.edu.unlam.pb2.marvel;

public class Villano extends Personaje {

	private Gema tipoGema;

	public Villano(Integer poder, String nombre, String tipo) {
		super(poder, nombre, tipo);
		this.tipoGema = null;

	}

	
	public Gema getTipoGema() {
		return tipoGema;
	}

	public void setTipoGema(Gema tipoGema) {
		this.tipoGema = tipoGema;
	}


}
