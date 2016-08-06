package br.com.jkavdev.wpattern.servlets.multiple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MultipleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MultipleServlet.class);

	public double parseToDouble(String value) {
		if ((value == null) || value.trim().isEmpty()) {
			return 0.0;
		}

		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);

			return 0.0;
		}
	}

	public double multiple(MultipleBean multipleBean) {
		logger.info("MultipleBean: " + multipleBean);

		return multipleBean.getValue1() * multipleBean.getValue2();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Multiple Servlet called");

		MultipleBean multipleBean = new MultipleBean(
				this.parseToDouble(req.getParameter("value1")),
				this.parseToDouble(req.getParameter("value2")));
		
		double result = this.multiple(multipleBean);
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Servlet Title</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>" + multipleBean.getValue1() + " * " + multipleBean.getValue2() + " = " + result + "</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
