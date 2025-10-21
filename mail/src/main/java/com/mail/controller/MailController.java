package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mail.datatransferobject.MailRequestDTO;
import com.mail.service.MailService;

@RequestMapping("/api")
@Controller
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@PostMapping("/mail")
	public ResponseEntity<Void> sendMail(@RequestBody MailRequestDTO mailRequestDTO) {
		boolean result = mailService.sendMail(mailRequestDTO.getTo(), mailRequestDTO.getSubject(), mailRequestDTO.getSubject());
		if(result) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.TOO_EARLY);
	}
}
