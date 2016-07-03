package br.com.jkavdev.algaworks.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// recebe um arrays de classes que configurarao o projeto
		return new Class<?>[] { AppWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// definindo mapeamento da aplicacao
		// comecara apos o nome do contexto
		return new String[] { "/" };
	}

}
