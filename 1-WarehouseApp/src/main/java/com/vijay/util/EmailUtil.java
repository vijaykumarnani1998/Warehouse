package com.vijay.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to,String subject,String body) throws MessagingException
	{
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);
		javaMailSender.send(mimeMessage);
		
	}

	

	
	

}
