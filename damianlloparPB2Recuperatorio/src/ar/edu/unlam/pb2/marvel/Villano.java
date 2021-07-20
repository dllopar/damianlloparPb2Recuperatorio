package ar.edu.unlam.pb2.marvel;

public class Villano extends Personaje {
	
	private String nombre;
	private Gema tipoGema;

	public Villano(Integer poder, String nombre, Gema tipoGema) {
		super(poder);
		this.nombre=nombre;
		this.tipoGema=tipoGema;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Gema getTipoGema() {
		return tipoGema;
	}

	public void setTipoGema(Gema tipoGema) {
		this.tipoGema = tipoGema;
	}
	
	

}
