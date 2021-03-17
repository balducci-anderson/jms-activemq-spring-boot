package com.devbalducci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devbalducci.dominio.Filme;
import com.devbalducci.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Filme create(Filme filme) {
		filmeRepository.save(filme);
		return filme;
	}
	
	public List<Filme> getAll(){
		return filmeRepository.findAll();
	}
	
	public Filme getById(Long id) {
		return filmeRepository.findById(id).get();
	}
}
