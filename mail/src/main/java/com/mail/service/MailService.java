package com.mail.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.datatransferobject.UserDTO;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String to,String subject,String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("springbootemailprovider@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		return true;
	}
	
	@KafkaListener(topics="user-register",groupId="email-service-group1")
	public void sendWelcomeMail(Map<String,Object> userJSON) throws JsonMappingException, JsonProcessingException {
//		UserDTO userObject = new ObjectMapper().readValue(userJSON, UserDTO.class);
		SimpleMailMessage message = new SimpleMailMessage();
		System.out.println(userJSON);
//		message.setFrom("springbootemailprovider@gmail.com");
//		message.setTo(userJSON.getEmailId());
//		message.setSubject("Welcome to Playstation");
//		message.setText("Hi "+userJSON.getLastName()+" "+userJSON.getFirstName()+"\n Great to have you onboard!!");
//		
//		mailSender.send(message);
	}
}
