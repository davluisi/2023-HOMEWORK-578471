package it.uniroma3.diadia;


import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Stanza nonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	public void setUp() {
		this.vuota = new Stanza("vuota");
		this.nonVuota = new Stanza("non-vuota");
		this.osso = new Attrezzo("osso", 1);
		this.nonVuota.addAttrezzo(osso);
	}
	
	@Test
	void testImpostaStanzaAdiacente1() {
		nonVuota.impostaStanzaAdiacente("nord", vuota);
		assertSame(this.nonVuota.getStanzaAdiacente("nord"), vuota);
	}
	
	@Test
	void testImpostaStanzaAdiacente2() {
		assertNull(this.vuota.getStanzaAdiacente("est"));
	}
	
	@Test
	void testaddAttrezzo1() {
		assertFalse(this.vuota.hasAttrezzo("osso"));
	}
	
	@Test
	void testAddAttrezzo2() {
		this.vuota.addAttrezzo(new Attrezzo("osso" , 1));
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}
	
	@Test
	void testAddAttrezzo3() {
		assertFalse(this.nonVuota.addAttrezzo(new Attrezzo("osso", 4)));
	}
	
	@Test 
	void testHasAttrezzo1() {
		assertFalse(this.vuota.hasAttrezzo("osso"));
	}
	
	@Test
	void testHasAttrezzo2() {
		assertTrue(this.nonVuota.hasAttrezzo("osso"));
	}
	
	@Test 
	void testGetAttrezzo1() {
		assertSame(this.osso,this.nonVuota.getAttrezzo("osso"));
	}
	
	@Test
	void testGetAttrezzo2() {
		assertNull(this.vuota.getAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzo1() {
		assertTrue(this.nonVuota.removeAttrezzo("osso"));
	}

	@Test
	void testRemoveAttrezzo2() {
		assertFalse(this.vuota.removeAttrezzo("osso"));
	}
	
	
}
