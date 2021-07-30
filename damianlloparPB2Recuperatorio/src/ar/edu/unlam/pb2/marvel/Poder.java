package ar.edu.unlam.pb2.marvel;

public class Poder extends Gema implements Hechizable {

	@Override
	public Integer incrementarPoder(Personaje nuevo) {

		Integer poderFinal = nuevo.getPoder() * 3;
		return poderFinal;
	}

}
