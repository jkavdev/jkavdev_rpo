package br.com.jkavdev.financeiro.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// variavel no qual armazenara a factory de conexao
	// sera criada apenas uma vez na aplicacao
	// podendo ser utilizada diversas vezes
	private static final SessionFactory FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// ler o arquivo de configuracao do hibernate
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");

			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(configuration.getProperties());
			StandardServiceRegistry servico = registradorServico.build();

			// retorna buildSession com as propriedades do arquivo de
			// configuracao
			return configuration.buildSessionFactory(servico);
		} catch (Throwable e) {
			System.out.println("Erro SessionFactory: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	// metodo de acesso a factory
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}

}
