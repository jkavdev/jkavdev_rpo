package br.com.jkavdev.fj21.servlet.exemplo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//com servlets 3.0 podemos usar anotacoes no lugar do web.xml

//indica como a servlet sera acessada
@WebServlet("/oiMundo")
public class OiServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Oi Mundo com Annotations");
		writer.println("</body>");
		writer.println("</html>");
	}

}
