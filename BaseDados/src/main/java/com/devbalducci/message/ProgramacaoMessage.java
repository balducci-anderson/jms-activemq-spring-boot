package com.devbalducci.message;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.devbalducci.dominio.Programacao;
import com.devbalducci.service.FilmeService;

public class ProgramacaoMessage implements Serializable {

	private static final long serialVersionUID = 8174307087336241241L;

	private FilmeMessage filmeMessage;
	private LocalDate data;
	private LocalTime horario;
	private String sala;
	
	public ProgramacaoMessage(Programacao programacao) {
		this.filmeMessage = new FilmeMessage(programacao.getFilme());
		this.data = programacao.getData();
		this.horario = programacao.getHorario();
		this.sala = programacao.getSala();
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
	
	public Programacao converterParaProgramacao(FilmeService filmeService) {
		Programacao programacao = new Programacao();
		programacao.setData(data);
		programacao.setFilme(filmeService.getById(filmeMessage.getId()));
		programacao.setHorario(horario);
		programacao.setSala(sala);
		return programacao;
	}
}
