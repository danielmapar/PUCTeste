package br.com.tcc.bo;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;
import br.com.tcc.util.Main;

public class BurndownBOTest {
	
	private Sprint sprint1;
	private Sprint sprint2;
	private Sprint sprint3;
	private Map<Date,Integer> eixoXY1;
	private Map<Date,Integer> eixoXY2;
	private Map<Date,Integer> eixoXY3;
	
	private Map<Date, Integer> geraEixoXYPontos(Sprint sprint) {
		Map<Date,Integer> eixoXY = new LinkedHashMap<Date,Integer>();
	    
		//eixoY
		for (ItemHistorico item : sprint.getItensHistorico()) {
			for (Estoria est : sprint.getEstorias()) {
				if (item.getCodEstoria().equals(est.getCodEstoria())){
					est.setTempoGasto(item.getTempoGasto());
					
					if (est.getTempoRestante() == 0){
						if (eixoXY.get(item.getData()) != null){
							eixoXY.put(item.getData(), eixoXY.get(item.getData()) + est.getQtdePontos());
						} else {
							eixoXY.put(item.getData(), est.getQtdePontos());
						}
					}
					
				}
			}
		}
		
		//Dias ainda não trabalhados
		if (eixoXY.size() < sprint.getQtdeDias()){
			for (int i = 0; i < sprint.getQtdeDias(); i++){
				if (!eixoXY.containsKey(DataUtil.adicionarDiasData(sprint.getDtInicio(), i))){
					eixoXY.put(DataUtil.adicionarDiasData(sprint.getDtInicio(), i), null);
				}
			}
		}
		return eixoXY;
	}
	
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
		this.sprint2 = criaSprint("10/09/2014", 45);
		this.sprint3 = criaSprint("08/12/2014", 10);
		
		this.eixoXY1 = geraEixoXYPontos(this.sprint1);		
		this.eixoXY2 = geraEixoXYPontos(this.sprint2);
		this.eixoXY3 = geraEixoXYPontos(this.sprint3);
	}
	
	@Test
	public void testGerarBurndownHoras() {
		new BurndownBO().gerarBurndownHoras(this.sprint1);
	}
	
	@Test
	public void testGerarBurndownPontos() throws ParseException {
		// Cobertura de comandos e branches (geraEixoXYPontos) e teste blackbox
		Map<Date,Integer> eixoXY1 = new BurndownBO().gerarBurndownPontos(criaSprint("08/09/2014", 7));
		assertEquals(this.eixoXY1, eixoXY1);
		
		Map<Date,Integer> eixoXY2 = new BurndownBO().gerarBurndownPontos(criaSprint("10/09/2014", 45));
		assertEquals(this.eixoXY2, eixoXY2);
		
		Map<Date,Integer> eixoXY3 = new BurndownBO().gerarBurndownPontos(criaSprint("08/12/2014", 10));
		assertEquals(this.eixoXY3, eixoXY3);
	}
	
	@Test
	public void testQtdeHorasRestantes() {
		BurndownBO burndownBO = new BurndownBO();
		burndownBO.setQtdeHorasRestantes(10);
		assertEquals((Double)10.00, (Double) burndownBO.getQtdeHorasRestantes());
	}
	
	@Test
	public void testTotalHoras() {
		BurndownBO burndownBO = new BurndownBO();
		burndownBO.setTotalHoras(10);
		assertEquals((Double)10.00, (Double) burndownBO.getTotalHoras());
	}
	
	@Test
	public void testQtdeHorasConsumidas() {
		BurndownBO burndownBO = new BurndownBO();
		burndownBO.setQtdeHorasConsumidas(10);
		assertEquals((Double)10.00, (Double) burndownBO.getQtdeHorasConsumidas());
	}
	
	@Test
	public void testConsumoDiarioIdeal() {
		BurndownBO burndownBO = new BurndownBO();
		burndownBO.setConsumoDiarioIdeal(10);
		assertEquals((Double)10.00, (Double) burndownBO.getConsumoDiarioIdeal());
	}
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.sprint1 = null;
		this.sprint2 = null;
		
		this.eixoXY1 = null;
		this.eixoXY2 = null;
	}	
	
}
