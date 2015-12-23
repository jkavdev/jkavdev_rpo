package com.algaworks.curso.jpa2.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//toda vez que a tractional for chamada
//esta classe ira inteceptar primeiro
//para veirificacao
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;
	
	//aqui fala que antes de executar o metodo que contem a transactional
	//este metodo sera executado antes
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		//pegando a transacao
		EntityTransaction transaction = manager.getTransaction();
		boolean owner = false;

		try {
			if (!transaction.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit, confirmaria até mesmo operações sem transação)
				transaction.begin();
				transaction.rollback();
				
				// agora sim inicia a transação
				transaction.begin();
				
				owner = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && owner) {
				transaction.rollback();
			}

			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && owner) {
				transaction.commit();
			}
		}
	}
	
}