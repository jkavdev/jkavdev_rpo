package br.com.jkavdev.caelum.fj21.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class OiMundo extends HttpServlet{
	
	public static void main(String[] args) {
		
//		String l = "";
		String l = null;
		
		System.out.println(StringUtils.isBlank(l));
		
		
		
	}

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Oi Mundo Servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
