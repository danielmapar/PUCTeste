package br.com.tcc.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//import br.com.tcc.bo.BurndownBO;
import br.com.tcc.bo.BurnupBO;
import br.com.tcc.bo.SprintBO;
import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;

public class Main {

	private static final int QTDE_DIAS_SPRINT = 7;
	private static final String DT_INICIO_SPRINT = "08/09/2014";
	private static SprintBO sprintBO = new SprintBO();
	
	public static void main(String[] args) throws ParseException {
		Sprint sprint = criaSprint();
		
		//BurndownBO burndown = new BurndownBO();
		//burndown.gerarBurndownHoras(sprint);
		//burndown.gerarBurndownPontos(sprint);
		
		BurnupBO burnup = new BurnupBO();
		burnup.gerarBurnupHoras(sprint);
	}
	

	/* Essa aplicação não possui comunicação com banco de dados.
	   Sendo assim, os métodos abaixo servem para criar os objetos com os valores 
	   necessários para o teste da geração dos gráficos.
	 */

	/**
	 * Cria um objeto do tipo Sprint com valores fixos
	 * @return
	 * @throws ParseException
	 */
	private static Sprint criaSprint() throws ParseException {
		Sprint sprint = new Sprint();
		sprint.setDtInicio(DataUtil.converteStringParaDate(DT_INICIO_SPRINT));
		sprint.setQtdeDias(QTDE_DIAS_SPRINT);
		sprint.setEstorias(criaListaEstorias());
		
		sprint.setTotalHoras(sprintBO.calculaTotalHoras(sprint));
				
		//cria historico de entradas
		sprint.setItensHistorico(criaItensHistorico());
		
		return sprint;
	}
	
	/**
	 * Cria uma lista de ItensHistorico com valores de entrada fixos
	 * @return
	 * @throws ParseException
	 */
	public static List<ItemHistorico> criaItensHistorico() throws ParseException{
		
		ItemHistorico item1 = new ItemHistorico();
		item1.setCodEstoria(2);
		item1.setTempoGasto(100);
		item1.setData(DataUtil.converteStringParaDate("08/09/2014"));
		
		ItemHistorico item2 = new ItemHistorico();
		item2.setCodEstoria(3);
		item2.setTempoGasto(-22);
		item2.setData(DataUtil.converteStringParaDate("09/09/2014"));
		
		ItemHistorico item3 = new ItemHistorico();
		item3.setCodEstoria(4);
		item3.setTempoGasto(-32);
		item3.setData(DataUtil.converteStringParaDate("10/09/2014"));
		
		ItemHistorico item4 = new ItemHistorico();
		item4.setCodEstoria(4);
		item4.setTempoGasto(-42);
		item4.setData(DataUtil.converteStringParaDate("11/09/2014"));
		
		List<ItemHistorico> itens = new ArrayList<ItemHistorico>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		itens.add(item4);
		
		return itens;
	}
	
	/**
	 * Cria uma lista de objetos do tipo Estoria com valores fixos
	 * @return
	 */
	public static List<Estoria> criaListaEstorias(){
		
		List<Estoria> estorias = new ArrayList<Estoria>();
		
		Estoria est1 = new Estoria();
		est1.setTempoEstimado(40);
		est1.setCodEstoria(1);
		est1.setQtdePontos(5);

		Estoria est2 = new Estoria();
		est2.setTempoEstimado(32);
		est2.setCodEstoria(2);
		est2.setQtdePontos(3);
		
		Estoria est3 = new Estoria();
		est3.setTempoEstimado(10);
		est3.setCodEstoria(3);
		est3.setQtdePontos(1);
		
		Estoria est4 = new Estoria();
		est4.setTempoEstimado(88);
		est4.setCodEstoria(4);
		est4.setQtdePontos(8);

		
		estorias.add(est1);
		estorias.add(est2);
		estorias.add(est3);
		estorias.add(est4);
		
		return estorias;
	}

}
