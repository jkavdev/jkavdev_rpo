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

@WebFilter(urlPatterns = { "*.xhtml" })
public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		Session currentSession = this.sf.getCurrentSession();

		Transaction transaction = null;

		try {
			transaction = currentSession.beginTransaction();
			chain.doFilter(req, resp);
			transaction.commit();
			if (currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable e) {
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {}

}
