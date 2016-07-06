package br.com.jkavdev.log.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog {
	
	private static final Logger logger = Logger.getLogger(TestLog.class);
	
	@Test
	public void testLog(){
		
		logger.info("Testando Log4j");
		
	}
	
	@Test
	public void testErrorLog(){
		
		try {
			throw new Exception("New Exception");
		} catch (Exception e) {
			logger.error(e, e);
		}
		
	}

}
