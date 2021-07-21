package ar.edu.unlam.pb2.marvel;

public abstract class Personaje {
	
	private Integer poder;
	private String tipo;
	private String nombre;

	public Personaje(Integer poder, String tipo, String nombre) {
		this.poder=poder;
		this.tipo=tipo;
		this.nombre=nombre;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}
	
	
	
	
	//public abstract Integer triplicaPoder(Gema gema);
	
	//public abstract Integer duplicaPoder(Gema gema);
	
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

	public abstract Integer poderTotal(Gema gema);
	

}
