package br.com.jkavdev.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.jkavdev.mysql.world.entities.CountryLanguage;
import br.com.jkavdev.mysql.world.entities.IsOfficial;
import br.com.jkavdev.mysql.world.entities.LanguagePK;

public class InsereLanguage {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("worldPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		CountryLanguage language = new CountryLanguage();
		language.setOfficial(IsOfficial.TRUE);
		language.setPercentage(100f);
		
		LanguagePK languagePK = new LanguagePK("555", "Portugues");
		
		language.setId(languagePK);

		manager.persist(language);

		transaction.commit();
		manager.close();
		factory.close();

	}

}
