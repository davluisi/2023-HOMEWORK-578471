package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	private Borsa vuota;
	private Borsa nonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	void setUp() {
		this.vuota = new Borsa();
		this.nonVuota = new Borsa();
		this.osso = new Attrezzo("osso", 1);
		this.nonVuota.addAttrezzo(osso);
	}

	@Test
	void testAddAttrezzo1() {
		this.vuota.addAttrezzo(osso);
		assertTrue(this.vuota.hasAttrezzo("osso"));
		
	}

	@Test
	void testAddAttrezzo2() {
		assertFalse(this.vuota.addAttrezzo(new Attrezzo("armadio", 50)));
	}
	
	@Test
	void testAddAttrezzo3() {
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		assertFalse(this.nonVuota.addAttrezzo(new Attrezzo("martello", 3)));
	}
	
	@Test
	void testIsEmpty1() {
		assertTrue(this.vuota.isEmpty());
	}
	
	@Test
	void testIsEmpty2() {
		assertFalse(this.nonVuota.isEmpty());
	}
	
	@Test
	void testIsEmpty3() {
		this.vuota.addAttrezzo(osso);
		assertFalse(this.vuota.isEmpty());
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
	void testHasAttrezzo3() {
		this.vuota.addAttrezzo(osso);
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}

	@Test
	void testRemoveAttrezzo1() {
		this.nonVuota.removeAttrezzo("osso");
		assertFalse(this.nonVuota.hasAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzo2() {
		assertNull(this.vuota.removeAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzo3() {
		assertEquals(osso, this.nonVuota.removeAttrezzo("osso"));
	}
}
