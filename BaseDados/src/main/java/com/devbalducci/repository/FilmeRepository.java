package com.devbalducci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devbalducci.dominio.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
