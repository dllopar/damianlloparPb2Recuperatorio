package ar.edu.unlam.pb2.marvel;

public abstract class Personaje {
	
	private Integer poder;
	private String tipo;
	private String nombre;
	private Gema gema;

	public Personaje(Integer poder, String tipo, String nombre, Gema gema) {
		this.poder=poder;
		this.tipo=tipo;
		this.nombre=nombre;
		this.setGema(gema);
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Gema getGema() {
		return gema;
	}

	public void setGema(Gema gema) {
		this.gema = gema;
	}


}
