package ar.edu.unlam.pb2.marvel;

public class Tiempo extends Gema implements Hechizable {

	@Override
	public Integer incrementarPoder(Personaje nuevo) {

		Integer poderFinal = nuevo.getPoder() * 3;
		return poderFinal;
	}

}