package com.devbalducci.conversor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversor {

	public static LocalDate stringParaData(String stringData) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(stringData, formatador);
	}
}
