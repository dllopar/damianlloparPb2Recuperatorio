package ar.edu.unlam.pb2.marvel;

import java.util.TreeSet;

public class Batalla {
	
	public String nombre;
	//public TreeSet<Personaje>personajes;
	public TreeSet<Heroe>heroes;
	public TreeSet<Villano>villanos;
	
	public Batalla(String nombre) {
		this.nombre=nombre;
		heroes=new TreeSet<>();
		villanos = new TreeSet<>();
		//personajes=new TreeSet<>();
	}
	
	public Personaje batallaDePersonajes(Personaje heroe, Personaje villano) {
		Personaje ganador=villano;
		if(heroe.getPoder()>villano.getPoder()) {
			ganador=heroe;
		}
		
		return ganador;
	}
	
	public Gema gemaDelPersonaje(Personaje personaje) {
		
		
		
		return null;
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Heroe> getHeroes() {
		return heroes;
	}

	public void setHeroes(TreeSet<Heroe> heroes) {
		this.heroes = heroes;
	}

	public TreeSet<Villano> getVillanos() {
		return villanos;
	}

	public void setVillanos(TreeSet<Villano> villanos) {
		this.villanos = villanos;
	}
	
	
	

}
