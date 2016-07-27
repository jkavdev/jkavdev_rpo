package br.com.jkavdev.spring.persistence;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
@ComponentScan(basePackageClasses = PersistenceConfig.class)
public class PersistenceConfig {

	@Autowired
	private Environment environment;

	@Bean
	public AnnotationSessionFactoryBean sessionFactory() {
		
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] { "br.com.jkavdev.spring.persistence.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource restDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.user"));
		dataSource.setPassword(environment.getProperty("jdbc.pass"));
		
		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
			}
		};
	}
}
