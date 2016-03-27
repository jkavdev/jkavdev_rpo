package com.algaworks.pedidovenda.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//intercepta metodos transacionais

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		boolean criador = false;

		try {
			if (!transaction.isActive()) {
				// truque para fazer roolback no que ja passou
				// (senao, um futuro commit, confirmaria ate mesmo operacoes sem
				// transacao)
				transaction.begin();
				transaction.rollback();

				//agora sim inicia a transacao
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
			}
		}
	}

}
