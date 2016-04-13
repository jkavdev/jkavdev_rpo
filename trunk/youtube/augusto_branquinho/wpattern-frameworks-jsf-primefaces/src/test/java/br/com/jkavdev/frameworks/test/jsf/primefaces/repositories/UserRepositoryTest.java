package br.com.jkavdev.frameworks.test.jsf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.frameworks.jsf.primefaces.model.UserEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IUserRepository;
import br.com.jkavdev.frameworks.test.jsf.primefaces.AbstractDatabaseTest;

public class UserRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOG = Logger.getLogger(UserRepositoryTest.class);

	@Inject
	private IUserRepository userRepository;

	@Test
	public void testCategoryRepository() {
		List<UserEntity> users = userRepository.findAll();
		LOG.info(users);
	}

}
