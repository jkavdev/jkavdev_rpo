package br.com.jkavdev.caelum.fj21.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.service.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("logica");
		String className = "br.com.jkavdev.caelum.fj21.service." + action;
		
		try{
			Class<?> classe = Class.forName(className);
			
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(req, resp);
			
			req.getRequestDispatcher(pagina).forward(req, resp);
		}catch(Exception e){
			throw new ServletException("A logica do negocio gerou falho", e);
		}
		
	}
}
