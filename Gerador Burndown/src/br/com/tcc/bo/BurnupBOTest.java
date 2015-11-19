package br.com.tcc.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BurnupBOTest {
	
	@Test
	public void testQtdeHorasRestantes() {
		BurnupBO burnupBO = new BurnupBO();
		burnupBO.setQtdeHorasRestantes(10);
		assertEquals((Double)10.00, (Double) burnupBO.getQtdeHorasRestantes());
	}
	
	@Test
	public void testTotalHoras() {
		BurnupBO burnupBO = new BurnupBO();
		burnupBO.setTotalHoras(10);
		assertEquals((Double)10.00, (Double) burnupBO.getTotalHoras());
	}
	
	@Test
	public void testQtdeHorasConsumidas() {
		BurnupBO burnupBO = new BurnupBO();
		burnupBO.setQtdeHorasConsumidas(10);
		assertEquals((Double)10.00, (Double) burnupBO.getQtdeHorasConsumidas());
	}
	
	@Test
	public void testConsumoDiarioIdeal() {
		BurnupBO burnupBO = new BurnupBO();
		burnupBO.setConsumoDiarioIdeal(10);
		assertEquals((Double)10.00, (Double) burnupBO.getConsumoDiarioIdeal());
	}
	

}
