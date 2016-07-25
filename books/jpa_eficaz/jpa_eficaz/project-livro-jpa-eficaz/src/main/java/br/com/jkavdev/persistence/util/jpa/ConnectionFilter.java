package br.com.jkavdev.persistence.util.jpa;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//qualquer requisicao passara por este filtro

@WebFilter("*.xhtml")
public class ConnectionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		EntityManager entityManager = JpaUtil.geEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			// abrira a transacao
			transaction.begin();

			// passa para a aplicacao
			chain.doFilter(request, response);

			// comita a aplicacao
			transaction.commit();
		} catch (Exception e) {
			// desfaz transacao caso algum erro
			if (entityManager.isOpen()) {
				transaction.rollback();
			}
		} finally {
			// fecha o entityManager
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
