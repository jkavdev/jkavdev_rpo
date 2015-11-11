package br.com.calc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcBasicServlet")
public class CalcBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public CalcBasicServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setando o conteudo da tela
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		//pegando os valores do formulario
		String valorA = request.getParameter("valorA");
		String valorB = request.getParameter("valorB");
		String opcao = request.getParameter("opcao");
		
		//passando os valores para um double
		double dValorA = Double.parseDouble(valorA);
		double dValorB = Double.parseDouble(valorB);
		double resultado = 0;
		
		//escolhendo resultado de acordo com a opcao selecionada
		if(opcao.equals("+")){
			resultado = dValorA + dValorB;			
		}else if(opcao.equals("-")){
			resultado = dValorA - dValorB;			
		}else if(opcao.equals("*")){
			resultado = dValorA * dValorB;			
		}else if(opcao.equals("/")){
			resultado = dValorA / dValorB;			
		}
		
		//exibindo resultado
		writer.println("Resultado : <br />" + resultado);
		
		
		
		
	}

}
