package br.com.jkavdev.caelum.fj21.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

@WebFilter("/*")
public class FiltroTempoExecucao implements Filter {
	
	private static final Logger logger = Logger.getLogger(FiltroTempoExecucao.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long tempoInicial = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest) request).getParameter("logica");
		
		logger.info("Tempo da requisição de " + uri +
				"?logica=" + parametros + 
				 " demorou (ms): " + (tempoFinal - tempoInicial));
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
