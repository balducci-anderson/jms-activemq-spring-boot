package com.devbalducci.dto;

import com.devbalducci.message.FilmeMessage;

public class FilmeDto {

	private String titulo;
	private String genero;
	private String sinopse;
	private String diretor;
	private int duracao;
	
	public FilmeDto(FilmeMessage filmeMessage) {
		this.titulo = filmeMessage.getTitulo();
		this.genero = filmeMessage.getGenero();
		this.sinopse = filmeMessage.getSinopse();
		this.diretor = filmeMessage.getDiretor();
		this.duracao = filmeMessage.getDuracao();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
