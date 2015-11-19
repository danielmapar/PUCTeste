package br.com.tcc.bo;

import java.util.Date;
import java.util.Map;

import br.com.tcc.model.Sprint;

public class BurnupBO {
	
	private double qtdeHorasRestantes;
	private double totalHoras;
	private double qtdeHorasConsumidas;
	private double consumoDiarioIdeal;
	
	/**
	 * @author daniel
	 * @since 16/11/2015
	 * @param sprint
	 */
	public void gerarBurnupHoras(Sprint sprint){
		
	
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