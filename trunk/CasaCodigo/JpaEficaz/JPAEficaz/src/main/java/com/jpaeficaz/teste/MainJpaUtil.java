package com.jpaeficaz.teste;

import javax.persistence.EntityManager;

import com.jpaeficaz.util.JpaUtil;

public class MainJpaUtil {

	public static void main(String[] args) {
		
		//trazendo o manager util
		EntityManager manager = JpaUtil.getEntityManager();
		
		System.out.println("Conectou");

	}

}
