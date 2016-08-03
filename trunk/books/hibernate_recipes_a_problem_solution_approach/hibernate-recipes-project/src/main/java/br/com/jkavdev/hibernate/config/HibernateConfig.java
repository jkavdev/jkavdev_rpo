package br.com.jkavdev.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//hibernate Configuration

public class HibernateConfig {

	public void connectionConfig() {
		Configuration configuration = new Configuration();

		// usando o hbm
		// configuration.addResource("br/com/jkavdev/hibernate/model/Book.hbm.xml")
		// .setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQLInnoDBDialect")
		// .setProperty("hibernate.connection.driver_class",
		// "com.mysql.jdbc.Driver")
		// .setProperty("hibernate.connection.url",
		// "jdbc:mysql://localhost:3306/db_hibernate_recipes_books")
		// .setProperty("hibernate.connection.username", "jkavdev")
		// .setProperty("hibernate.connection.password", "123456");

		// mapeando a classe persistente
		// configuration.addClass(Book.class).setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQLInnoDBDialect")
		// .setProperty("hibernate.connection.driver_class",
		// "com.mysql.jdbc.Driver")
		// .setProperty("hibernate.connection.url",
		// "jdbc:mysql://localhost:3306/db_hibernate_recipes_books")
		// .setProperty("hibernate.connection.username", "jkavdev")
		// .setProperty("hibernate.connection.password", "123456");

		// configurando o hibernate pelo xml
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
	}

}
