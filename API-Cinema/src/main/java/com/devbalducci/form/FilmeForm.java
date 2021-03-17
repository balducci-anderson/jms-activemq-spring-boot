package com.devbalducci.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.devbalducci.message.FilmeMessage;

public class FilmeForm {

	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String genero;
	@NotNull
	@NotEmpty
	private String sinopse;
	@NotNull
	@NotEmpty
	private String diretor;
	@NotNull
	private int duracao;
	
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
	
	public FilmeMessage converteParaFilmeMessage() {
		FilmeMessage filmeMessage = new FilmeMessage();
		filmeMessage.setDiretor(diretor);
		filmeMessage.setDuracao(duracao);
		filmeMessage.setGenero(genero);
		filmeMessage.setSinopse(sinopse);
		filmeMessage.setTitulo(titulo);
		return filmeMessage;
	}
}