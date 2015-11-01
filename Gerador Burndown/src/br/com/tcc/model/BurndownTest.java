package br.com.tcc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BurndownTest {
	
	private Burndown burndown;

	@Before 
	public void initialize() {
		// Cria uma instancia valida de Burndown
		this.burndown = new Burndown();
	}
	
	@Test
	public void testQtdeHorasConsumidas() {
		this.burndown.setQtdeHorasConsumidas(10);
		assertEquals((Double) 10.00, (Double) this.burndown.getQtdeHorasConsumidas());
	}
	
	@Test
	public void testQtdeHorasRestantes() {
		this.burndown.setQtdeHorasRestantes(10);
		assertEquals((Double) 10.00, (Double) this.burndown.getQtdeHorasRestantes());
	}
	
	@Test
	public void testTotalHoras() {
		this.burndown.setTotalHoras(10);
		assertEquals((Double) 10.00, (Double) this.burndown.getTotalHoras());
	}
	
	@Test
	public void testConsumoDiarioIdeal() {
		this.burndown.setConsumoDiarioIdeal(10);
		assertEquals((Double) 10.00, (Double) this.burndown.getConsumoDiarioIdeal());
	}
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.burndown = null;
	}	
	
}
