package br.com.tcc.bo;

public class BurnupBO {
	
	private double qtdeHorasRestantes;
	private double totalHoras;
	private double qtdeHorasConsumidas;
	
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
		return 0;
	}

	public void setConsumoDiarioIdeal(double consumoDiarioIdeal) {
		
	}
	
}