package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

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
		assertTrue(this.nonVuota.addAttrezzo(new Attrezzo("martello", 3)));
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

	@Test
	void testGetContenutoOrdinatoPerPeso1() {
		this.nonVuota.addAttrezzo(new Attrezzo("casa", 3));
		this.nonVuota.addAttrezzo(new Attrezzo("palazzo", 3));
		this.nonVuota.addAttrezzo(new Attrezzo("matita", 0));
		List<Attrezzo> lista = this.nonVuota.getContenutoOrdinatoPerPeso();
		assertEquals("matita", lista.get(0).getNome());
		assertEquals("osso", lista.get(1).getNome());
		assertEquals("casa", lista.get(2).getNome());
		assertEquals("palazzo", lista.get(3).getNome());
	}

	@Test
	void testGetContenutoOrdinatoPerNome1() {
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("arnese", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("zucca", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("pipa", 0));
		SortedSet<Attrezzo> insieme = this.nonVuota.getContenutoOrdinatoPerNome();
		assertEquals("zucca", insieme.last().getNome());
		assertEquals("arnese", insieme.first().getNome());
	}

	@Test
	void testGetContenutoRaggruppatoPerPeso1() {
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("arnese", 1));
		this.nonVuota.addAttrezzo(new Attrezzo("zucca", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("pipa", 1));	
		Map<Integer, Set<Attrezzo>> mappa = this.nonVuota.getContenutoRaggruppatoPerPeso();
		System.out.println("\n");
		System.out.print(mappa);
	}
	
	@Test
	void testGetSortedSetOrdinatoPerPeso1() {
		this.nonVuota.addAttrezzo(new Attrezzo("martello", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("zucca", 0));
		this.nonVuota.addAttrezzo(new Attrezzo("penna", 2));
		SortedSet<Attrezzo> insieme = this.nonVuota.getSortedSetOrdinatoPerPeso();
		assertEquals("martello", insieme.first().getNome());
		System.out.println("\n");
		System.out.print(insieme);
	}
}
