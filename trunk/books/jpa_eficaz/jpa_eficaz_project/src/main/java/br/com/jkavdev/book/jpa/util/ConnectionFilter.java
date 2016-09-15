package br.com.jkavdev.book.jpa.util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConnectionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// retornando entityManager e transaction da requisicao
		EntityManager entityManager = JpaUtil.geEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			// inicia transacao
			transaction.begin();

			// passa para a aplicacao
			chain.doFilter(request, response);

			// commit depois do termino da requisicao da aplicacao
			transaction.commit();

			// realiza rollback caso ocorra algum erro
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				transaction.rollback();
			}
		} finally {
			JpaUtil.close();
		}

	}

	@Override
	public void destroy() {

	}

}
