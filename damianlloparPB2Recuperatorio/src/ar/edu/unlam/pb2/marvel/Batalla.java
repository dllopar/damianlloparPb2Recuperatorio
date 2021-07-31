package ar.edu.unlam.pb2.marvel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Batalla {

	private String nombre;
	private Set<Personaje> personajes;
	private TreeSet<Personaje> heroesGanadores;
	private TreeSet<Personaje> villanosGanadores;

	public Batalla(String nombre) {
		this.nombre = nombre;
		personajes = new TreeSet<>();
		heroesGanadores = new TreeSet<>();
		villanosGanadores = new TreeSet<>();
		
	}

	public Boolean agregarPersonaje(Personaje personaje) {
		return personajes.add(personaje);
		
	}

	public Personaje batallaDePersonajes(Personaje heroe, Personaje villano) {
		Personaje ganador = null;
		if (heroe.getPoder() > villano.getPoder()) {
			heroesGanadores.add(heroe);
			ganador = heroe;

		} else {
			villanosGanadores.add(villano);
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

	public TreeSet<Personaje> mostrarHeroesGanadoresPorOrden() {
		OrdenPorNombre nuevoOrden = new OrdenPorNombre();
		TreeSet<Personaje> nuevoTreeSet = new TreeSet<>(nuevoOrden);
		nuevoTreeSet.addAll(heroesGanadores);

		return nuevoTreeSet;

	}

	public TreeSet<Personaje> mostrarVillanosGanadoresPorOrden() {
		OrdenPorNombre nuevoOrden = new OrdenPorNombre();
		TreeSet<Personaje> nuevoTreeSet = new TreeSet<>(nuevoOrden);
		nuevoTreeSet.addAll(villanosGanadores);

		return (TreeSet<Personaje>) nuevoTreeSet.descendingSet();

	}

	public Boolean WorldDestroyed() throws WorldDestroyedException {
		Boolean zafamos = false;
		if (villanosGanadores.size() > heroesGanadores.size()) {
			throw new WorldDestroyedException();
		} else {
			zafamos = true;
		}
		return zafamos;
	}

	public Boolean darGema(Gema gema, Personaje personaje) {
		Boolean aumentaPoder = false;
		if(personaje.getTipo().equals("heroe") && contarGemasHeroes() < 3) {
			personaje.setGema(gema);
			gema.incrementarPoder(personaje);
			aumentaPoder = true;
		}
		else if(personaje.getTipo().equals("villano") &&contarGemasVillanos() < 3) {
			personaje.setGema(gema);
			gema.incrementarPoder(personaje);
			aumentaPoder = true;
		}
		
		return aumentaPoder;
	}
	
	
	

	public Integer contarGemasHeroes() {
		Integer contadorHeroe = 0;

		for (Personaje personaje2 : personajes) {
			if (personaje2.getTipo().equalsIgnoreCase("heroe") && personaje2.getGema() != null) {
				contadorHeroe++;

			}
		}

		return contadorHeroe;
	}

	public Integer contarGemasVillanos() {
		Integer contadorVillano = 0;
		for (Personaje personaje2 : personajes) {
			if (personaje2.getTipo().equals("villano") && personaje2.getGema() != null) {
				contadorVillano++;
			}
		}
		return contadorVillano;
	}
	
	public Integer cantidadDePersonajes() {
		return personajes.size();
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
