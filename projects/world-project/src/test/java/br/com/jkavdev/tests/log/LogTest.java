package br.com.jkavdev.tests.log;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

	//usando um log definido
	private final Logger logger = Logger.getLogger("lopes");

	@Test
	public void logTest() {
		logger.info("Testando info");
		logger.debug("nao sera logado, apresentado");
		logger.error("This is Error message", new Exception("Testing"));
	}

}
