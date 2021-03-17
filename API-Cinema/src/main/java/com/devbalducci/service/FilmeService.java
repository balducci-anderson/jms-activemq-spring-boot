package com.devbalducci.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.devbalducci.dto.FilmeDto;
import com.devbalducci.message.FilmeMessage;

@Service
public class FilmeService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public FilmeMessage create(FilmeMessage filmeMessage) {
		jmsTemplate.convertAndSend("filme-create", filmeMessage);
		return (FilmeMessage)jmsTemplate.receiveAndConvert("filme-created");
	}
	
	@SuppressWarnings("unchecked")
	public List<FilmeDto> getAll(){
		
		jmsTemplate.convertAndSend("filme-getAll", "1");
		
		return ((List<FilmeMessage>)jmsTemplate.receiveAndConvert("filme-gotAll"))
				.stream().map(FilmeDto::new).collect(Collectors.toList());
		
	}
}
