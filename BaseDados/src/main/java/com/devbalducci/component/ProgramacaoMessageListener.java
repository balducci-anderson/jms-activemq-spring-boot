package com.devbalducci.component;

import java.time.LocalDate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.devbalducci.conversor.Conversor;
import com.devbalducci.dominio.Programacao;
import com.devbalducci.message.ProgramacaoMessage;
import com.devbalducci.service.FilmeService;
import com.devbalducci.service.ProgramacaoService;

@Component
public class ProgramacaoMessageListener {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ProgramacaoService programacaoService;
	
	@Autowired
	private FilmeService filmeService;
	
	@JmsListener(destination = "programacao-send-data")
	public void onReceiverQueue(String message) throws Exception {
		
		LocalDate data = Conversor.stringParaData(message);
		
		jmsTemplate.convertAndSend("programacao-receive", programacaoService.getByData(data));
	}
	
	@JmsListener(destination = "programacao-create")
	public void onReceiverQueue(Message message) throws JMSException {
		
		ProgramacaoMessage programacaoMessage = (ProgramacaoMessage)((ObjectMessage)message).getObject();
		
		Programacao programacao = programacaoService.create(programacaoMessage
				.converterParaProgramacao(filmeService));
		
		jmsTemplate.convertAndSend("programacao-created", new ProgramacaoMessage(programacao));
	}
}
