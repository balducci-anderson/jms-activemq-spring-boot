package com.devbalducci.component;

import java.util.stream.Collectors;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.devbalducci.dominio.Filme;
import com.devbalducci.message.FilmeMessage;
import com.devbalducci.service.FilmeService;

@Component
public class FilmeMessageListener {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private FilmeService filmeService;
	
	@JmsListener(destination = "filme-create")
	public void onReceiverQueue(Message message) throws JMSException {
		
		FilmeMessage filmeMessage = (FilmeMessage)((ObjectMessage)message).getObject();
		Filme filme = filmeService.create(filmeMessage.converterParaFilme());
		jmsTemplate.convertAndSend("filme-created", new FilmeMessage(filme));
	}
	
	@JmsListener(destination = "filme-getAll")
	public void onReceiverQueue(String message) {
		
		jmsTemplate.convertAndSend("filme-gotAll", filmeService.getAll().stream()
			.map(FilmeMessage::new).collect(Collectors.toList()));
	}
}
