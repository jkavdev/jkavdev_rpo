package br.com.jkavdev.algaworks.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//recomendado pelo spring para iniciar estas configuracoes de banco
		//no inicio da aplicacao
		return new Class<?>[] { AppJpaConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// recebe um arrays de classes que configurarao o projeto
		//sera configurado depois do rootConfig
		return new Class<?>[] { AppWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// definindo mapeamento da aplicacao
		// comecara apos o nome do contexto
		return new String[] { "/" };
	}

}
