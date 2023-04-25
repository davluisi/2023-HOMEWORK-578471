package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.ambienti.StanzaMagicaProtected;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	private Stanza magica;
	private Attrezzo attrezzo1 = new Attrezzo("a1", 1);
	private Attrezzo attrezzo2 = new Attrezzo("a2", 2);
	private Attrezzo attrezzo3 = new Attrezzo("a3", 3);
	private Attrezzo attrezzo4 = new Attrezzo("a4", 4);


	@BeforeEach
	void setUp() throws Exception {
		magica = new StanzaMagica("magica");
	}

	@Test
	void test() {
		magica.addAttrezzo(attrezzo1);
		magica.addAttrezzo(attrezzo2);
		magica.addAttrezzo(attrezzo3);
		magica.addAttrezzo(attrezzo4);
		assertEquals("4a", magica.getAttrezzo("4a").getNome());
		assertTrue(magica.getNumeroAttrezzi()==4);
		assertTrue(magica.getAttrezzo("4a").getPeso()==8);
		assertEquals("a3", magica.getAttrezzo("a3").getNome());
		assertTrue(magica.getAttrezzo("a1").getPeso()==1);
	}

}
