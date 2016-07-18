package br.com.jkavdev.springmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.jkavdev.springmvc.daos.ProductDAO;
import br.com.jkavdev.springmvc.model.Product;

@Configuration
@ComponentScan(basePackageClasses = { ProductDAO.class })
@EnableTransactionManagement
public class JpaConfiguration {

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "123456";
	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/db_domine_spring_mvc";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "jkavdev";
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(Product.class.getPackage().getName());
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

		return dataSource;
	}

	private Properties additionalProperties() {

		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
		properties.setProperty("hibernate.show_sql", "true");

		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

}