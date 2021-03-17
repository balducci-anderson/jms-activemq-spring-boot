package com.devbalducci.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devbalducci.dominio.Programacao;
import com.devbalducci.message.ProgramacaoMessage;
import com.devbalducci.repository.ProgramacaoRepository;

@Service
public class ProgramacaoService {

	@Autowired
	private ProgramacaoRepository programacaoRepository;
	
	public List<ProgramacaoMessage> getByData(LocalDate data) {
		
		return programacaoRepository.findByData(data).stream()
				.map(ProgramacaoMessage::new).collect(Collectors.toList());
	}
	
	public Programacao create(Programacao programacao) {
		programacaoRepository.save(programacao);
		return programacao;
	}
}
