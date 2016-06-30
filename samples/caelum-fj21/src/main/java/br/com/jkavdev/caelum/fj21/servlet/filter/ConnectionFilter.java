package br.com.jkavdev.caelum.fj21.servlet.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.connection.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter{
	
	private static final Logger logger = Logger.getLogger(ConnectionFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		
		logger.info("Criando conexão com o banco=====================================================");
		request.setAttribute("connection", connection);
		 
		 chain.doFilter(request, response);
		 
		 try {
			 logger.info("Fechando conexão com o banco==================================================");
			connection.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar Conexão: ", e);
			
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		
	}

}
