package ar.edu.unlam.pb2.marvel;

public class Espacio  extends Gema implements Hechizable{

	@Override
	public Integer incrementarPoder(Personaje nuevo) {

		Integer poderFinal = nuevo.getPoder() * 2;
		nuevo.setPoder(poderFinal);
		return poderFinal;
	}
	
	

}
