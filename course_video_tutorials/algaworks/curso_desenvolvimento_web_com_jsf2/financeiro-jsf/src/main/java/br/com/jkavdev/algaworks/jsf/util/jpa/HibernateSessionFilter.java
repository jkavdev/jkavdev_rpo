package br.com.jkavdev.algaworks.jsf.util.jpa;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames = { "Faces Servlet" })
public class HibernateSessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			request.setAttribute("session", session);

			chain.doFilter(request, response);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
