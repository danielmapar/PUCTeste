package br.com.tcc.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemHistoricoTest {
	
	private ItemHistorico itemHistorico;

	@Before 
	public void initialize() {
		// Cria uma instancia valida de ItemHistorico
		this.itemHistorico = new ItemHistorico();
	}
	
	@Test
	public void testData() {
		Date agora = new Date();
		this.itemHistorico.setData(agora);
		assertEquals((Date) agora, (Date) this.itemHistorico.getData());
	}
	
	@Test
	public void testTempoGasto() {
		this.itemHistorico.setTempoGasto(10.00);
		assertEquals((Double) 10.00, (Double) this.itemHistorico.getTempoGasto());
	}
	
	@Test
	public void testCodEstoria() {
		this.itemHistorico.setCodEstoria(10);
		assertEquals((Integer) 10, (Integer) this.itemHistorico.getCodEstoria());
	}
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.itemHistorico = null;
	}
}