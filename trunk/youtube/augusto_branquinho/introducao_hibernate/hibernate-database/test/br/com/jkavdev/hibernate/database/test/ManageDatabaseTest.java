package br.com.jkavdev.hibernate.database.test;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class ManageDatabaseTest {

	// private final Logger logger = Logger.getLogger(this.getClass());
	private static final Logger logger = Logger.getLogger(ManageDatabaseTest.class);

	@Test
	public void createTables() {
		logger.info("creating tables.");

		Configuration configuration = new Configuration();
		configuration.configure();
		new SchemaExport(configuration).create(true, true);
	}

	@Test
	public void dropTables() {
		logger.info("droping tables.");

		Configuration configuration = new Configuration();
		configuration.configure();
		new SchemaExport(configuration).drop(true, true);
	}

	public static void main(String[] args) {
		logger.info("creating tables.");

		Configuration configuration = new Configuration();
		configuration.configure();
		new SchemaExport(configuration).create(true, true);
	}

}
