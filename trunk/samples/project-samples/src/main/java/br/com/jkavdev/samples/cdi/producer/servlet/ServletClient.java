package br.com.jkavdev.samples.cdi.producer.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.samples.cdi.producer.dao.SimpleDao;

@WebServlet(urlPatterns = "/client")
public class ServletClient extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private SimpleDao simpleDao;

	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		simpleDao.doSomething();
	}

}
