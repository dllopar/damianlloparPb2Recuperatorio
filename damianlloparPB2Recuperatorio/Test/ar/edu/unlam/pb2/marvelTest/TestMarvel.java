package ar.edu.unlam.pb2.marvelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.marvel.Batalla;
import ar.edu.unlam.pb2.marvel.Gema;
import ar.edu.unlam.pb2.marvel.Heroe;
import ar.edu.unlam.pb2.marvel.Personaje;
import ar.edu.unlam.pb2.marvel.Villano;

public class TestMarvel {

	@Test
	public void testQueTriplicaElPoderSegunLaGema(){
		
		Personaje heroe = new Heroe(100, "Hulk", Gema.MENTE);
		Personaje villano = new Villano(100, "Hela", Gema.ALMA);
		
		Integer esperado=300;
		Integer actual = heroe.poderTotal(Gema.PODER);
				
		assertEquals(esperado, actual);
		
	}
	
	
	@Test
	public void testQueEnfrentaDosPersonajesYGanaElHeroe(){
		
		Batalla endGame = new Batalla("EndGame");
		
		Personaje heroe = new Heroe(100, "Hulk", Gema.PODER);
		Personaje villano = new Villano(100, "Hela", Gema.ALMA);
		
		heroe.poderTotal(Gema.PODER);
		villano.poderTotal(Gema.ALMA);
		
		Personaje esperado= heroe;
		Personaje actual = endGame.batallaDePersonajes(heroe, villano);
		
		
				
		assertEquals(esperado, actual);
		
	}
	

}
