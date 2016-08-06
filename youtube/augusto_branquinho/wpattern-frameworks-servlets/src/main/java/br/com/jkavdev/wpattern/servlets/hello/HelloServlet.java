package br.com.jkavdev.wpattern.servlets.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HelloServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("Hello Servlet called");

		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Servlet Title</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Servlets Kicked</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
