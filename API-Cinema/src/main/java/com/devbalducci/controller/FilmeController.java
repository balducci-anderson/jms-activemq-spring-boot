package com.devbalducci.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.devbalducci.dto.FilmeDto;
import com.devbalducci.form.FilmeForm;
import com.devbalducci.message.FilmeMessage;
import com.devbalducci.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FilmeDto> create(@RequestBody @Valid FilmeForm filmeForm, UriComponentsBuilder uriBuilder) {
		
		FilmeMessage filmeMessage = filmeForm.converteParaFilmeMessage();
		
		URI uri = uriBuilder.path("/filme/{id}").buildAndExpand(filmeMessage.getId()).toUri();
		
		filmeMessage = filmeService.create(filmeMessage);
		
		return ResponseEntity.created(uri).body(new FilmeDto(filmeMessage));
	}
	
	@GetMapping
	public ResponseEntity<List<FilmeDto>> getAll(){
		
		return ResponseEntity.ok(filmeService.getAll());
	}
	
}
