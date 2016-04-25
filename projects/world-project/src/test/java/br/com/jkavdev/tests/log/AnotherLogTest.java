package br.com.jkavdev.tests.log;

import org.apache.log4j.Logger;
import org.junit.Test;

public class AnotherLogTest {

	private final Logger logger = Logger.getLogger(this.getClass());
//	private final Logger logger = Logger.getLogger(LogTest.class);
//	private final Logger logger = Logger.getLogger(AnotherLogTest.class);
//	private final Logger logger = Logger.getLogger("lopes");

	@Test
	public void logTest() {
		logger.info("Testando info");
		logger.debug("nao sera logado" + "Nice");
		logger.error("This is Error message", new Exception("Testing"));
	}

}
