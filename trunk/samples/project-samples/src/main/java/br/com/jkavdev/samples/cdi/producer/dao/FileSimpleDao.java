package br.com.jkavdev.samples.cdi.producer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSimpleDao implements SimpleDao {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final String baseDir;

	// uma vez que esta implementacao do SimpleDao
	// nao tem um constructor default, ela nao e um bean
	// por isso o cdi nao procurara por ela
	public FileSimpleDao(String baseDir) {
		this.baseDir = baseDir;
	}

	@Override
	public void doSomething() {
		log.info("invoking doSomething() eith baseDir{}", baseDir);
	}

}
