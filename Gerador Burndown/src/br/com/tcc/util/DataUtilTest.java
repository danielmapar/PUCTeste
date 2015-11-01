package br.com.tcc.util;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DataUtilTest {

	@Test
	public void testConverteStringParaDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(DataUtil.converteStringParaDate("20/05/1993"), (java.util.Date)formatter.parse("20/05/1993"));
	}
	
	@Test
	public void testDateToString() {
		Date agora = new Date();
		SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");  
		String result = formatBra.format(agora); 
		assertEquals(result, DataUtil.dateToString(agora));
	}
	
	@Test
	public void testAdicionarDiasData() {
		Date agora = new Date();
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(agora);  
		calendar.add(Calendar.DAY_OF_MONTH, 10);  
		assertEquals(calendar.getTime(), DataUtil.adicionarDiasData(agora, 10));  
	}
}
