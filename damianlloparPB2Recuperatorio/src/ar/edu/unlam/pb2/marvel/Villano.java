package ar.edu.unlam.pb2.marvel;

public class Villano extends Personaje {

	private Gema tipoGema;

	public Villano(Integer poder, String nombre, Gema tipoGema, String tipo) {
		super(poder, nombre, tipo);
		this.tipoGema = tipoGema;

	}

	
	public Gema getTipoGema() {
		return tipoGema;
	}

	public void setTipoGema(Gema tipoGema) {
		this.tipoGema = tipoGema;
	}


	public Integer poderTotal(Gema gema) {

		Integer poderTotal = this.getPoder();

		if (gema.equals(Gema.MENTE) || gema.equals(Gema.PODER) || gema.equals(Gema.TIEMPO)) {
			poderTotal = super.getPoder() * 3;
			this.setPoder(poderTotal);
		}
		if (gema.equals(Gema.ALMA) || gema.equals(Gema.ESPACIO) || gema.equals(Gema.REALIDAD)) {
			poderTotal = super.getPoder() * 2;
			this.setPoder(poderTotal);
		}

		return poderTotal;

	}

}
