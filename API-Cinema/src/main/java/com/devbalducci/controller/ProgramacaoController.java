package com.devbalducci.controller;

import java.util.List;

import javax.jms.JMSException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbalducci.dto.ProgramacaoDto;
import com.devbalducci.form.ProgramacaoForm;
import com.devbalducci.service.ProgramacaoService;

@RestController
@RequestMapping("/programacao")
public class ProgramacaoController {

	@Autowired
	private ProgramacaoService programacaoService;
	
	@GetMapping("/{data}")
	@Transactional
	public ResponseEntity<List<ProgramacaoDto>> getByData(@PathVariable String data) {

		return ResponseEntity.ok(programacaoService.getByData(data));
	}
	
	@PostMapping("/{idFilme}")
	@Transactional
	public ResponseEntity<ProgramacaoDto> create(@RequestBody @Valid ProgramacaoForm programacaoForm,
			@PathVariable Long idFilme) throws JmsException, JMSException{
		return ResponseEntity.ok(programacaoService.create(programacaoForm, idFilme));
	}
}
