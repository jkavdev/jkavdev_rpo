package br.com.jkavdev.pedidovenda.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(TransactionalInterceptor.class);

	@Inject
	private EntityManager manager;

	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = this.manager.getTransaction();
		boolean criador = false;

		try {
			log.info("iniciando transação");
			if (!transaction.isActive()) {
				transaction.begin();
				transaction.rollback();

				log.info("iniciando transação");
				transaction.begin();
				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && criador) {
				transaction.rollback();
			}

			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && criador) {
				transaction.commit();
				
				log.info("commitando transacao");
			}
		}
	}

}
