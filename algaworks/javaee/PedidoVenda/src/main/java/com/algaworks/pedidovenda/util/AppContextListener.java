package com.algaworks.pedidovenda.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//por padrao o tomcat quando a campos submetidos do tipo inteiro
//ele faz a conversao para o valor zero

//podemos mudar esta configuracao para que nao ocorra

@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//informando quando no deploy da aplicacao
		//para nao converter campos inteiros para zero
		System.setProperty("org.apache.el.parser,COERCE_TO_ZERO", "false");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

}
