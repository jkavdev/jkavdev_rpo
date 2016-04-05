package br.com.jkavdev.fj21.servlet.exemplo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//variavel de instancia
	private int contador = 0;
	
	@Override
	public void init() throws ServletException {
		super.init();
		contador = 5;
		System.out.println("Inicializando servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//a cada requisicao mesma variavel e incrementada
		contador++;
		
		PrintWriter writer = resp.getWriter();
		
		//escreve o texto
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Contador: " + contador);
		writer.println("</body>");
		writer.println("</html>");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Inicializando servlet");
	}

}
