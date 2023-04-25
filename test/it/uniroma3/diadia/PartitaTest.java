package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partitaVincente;
	private Partita nonVincente;
	private Stanza stanza;

	@BeforeEach
	void setUp() {
		this.partitaVincente = new Partita();
		stanza = this.partitaVincente.getLabirinto().getStanzaVincente();
		this.partitaVincente.setStanzaCorrente(stanza);
		this.nonVincente = new Partita();
	}

	@Test
	void vtestVinta1() {
		assertTrue(this.partitaVincente.vinta());
	}
	
	@Test
	void testVinta2() {
		assertFalse(this.nonVincente.vinta());
	}
	
	@Test
	void testVinta3() {
		this.partitaVincente.setStanzaCorrente(this.nonVincente.getStanzaCorrente());
		assertFalse(this.partitaVincente.vinta());
	}
	

	@Test
	void testIsFinita1() {
		assertTrue(this.partitaVincente.isFinita());
	}
	
	@Test
	void testIsFinita2() {
		this.nonVincente.getGiocatore().setCfu(0);
		assertTrue(this.nonVincente.isFinita());
	}
	
	@Test
	void testIsFinita3() {
		assertFalse(this.nonVincente.isFinita());
	}
	

}
