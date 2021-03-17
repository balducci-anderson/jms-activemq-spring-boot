package com.devbalducci.message;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.devbalducci.form.ProgramacaoForm;

public class ProgramacaoMessage implements Serializable {

	private static final long serialVersionUID = 8174307087336241241L;

	private FilmeMessage filmeMessage;
	private LocalDate data;
	private LocalTime horario;
	private String sala;
	
	public ProgramacaoMessage(ProgramacaoForm programacaoForm, Long idFilme) {
		this.filmeMessage = new FilmeMessage();
		this.filmeMessage.setId(idFilme);
		this.data = programacaoForm.getData();
		this.horario = programacaoForm.getHorario();
		this.sala = programacaoForm.getSala();
	}
	
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
	public FilmeMessage getFilmeMessage() {
		return filmeMessage;
	}
	public void setFilmeMessage(FilmeMessage filme) {
		this.filmeMessage = filme;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
}
