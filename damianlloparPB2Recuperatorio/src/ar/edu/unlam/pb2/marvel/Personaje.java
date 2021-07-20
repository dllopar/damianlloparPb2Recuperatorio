package ar.edu.unlam.pb2.marvel;

public abstract class Personaje {
	
	private Integer poder;

	public Personaje(Integer poder) {
		this.poder=poder;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}
	
	//public abstract Integer triplicaPoder(Gema gema);
	
	//public abstract Integer duplicaPoder(Gema gema);
	
	public abstract Integer poderTotal(Gema gema);
	

}
