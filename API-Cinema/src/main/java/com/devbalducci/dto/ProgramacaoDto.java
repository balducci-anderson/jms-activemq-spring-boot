package com.devbalducci.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.devbalducci.message.ProgramacaoMessage;

public class ProgramacaoDto {

	private String filme;
	private LocalDate data;
	private LocalTime horario;
	private String sala;

	public ProgramacaoDto(ProgramacaoMessage programacaoMessage) {
		this.filme = programacaoMessage.getFilmeMessage().getTitulo();
		this.data = programacaoMessage.getData();
		this.horario = programacaoMessage.getHorario();
		this.sala = programacaoMessage.getSala();
	}
	
	public String getFilme() {
		return filme;
	}
	public void setFilme(String filme) {
		this.filme = filme;
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
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
}
