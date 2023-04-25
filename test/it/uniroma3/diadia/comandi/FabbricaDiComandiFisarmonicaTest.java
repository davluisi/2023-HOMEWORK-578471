package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandi factory;
	private Comando comando;

	@BeforeEach
	void setUp() throws Exception {
		factory = new FabbricaDiComandiFisarmonica();
	}

	@Test
	void test1() {
		comando = factory.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	void test2() {
		comando = factory.costruisciComando("prendi matita");
		assertEquals("prendi", comando.getNome());
		assertEquals("matita", comando.getParametro());
	}
	
	@Test
	void test3() {
		comando = factory.costruisciComando("termina");
		assertEquals("comando non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
}
