package ar.edu.unlam.pb2.marvel;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;



public class Batalla {

	public String nombre;
	public TreeSet<Personaje> personajes;
	public TreeSet<Personaje> heroesGanadores;
	public TreeSet<Personaje> villanosGanadores;

	public Batalla(String nombre) {
		this.nombre = nombre;
		heroesGanadores = new TreeSet<>();
		villanosGanadores = new TreeSet<>();
		personajes=new TreeSet<>();
	}
	
	public Personaje asignarGemaAUnPersonaje() {
		
		Random rand;		
		rand = new Random();
		
		for (Personaje personaje : personajes) {
			Integer aleatorio = rand.nextInt(personajes.size());
			
		}
		
		return null;
		
		//.get(rand.nextInt(personajes.size()))
		
	}

	public Personaje batallaDePersonajes(Personaje heroe, Personaje villano) {
		Personaje ganador = null;
		if (heroe.getPoder() > villano.getPoder()) {
			//personajes.add(heroe);
			ganador = heroe;
			

		} else {
			//personajes.add(villano);
			ganador = villano;
		}

		return ganador;
	}

	public void listadoDeHeroesGanadores() {

		for (Personaje personajeBuscado : personajes) {

			if (personajeBuscado.getTipo().equalsIgnoreCase("heroe")) {
				heroesGanadores.add(personajeBuscado);
			} else {
				villanosGanadores.add(personajeBuscado);
			}

		}

	}

	public TreeSet<Personaje> mostrarHeroesGanadoresPorOrden(){
		OrdenPorNombre nuevoOrden = new OrdenPorNombre();
		TreeSet<Personaje>nuevoTreeSet = new TreeSet<>(nuevoOrden);
		nuevoTreeSet.addAll(heroesGanadores);
		
		return nuevoTreeSet;
		
	}
	
	public TreeSet<Personaje> mostrarVillanosGanadoresPorOrden(){
		OrdenPorNombre nuevoOrden = new OrdenPorNombre();
		TreeSet<Personaje>nuevoTreeSet = new TreeSet<>(nuevoOrden);
		nuevoTreeSet.addAll(villanosGanadores);
		
		return (TreeSet<Personaje>) nuevoTreeSet.descendingSet();
		
	}
	
	public Boolean WorldDestroyed() throws WorldDestroyedException {
		Boolean zafamos = false;
		if(villanosGanadores.size()>heroesGanadores.size()) {
			throw new WorldDestroyedException();
		}else {
			zafamos= true;
		}
		return zafamos;
	}
	


	public Integer heroesGanadores() {
		return heroesGanadores.size();
	}

	public Integer villanosGanadores() {
		return villanosGanadores.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Personaje> getHeroes() {
		return heroesGanadores;
	}

	public void setHeroes(TreeSet<Personaje> heroes) {
		this.heroesGanadores = heroes;
	}

	public TreeSet<Personaje> getVillanos() {
		return villanosGanadores;
	}

	public void setVillanos(TreeSet<Personaje> villanos) {
		this.villanosGanadores = villanos;
	}

	public TreeSet<Personaje> getHeroesGanadores() {
		return heroesGanadores;
	}

	public void setHeroesGanadores(TreeSet<Personaje> heroesGanadores) {
		this.heroesGanadores = heroesGanadores;
	}

	public TreeSet<Personaje> getVillanosGanadores() {
		return villanosGanadores;
	}

	public void setVillanosGanadores(TreeSet<Personaje> villanosGanadores) {
		this.villanosGanadores = villanosGanadores;
	}

}
