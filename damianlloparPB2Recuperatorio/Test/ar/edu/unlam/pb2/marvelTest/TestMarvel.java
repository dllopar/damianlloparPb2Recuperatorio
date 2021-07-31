package ar.edu.unlam.pb2.marvelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.marvel.Alma;
import ar.edu.unlam.pb2.marvel.Batalla;
import ar.edu.unlam.pb2.marvel.Espacio;
import ar.edu.unlam.pb2.marvel.Gema;
import ar.edu.unlam.pb2.marvel.Heroe;
import ar.edu.unlam.pb2.marvel.Personaje;
import ar.edu.unlam.pb2.marvel.Poder;
import ar.edu.unlam.pb2.marvel.Tiempo;
import ar.edu.unlam.pb2.marvel.Villano;
import ar.edu.unlam.pb2.marvel.WorldDestroyedException;

public class TestMarvel {

	@Test
	public void testQueAgregaPersonaje() {
		Personaje heroe = new Heroe(100, "ironman", "heroe", null);
		Villano villano = new Villano(100, "Hela", "villano", null);
		Batalla batalla = new Batalla("batalla1");

		assertTrue(batalla.agregarPersonaje(heroe));
	}

	@Test
	public void testQueCompruebaQueElPersonajeRecibioUnagema() {
		Heroe heroe = new Heroe(120, "ironman", "heroe", null);
		Villano villano = new Villano(100, "Hela", "villano", null);
		Batalla batalla = new Batalla("batalla1");
		Gema alma = new Alma();
		Gema poder = new Poder();

		batalla.agregarPersonaje(heroe);
		batalla.agregarPersonaje(villano);

		batalla.darGema(poder, villano);

		assertEquals(poder, villano.getGema());
	}

	@Test
	public void testQueCompruebaQueElPersonajeMultiplicoElPoder() {
		Heroe heroe = new Heroe(120, "ironman", "heroe", null);
		Villano villano = new Villano(100, "Hela", "villano", null);
		Batalla batalla = new Batalla("batalla1");
		Gema alma = new Alma();
		Gema poder = new Poder();

		batalla.agregarPersonaje(heroe);
		batalla.agregarPersonaje(villano);

		batalla.darGema(poder, villano);
		Integer esperado = villano.getPoder();
		Integer actual = 300;

		assertEquals(esperado, actual);

	}

	@Test
	public void testQueEnfrentaUnHeroeYUnVillanoYGanaElHeroe() {
		Heroe heroe = new Heroe(120, "ironman", "heroe", null);
		Villano villano = new Villano(100, "Hela", "villano", null);
		Batalla batalla = new Batalla("batalla1");
		Gema alma = new Alma();
		Gema poder = new Poder();

		batalla.agregarPersonaje(heroe);
		batalla.agregarPersonaje(villano);

		batalla.darGema(poder, heroe);
		batalla.batallaDePersonajes(heroe, villano);
		Integer esperado = batalla.heroesGanadores();
		Integer actual = 1;

		assertEquals(esperado, actual);

	}

	@Test
	public void testQueNoDejaDarMasDeTresGemasALosHeroes() {
		Batalla batalla = new Batalla("batalla1");
		Personaje ironman = new Heroe(120, "ironman", "heroe", null);
		Heroe hulk = new Heroe(100, "hulk", "heroe", null);
		Personaje capitan = new Heroe(60, "Capitan America", "heroe", null);
		Heroe thor = new Heroe(90, "Thor", "heroe", null);

		Gema alma = new Alma();
		Gema poder = new Poder();
		Gema espacio = new Espacio();
		Gema tiempo = new Tiempo();

		batalla.agregarPersonaje(ironman);
		batalla.agregarPersonaje(hulk);
		batalla.agregarPersonaje(capitan);
		batalla.agregarPersonaje(thor);

		batalla.darGema(poder, ironman);
		batalla.darGema(alma, hulk);
		batalla.darGema(espacio, capitan);
		
		
		assertFalse(batalla.darGema(tiempo, thor));

	}
	
	@Test
	public void testQueElMundoSeSalvaPorQueGananLosHeroes() throws WorldDestroyedException {
		Batalla batalla = new Batalla("batalla1");
		Personaje ironman = new Heroe(100, "ironman", "heroe", null);
		Heroe hulk = new Heroe(100, "hulk", "heroe", null);
		Personaje capitan = new Heroe(100, "Capitan America", "heroe", null);
		
		Personaje Ronnan = new Heroe(90, "Ronnan", "villano", null);
		Heroe Hela = new Heroe(90, "Hela", "villano", null);
		Personaje Loki = new Heroe(60, "Loki", "villano", null);
		

		Gema alma = new Alma();
		Gema poder = new Poder();
		Gema espacio = new Espacio();
		Gema tiempo = new Tiempo();

		batalla.agregarPersonaje(ironman);
		batalla.agregarPersonaje(hulk);
		batalla.agregarPersonaje(capitan);
		batalla.agregarPersonaje(Ronnan);
		batalla.agregarPersonaje(Hela);
		batalla.agregarPersonaje(Loki);
		
		
		batalla.darGema(poder, ironman);
		batalla.darGema(alma, hulk);
		batalla.darGema(espacio, capitan);
		
		batalla.batallaDePersonajes(ironman, Ronnan);
		batalla.batallaDePersonajes(hulk, Hela);
		batalla.batallaDePersonajes(capitan, Loki);
		
		assertTrue(batalla.WorldDestroyed());
	}
	
	@Test(expected= WorldDestroyedException.class)
	public void testQueElMundoEsDestruido() throws WorldDestroyedException {
		Batalla batalla = new Batalla("batalla1");
		Personaje ironman = new Heroe(100, "ironman", "heroe", null);
		Heroe hulk = new Heroe(100, "hulk", "heroe", null);
		Personaje capitan = new Heroe(100, "Capitan America", "heroe", null);
		
		Personaje Ronnan = new Heroe(90, "Ronnan", "villano", null);
		Heroe Hela = new Heroe(90, "Hela", "villano", null);
		Personaje Loki = new Heroe(60, "Loki", "villano", null);
		

		Gema alma = new Alma();
		Gema poder = new Poder();
		Gema espacio = new Espacio();
		Gema tiempo = new Tiempo();

		batalla.agregarPersonaje(ironman);
		batalla.agregarPersonaje(hulk);
		batalla.agregarPersonaje(capitan);
		batalla.agregarPersonaje(Ronnan);
		batalla.agregarPersonaje(Hela);
		batalla.agregarPersonaje(Loki);
		
		
		batalla.darGema(poder, Ronnan);
		batalla.darGema(alma, Hela);
		batalla.darGema(espacio, Loki);
		
		batalla.batallaDePersonajes(ironman, Ronnan);
		batalla.batallaDePersonajes(hulk, Hela);
		batalla.batallaDePersonajes(capitan, Loki);
		
		assertTrue(batalla.WorldDestroyed());
	}
	

	/*
	 * @Test public void testQueTriplicaElPoderSegunLaGema() {
	 * 
	 * Personaje heroe = new Heroe(100, "Hulk", Gema.MENTE, "heroe"); Personaje
	 * villano = new Villano(100, "Hela", Gema.ALMA, "villano");
	 * 
	 * Integer esperado = 300; Integer actual = heroe.poderTotal(Gema.PODER);
	 * 
	 * assertEquals(esperado, actual);
	 * 
	 * }
	 * 
	 * @Test public void testQueEnfrentaDosPersonajesYGanaElHeroe() {
	 * 
	 * Batalla endGame = new Batalla("EndGame");
	 * 
	 * Personaje heroe = new Heroe(100, "Hulk", Gema.PODER, "heroe"); Personaje
	 * villano = new Villano(100, "Hela", Gema.ALMA, "villano");
	 * 
	 * heroe.poderTotal(Gema.PODER); villano.poderTotal(Gema.ALMA);
	 * 
	 * Personaje esperado = heroe; Personaje actual =
	 * endGame.batallaDePersonajes(heroe, villano);
	 * 
	 * assertEquals(esperado, actual);
	 * 
	 * }
	 * 
	 * @Test public void testQueEnDevuelveCuantosVillanosGanadoresHay() {
	 * 
	 * Batalla endGame = new Batalla("EndGame");
	 * 
	 * Personaje heroe = new Heroe(20, "Hulk", Gema.PODER, "heroe"); Personaje
	 * villano = new Villano(100, "Hela", Gema.ALMA, "villano"); Personaje heroe2 =
	 * new Heroe(30, "ironman", Gema.PODER, "heroe"); Personaje villano2 = new
	 * Villano(100, "soldado del invierno", Gema.ALMA, "villano");
	 * 
	 * heroe.poderTotal(Gema.PODER); villano.poderTotal(Gema.ALMA);
	 * heroe2.poderTotal(Gema.MENTE); villano2.poderTotal(Gema.TIEMPO);
	 * 
	 * endGame.batallaDePersonajes(heroe, villano);
	 * endGame.batallaDePersonajes(heroe2, villano2);
	 * 
	 * Integer esperado = 2; Integer actual = endGame.villanosGanadores();
	 * 
	 * assertEquals(esperado, actual);
	 * 
	 * }
	 * 
	 * @Test(expected = WorldDestroyedException.class) public void
	 * queNoSePuedaVenderUnProductoInexistente() throws WorldDestroyedException {
	 * 
	 * Batalla endGame = new Batalla("EndGame");
	 * 
	 * Personaje heroe = new Heroe(20, "Hulk", Gema.PODER, "heroe"); Personaje
	 * villano = new Villano(100, "Hela", Gema.ALMA, "villano"); Personaje heroe2 =
	 * new Heroe(30, "ironman", Gema.PODER, "heroe"); Personaje villano2 = new
	 * Villano(100, "soldado del invierno", Gema.TIEMPO, "villano");
	 * 
	 * heroe.poderTotal(Gema.PODER); villano.poderTotal(Gema.ALMA);
	 * heroe2.poderTotal(Gema.MENTE); villano2.poderTotal(Gema.TIEMPO);
	 * 
	 * endGame.batallaDePersonajes(heroe, villano);
	 * endGame.batallaDePersonajes(heroe2, villano2);
	 * 
	 * endGame.WorldDestroyed();
	 * 
	 * }
	 * 
	 * @Test public void testQuePermiteOrdenarALosHeroesPorNombre() {
	 * 
	 * Batalla endGame = new Batalla("EndGame");
	 * 
	 * Personaje heroe = new Heroe(200, "Hulk", Gema.PODER, "heroe"); Personaje
	 * villano = new Villano(10, "Hela", Gema.ALMA, "villano"); Personaje heroe2 =
	 * new Heroe(300, "ironman", Gema.REALIDAD, "heroe"); Personaje villano2 = new
	 * Villano(10, "soldado del invierno", Gema.TIEMPO, "villano"); Personaje heroe3
	 * = new Heroe(300, "thor", Gema.MENTE, "heroe"); Personaje villano3 = new
	 * Villano(10, "soldado del invierno", Gema.ESPACIO, "villano");
	 * 
	 * heroe.poderTotal(Gema.PODER); villano.poderTotal(Gema.ALMA);
	 * heroe2.poderTotal(Gema.REALIDAD); villano2.poderTotal(Gema.TIEMPO);
	 * heroe3.poderTotal(Gema.MENTE); villano3.poderTotal(Gema.ESPACIO);
	 * 
	 * 
	 * endGame.batallaDePersonajes(heroe, villano);
	 * endGame.batallaDePersonajes(heroe2, villano2);
	 * endGame.batallaDePersonajes(heroe3, villano3);
	 * 
	 * assertEquals(endGame.heroesGanadores.first(), heroe);
	 * assertEquals(endGame.heroesGanadores.last(), heroe3); }
	 */

}
