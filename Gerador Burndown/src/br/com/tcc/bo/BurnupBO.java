package br.com.tcc.bo;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;

public class BurnupBO {
	
	private double qtdeHorasRestantes;
	private double totalHoras;
	private double qtdeHorasConsumidas;
	private double consumoDiarioIdeal;
	private final static String TITLE_HORAS = "HOUR BURNUP CHART- Sprint 01";
	
	/**
	 * @author daniel
	 * @since 16/11/2015
	 * @param sprint
	 */
	public void gerarBurnupHoras(Sprint sprint){
		
		Map<Date,Double> eixoXY = calculaEixosXYHoras(sprint);
		setTotalHoras(sprint.getTotalHoras());
		
		qtdeHorasRestantes = totalHoras - qtdeHorasConsumidas;
		
		setConsumoDiarioIdeal(totalHoras / sprint.getQtdeDias());
		
		LineChart demo = new LineChart("Comparison", TITLE_HORAS, eixoXY, totalHoras, consumoDiarioIdeal);
        demo.pack();
        demo.setVisible(true);
	}
	
	/**
	 * Método responsável por calcular os valores dos eixos X e Y do grafico de burndown, 
	 * onde o eixo X são as datas (dias do sprint) e o Y são as horas.
	 * @author kessia e daniel
	 * @since 16/09/2014
	 * @param sprint
	 * @return Map<Date, Double>
	 */
	private Map<Date, Double> calculaEixosXYHoras(Sprint sprint) {
		Map<Date,Double> eixoXY = new LinkedHashMap<Date,Double>();
	     
		//eixoY
		for (ItemHistorico item : sprint.getItensHistorico()) {
			if (eixoXY.get(item.getData()) != null){
				eixoXY.put(item.getData(), eixoXY.get(item.getData()) + item.getTempoGasto());
			} else {
				eixoXY.put(item.getData(), item.getTempoGasto());
			}
			qtdeHorasConsumidas += item.getTempoGasto();
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
	
	public double getQtdeHorasRestantes() {
		return qtdeHorasRestantes;
	}

	public void setQtdeHorasRestantes(double qtdeHorasRestantes) {
		this.qtdeHorasRestantes = qtdeHorasRestantes;
	}
	
	public double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(double totalHoras) {
		this.totalHoras = totalHoras;
	}
	
	public double getQtdeHorasConsumidas() {
		return qtdeHorasConsumidas;
	}

	public void setQtdeHorasConsumidas(double qtdeHorasConsumidas) {
		this.qtdeHorasConsumidas = qtdeHorasConsumidas;
	}
	
	public double getConsumoDiarioIdeal() {
		return consumoDiarioIdeal;
	}

	public void setConsumoDiarioIdeal(double consumoDiarioIdeal) {
		this.consumoDiarioIdeal = consumoDiarioIdeal;
	}
	
}