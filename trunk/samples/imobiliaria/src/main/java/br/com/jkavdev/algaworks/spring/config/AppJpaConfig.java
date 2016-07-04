package br.com.jkavdev.algaworks.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.jkavdev.algaworks.spring.model.Imovel;
import br.com.jkavdev.algaworks.spring.repository.Imoveis;

//configuracao do jpa

@Configuration
@ComponentScan(basePackageClasses = { Imoveis.class })
//habilitando gerenciamento de transacao pelo spring
@EnableTransactionManagement
public class AppJpaConfig {

	//informacoes de conexao com o banco de dados
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/db_algaworks_imobiliaria");
		dataSource.setUsername("jkavdev");
		dataSource.setPassword("123456");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}

	//informacoes sobre a implementacao do jpa
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}

	//gerenciamento do EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
		//local onde estao as entidades
		entityManagerFactory.setPackagesToScan(Imovel.class.getPackage().getName());
		entityManagerFactory.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");	
		return entityManagerFactory;
	}

	//gerenciador de transacao
	@Bean
	public PlatformTransactionManager transactionManager( LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
		return transactionManager;
	}

}
