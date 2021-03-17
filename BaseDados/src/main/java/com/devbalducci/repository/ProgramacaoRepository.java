package com.devbalducci.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devbalducci.dominio.Programacao;

@Repository
public interface ProgramacaoRepository extends JpaRepository<Programacao, Long> {
	
	public List<Programacao> findByData(LocalDate data);

}
