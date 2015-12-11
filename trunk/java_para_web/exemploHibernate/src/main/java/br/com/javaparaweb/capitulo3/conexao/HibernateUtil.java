package br.com.javaparaweb.capitulo3.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			//construtor dos servicos do hibernate que trabalha junto com o registrador 
			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());
			//registrador de servicos do hibernate
			StandardServiceRegistry servico = registradorServico.build();
			return cfg.buildSessionFactory(servico);
		} catch (Throwable e) {
			System.out.println("Cria��o Inicial do objeto SessionFactory falhou! : " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
