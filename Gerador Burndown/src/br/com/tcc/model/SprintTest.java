package br.com.tcc.model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tcc.util.DataUtil;

public class SprintTest {
	
	private Sprint sprint;

	@Before 
	public void initialize() {
		// Cria uma instancia valida de Sprint
		this.sprint = new Sprint();
	}
	
	@Test
	public void testDtInicio() {
		Date agora = new Date();
		this.sprint.setDtInicio(agora);
		assertEquals((Date) agora, (Date) this.sprint.getDtInicio());
	}
	
	@Test
	public void testDtFim() {
		Date agora = new Date();
		this.sprint.setDtFim(agora);
		assertEquals((Date) agora, (Date) this.sprint.getDtFim());
	}
	
	@Test
	public void testEstorias() {
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
		
		this.sprint.setEstorias(estorias);
		assertEquals(estorias, this.sprint.getEstorias());
	}
	
	@Test
	public void testTotalHoras() {
		this.sprint.setTotalHoras(10.00);
		assertEquals((Double) 10.00, (Double) this.sprint.getTotalHoras());
	}
	
	@Test
	public void testQtdeDias() {
		this.sprint.setQtdeDias(10);
		assertEquals((Integer) 10, (Integer) this.sprint.getQtdeDias());
	}
	
	@Test
	public void testItensHistorico() throws ParseException {
		ItemHistorico item = new ItemHistorico();
		item.setCodEstoria(1);
		item.setTempoGasto(34);
		item.setData(DataUtil.converteStringParaDate("08/09/2014"));
		
		ItemHistorico item2 = new ItemHistorico();
		item2.setCodEstoria(2);
		item2.setTempoGasto(18);
		item2.setData(DataUtil.converteStringParaDate("09/09/2014"));
		
		ItemHistorico item3 = new ItemHistorico();
		item3.setCodEstoria(3);
		item3.setTempoGasto(15);
		item3.setData(DataUtil.converteStringParaDate("10/09/2014"));

		
		List<ItemHistorico> itens = new ArrayList<ItemHistorico>();
		itens.add(item);
		itens.add(item2);
		itens.add(item3);
		
		this.sprint.setItensHistorico(itens);
		assertEquals(itens, this.sprint.getItensHistorico());
	}
	
	@After 
	public void clear() {
		// Destruir instancias 
		this.sprint = null;
	}
}
