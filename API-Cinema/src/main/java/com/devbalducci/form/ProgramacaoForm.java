package com.devbalducci.form;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProgramacaoForm {

	private LocalDate data;
	private LocalTime horario;
	private String sala;

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
}
