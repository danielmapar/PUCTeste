package br.com.tcc.model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tcc.util.DataUtil;

public class HistoricoTest {
	
	private Historico historico;

	@Before 
	public void initialize() {
		// Cria uma instancia valida de Historico
		this.historico = new Historico();
	}
	
	@Test
	public void testItens() throws ParseException {
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
		
		this.historico.setItens(itens);
		assertEquals(itens, this.historico.getItens());
	}

	@After 
	public void clear() {
		// Destruir instancias 
		this.historico = null;
	}
}
