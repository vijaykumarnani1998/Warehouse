package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vijay.util.EmailUtil;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws MessagingException {
		ConfigurableApplicationContext ctxt=SpringApplication.run(Application.class, args);
		EmailUtil emailutil=ctxt.getBean(EmailUtil.class);
		emailutil.sendEmail("kumarvijay15855@gmail.com", "Welocme to UOm Model", "Hello  Vijay Garu" );

	}

}
