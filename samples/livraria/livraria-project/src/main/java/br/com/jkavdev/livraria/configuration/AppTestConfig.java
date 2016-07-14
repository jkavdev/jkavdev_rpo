package br.com.jkavdev.livraria.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.livraria.repository.IGeneroRepository;

@Configuration
public class AppTestConfig {

	@Bean
	public IGeneroRepository generoRepository(){
		IGeneroRepository IGeneroRepository = null;
		return IGeneroRepository;
	}

}
