package br.com.caelum;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

	@Bean(destroyMethod = "close")
	public DataSource getDataSource() throws PropertyVetoException {
		//adicionando pool do c3p0
	    ComboPooledDataSource dataSource = new ComboPooledDataSource();

	    dataSource.setDriverClass("com.mysql.jdbc.Driver");
	    dataSource.setJdbcUrl("jdbc:mysql://localhost/db_jpa_avancado_alura");
	    dataSource.setUser("jkavdev");
	    dataSource.setPassword("123456");
	    
	    //adicionando quantidade de conexao a serem abertas
//	    dataSource.setInitialPoolSize(3);
	    
	    dataSource.setMinPoolSize(3);
	    dataSource.setMaxPoolSize(5);
	    
	    // a cada um segundo testamos as conexões ociosas
	    dataSource.setIdleConnectionTestPeriod(1);

	    return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setPackagesToScan("br.com.caelum");
		entityManagerFactory.setDataSource(dataSource);

		entityManagerFactory
				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		entityManagerFactory.setJpaProperties(props);
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

}
