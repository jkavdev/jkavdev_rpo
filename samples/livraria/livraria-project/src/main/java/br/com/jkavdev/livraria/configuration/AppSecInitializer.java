package br.com.jkavdev.livraria.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(1)
public class AppSecInitializer 
	extends AbstractSecurityWebApplicationInitializer {

}
