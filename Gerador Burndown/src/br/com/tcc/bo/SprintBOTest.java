package br.com.tcc.bo;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;
import br.com.tcc.util.Main;

public class SprintBOTest {
	
	private Sprint sprint;

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
		this.sprint = criaSprint("08/09/2014", 7);
	}
	
	@Test
	public void testCalculaTotalHoras() {
		assertEquals((Double) 170.00, (Double) new SprintBO().calculaTotalHoras(this.sprint));
	}
	
	@Test
	public void testCalculaTotalPontos() {
		assertEquals((Integer) 17, (Integer) new SprintBO().calculaTotalPontos(this.sprint));
	}
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.sprint = null;
	}	
	
}
