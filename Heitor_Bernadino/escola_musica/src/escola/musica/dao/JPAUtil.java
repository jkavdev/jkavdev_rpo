package escola.musica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManager geEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola_musica_pu");
		return factory.createEntityManager();
	}

}
