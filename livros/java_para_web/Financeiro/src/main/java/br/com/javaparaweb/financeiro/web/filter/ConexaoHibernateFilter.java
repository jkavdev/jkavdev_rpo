package br.com.javaparaweb.financeiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.javaparaweb.financeiro.util.HibernateUtil;

//indicando qual tipo de requisicao este filter ira interceptar
@WebFilter("*.xhtml")
public class ConexaoHibernateFilter implements Filter {
	private SessionFactory factory;

	// executado ao subir a aplicacao
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// carrega conexao do hibernate
		this.factory = HibernateUtil.getSessionFactory();
	}

	// intercepta as requisicoes
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// retorna a sessao atual
		Session currentSession = this.factory.getCurrentSession();
		Transaction transaction = null;

		try {
			// inicia transacao
			transaction = currentSession.beginTransaction();
			// passa execucao para a aplicacao
			chain.doFilter(request, response);
			// commit requisicao
			transaction.commit();

			// fecha sessao
			if (currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable e) {
			try {
				// realiza rollback em caso de erro
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable t) {
				e.printStackTrace();
			}

			throw new ServletException(e);
		}
	}

	public void destroy() {
	}
}
