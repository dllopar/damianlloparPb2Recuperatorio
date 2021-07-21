package ar.edu.unlam.pb2.marvelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.marvel.Batalla;
import ar.edu.unlam.pb2.marvel.Gema;
import ar.edu.unlam.pb2.marvel.Heroe;
import ar.edu.unlam.pb2.marvel.Personaje;
import ar.edu.unlam.pb2.marvel.Villano;
import ar.edu.unlam.pb2.marvel.WorldDestroyedException;

public class TestMarvel {

	@Test
	public void testQueTriplicaElPoderSegunLaGema() {

		Personaje heroe = new Heroe(100, "Hulk", Gema.MENTE, "heroe");
		Personaje villano = new Villano(100, "Hela", Gema.ALMA, "villano");

		Integer esperado = 300;
		Integer actual = heroe.poderTotal(Gema.PODER);

		assertEquals(esperado, actual);

	}

	@Test
	public void testQueEnfrentaDosPersonajesYGanaElHeroe() {

		Batalla endGame = new Batalla("EndGame");

		Personaje heroe = new Heroe(100, "Hulk", Gema.PODER, "heroe");
		Personaje villano = new Villano(100, "Hela", Gema.ALMA, "villano");

		heroe.poderTotal(Gema.PODER);
		villano.poderTotal(Gema.ALMA);

		Personaje esperado = heroe;
		Personaje actual = endGame.batallaDePersonajes(heroe, villano);

		assertEquals(esperado, actual);

	}

	@Test
	public void testQueEnDevuelveCuantosVillanosGanadoresHay() {

		Batalla endGame = new Batalla("EndGame");

		Personaje heroe = new Heroe(20, "Hulk", Gema.PODER, "heroe");
		Personaje villano = new Villano(100, "Hela", Gema.ALMA, "villano");
		Personaje heroe2 = new Heroe(30, "ironman", Gema.PODER, "heroe");
		Personaje villano2 = new Villano(100, "soldado del invierno", Gema.ALMA, "villano");

		heroe.poderTotal(Gema.PODER);
		villano.poderTotal(Gema.ALMA);
		heroe2.poderTotal(Gema.MENTE);
		villano2.poderTotal(Gema.TIEMPO);

		endGame.batallaDePersonajes(heroe, villano);
		endGame.batallaDePersonajes(heroe2, villano2);

		Integer esperado = 2;
		Integer actual = endGame.villanosGanadores();

		assertEquals(esperado, actual);

	}

	@Test(expected = WorldDestroyedException.class)
	public void queNoSePuedaVenderUnProductoInexistente() throws WorldDestroyedException {

		Batalla endGame = new Batalla("EndGame");

		Personaje heroe = new Heroe(20, "Hulk", Gema.PODER, "heroe");
		Personaje villano = new Villano(100, "Hela", Gema.ALMA, "villano");
		Personaje heroe2 = new Heroe(30, "ironman", Gema.PODER, "heroe");
		Personaje villano2 = new Villano(100, "soldado del invierno", Gema.TIEMPO, "villano");

		heroe.poderTotal(Gema.PODER);
		villano.poderTotal(Gema.ALMA);
		heroe2.poderTotal(Gema.MENTE);
		villano2.poderTotal(Gema.TIEMPO);

		endGame.batallaDePersonajes(heroe, villano);
		endGame.batallaDePersonajes(heroe2, villano2);

		endGame.WorldDestroyed();

	}
	
	@Test
	public void testQuePermiteOrdenarALosHeroesPorNombre() {
		
		Batalla endGame = new Batalla("EndGame");
		
		Personaje heroe = new Heroe(200, "Hulk", Gema.PODER, "heroe");
		Personaje villano = new Villano(10, "Hela", Gema.ALMA, "villano");
		Personaje heroe2 = new Heroe(300, "ironman", Gema.REALIDAD, "heroe");
		Personaje villano2 = new Villano(10, "soldado del invierno", Gema.TIEMPO, "villano");
		Personaje heroe3 = new Heroe(300, "thor", Gema.MENTE, "heroe");
		Personaje villano3 = new Villano(10, "soldado del invierno", Gema.ESPACIO, "villano");

		heroe.poderTotal(Gema.PODER);
		villano.poderTotal(Gema.ALMA);
		heroe2.poderTotal(Gema.REALIDAD);
		villano2.poderTotal(Gema.TIEMPO);
		heroe3.poderTotal(Gema.MENTE);
		villano3.poderTotal(Gema.ESPACIO);
		

		endGame.batallaDePersonajes(heroe, villano);
		endGame.batallaDePersonajes(heroe2, villano2);
		endGame.batallaDePersonajes(heroe3, villano3);
		
		assertEquals(endGame.heroesGanadores.first(), heroe);
		assertEquals(endGame.heroesGanadores.last(), heroe3);
	}
	

}
