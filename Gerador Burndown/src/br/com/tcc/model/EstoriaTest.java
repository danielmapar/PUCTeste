package br.com.tcc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstoriaTest {
	
	private Estoria estoria;

	@Before 
	public void initialize() {
		// Cria uma instancia valida de Estoria
		this.estoria = new Estoria();
	}
	
	@Test
	public void testTempoRestante() {
		this.estoria.setTempoRestante(10);
		assertEquals((Double) 10.00, (Double) this.estoria.getTempoRestante());
	}
	
	@Test
	public void testTempoGasto() {
		this.estoria.setTempoGasto(10);
		assertEquals((Double) 10.00, (Double) this.estoria.getTempoGasto());
	}
	
	@Test
	public void testTempoEstimado() {
		this.estoria.setTempoEstimado(10);
		assertEquals((Double) 10.00, (Double) this.estoria.getTempoEstimado());
		assertEquals((Double) 10.00, (Double) this.estoria.getTempoRestante());
	}
	
	@Test
	public void testCodEstoria() {
		this.estoria.setCodEstoria(10);
		assertEquals((Integer) 10, (Integer) this.estoria.getCodEstoria());
	}
	
	@Test
	public void testQtdePontos() {
		this.estoria.setQtdePontos(10);
		assertEquals((Integer) 10, (Integer) this.estoria.getQtdePontos());
	}
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.estoria = null;
	}
}