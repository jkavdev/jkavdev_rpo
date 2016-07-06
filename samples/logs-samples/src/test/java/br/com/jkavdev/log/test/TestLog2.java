package br.com.jkavdev.log.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog2 {

	private static final Logger logger = Logger.getLogger(TestLog.class);

	@Test
	public void testLog() {

		logger.trace("Testando TRACE Log4j");
		logger.debug("Testando DEBUG Log4j");
		logger.info("Testando INFO Log4j");
		logger.warn("Testando WARN Log4j");
		logger.error("Testando ERROR Log4j");
		logger.fatal("Testando FATAL Log4j");

	}

}
