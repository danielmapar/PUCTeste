package br.com.tcc.bo;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;
import br.com.tcc.util.Main;

public class BurnupBOTest {
	
	private Sprint sprint1;
	
	private Sprint criaSprint(final String DT_INICIO_SPRINT, final int QTDE_DIAS_SPRINT) throws ParseException {
		// Cria uma instancia valida de Sprint
		Sprint sprint = new Sprint();
		sprint.setDtInicio(DataUtil.converteStringParaDate(DT_INICIO_SPRINT));
		sprint.setQtdeDias(QTDE_DIAS_SPRINT);
		sprint.setEstorias(Main.criaListaEstorias());
		
		sprint.setTotalHoras(new SprintBO().calculaTotalHoras(sprint));
						
		//cria historico de entradas
		sprint.setItensHistorico(Main.criaItensHistorico());
		
		return sprint;
	}
	
	@Before 
	public void initialize() throws ParseException {
		// Cria uma instancia valida de Sprint
		this.sprint1 = criaSprint("08/09/2014", 7);
	}
	
	@Test
	public void testGerarBurnupHoras() {
		new BurnupBO().gerarBurnupHoras(this.sprint1);
	}
	
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
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.sprint1 = null;
	}	
	

}
