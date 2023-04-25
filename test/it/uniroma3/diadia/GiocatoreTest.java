package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;

	@BeforeEach
	void setUp() {
		giocatore = new Giocatore();
	}

	@Test
	void testGetCfu() {
		assertEquals(20, this.giocatore.getCfu());
	}
	
	@Test
	void testSetCfu() {
		giocatore.setCfu(1);
		assertEquals(1, this.giocatore.getCfu());
	}
	
	@Test
	void testGetBorsa1() {
		assertEquals("Borsa vuota", this.giocatore.getBorsa().toString());
	}
	
	@Test
	void testGetBorsa2() {
		this.giocatore.getBorsa().addAttrezzo(new Attrezzo("martello", 3));
		assertNotEquals("Borsa vuota", this.giocatore.getBorsa().toString());
	}

}
