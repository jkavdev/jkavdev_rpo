package br.com.jkavdev.wpattern.servlets.test.multiple;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import br.com.jkavdev.wpattern.servlets.multiple.MultipleBean;
import br.com.jkavdev.wpattern.servlets.multiple.MultipleServlet;

public class MultipleServletTest {

	private static final Logger logger = Logger.getLogger(MultipleServletTest.class);

	@Test
	public void testMultiple() {
		MultipleServlet multipleServlet = new MultipleServlet();
		MultipleBean multipleBean = new MultipleBean(10, 20);

		double result = multipleServlet.multiple(multipleBean);

		logger.info("Value: " + result);

		if (result != 200.0) {
			Assert.fail("Wrong value");
		}
	}

}
