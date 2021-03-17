package com.devbalducci.message;

import java.io.Serializable;

import com.devbalducci.dominio.Filme;

public class FilmeMessage implements Serializable {

	private static final long serialVersionUID = 2259165432325596306L;
	
	private Long id;
	private String titulo;
	private String genero;
	private String sinopse;
	private String diretor;
	private int duracao;
	
	public FilmeMessage(Filme filme) {
		this.diretor = filme.getDiretor();
		this.duracao = filme.getDuracao();
		this.genero = filme.getGenero();
		this.id = filme.getId();
		this.sinopse = filme.getSinopse();
		this.titulo = filme.getTitulo();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public Filme converterParaFilme() {
		Filme filme = new Filme();
		filme.setDiretor(diretor);
		filme.setDuracao(duracao);
		filme.setGenero(genero);
		filme.setSinopse(sinopse);
		filme.setTitulo(titulo);
		return filme;
	}
}
