package com.example.demo;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
@Configuration
public class MessageConfig {
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource  messagesource=new ResourceBundleMessageSource();
		messagesource.setBasename("message");
		messagesource.setDefaultEncoding("UTF-8");
		return messagesource;
		
	}
}
