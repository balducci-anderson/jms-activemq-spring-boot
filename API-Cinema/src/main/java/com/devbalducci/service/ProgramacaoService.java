package com.devbalducci.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.devbalducci.dto.ProgramacaoDto;
import com.devbalducci.form.ProgramacaoForm;
import com.devbalducci.message.ProgramacaoMessage;

@Service
public class ProgramacaoService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@SuppressWarnings("unchecked")
	public List<ProgramacaoDto> getByData(String data) {
		
		jmsTemplate.convertAndSend("programacao-send-data", data);
		
		return (List<ProgramacaoDto>)((List<ProgramacaoMessage>)jmsTemplate
				.receiveAndConvert("programacao-receive")).stream().map(ProgramacaoDto::new)
				.collect(Collectors.toList());
	}
	
	public ProgramacaoDto create(ProgramacaoForm programacaoForm, Long idFilme) throws JmsException, JMSException{
		
		jmsTemplate.convertAndSend("programacao-create", new ProgramacaoMessage(programacaoForm, idFilme));
		
		ProgramacaoMessage programacaoMessage = 
			(ProgramacaoMessage)jmsTemplate.receiveAndConvert("programacao-created");
		
		return new ProgramacaoDto(programacaoMessage);
	}
}
