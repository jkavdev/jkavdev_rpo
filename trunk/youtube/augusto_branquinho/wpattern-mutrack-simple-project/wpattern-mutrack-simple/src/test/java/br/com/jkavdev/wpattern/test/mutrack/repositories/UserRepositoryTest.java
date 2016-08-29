package br.com.jkavdev.wpattern.test.mutrack.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.user.UserEntity;
import br.com.jkavdev.wpattern.mutrack.user.UserRepository;
import br.com.jkavdev.wpattern.test.mutrack.utils.AbstractTest;

public class UserRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindAll() {
		List<UserEntity> users = this.userRepository.findAll();

		logger.info(users);
	}

	@Test
	public void testFindUserByEmail() {
		UserEntity user = this.userRepository.findByEmail("user@user.com");
		UserEntity admin = this.userRepository.findByEmail("admin@admin.com");

		logger.info("User: " + user);
		logger.info("Admin: " + admin);
	}
	
	@Test
	public void testFindUserByEmailOrName() {
		UserEntity user = this.userRepository.findByEmailOrName("user@user.com", "user");
		UserEntity admin = this.userRepository.findByEmailOrName("admin@admin.com", "admin");

		logger.info("User: " + user);
		logger.info("Admin: " + admin);
	}

}
