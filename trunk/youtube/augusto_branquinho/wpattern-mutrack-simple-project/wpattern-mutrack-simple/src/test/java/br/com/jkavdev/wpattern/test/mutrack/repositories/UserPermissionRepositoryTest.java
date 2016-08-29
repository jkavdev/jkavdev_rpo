package br.com.jkavdev.wpattern.test.mutrack.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.userpermission.UserPermissionEntity;
import br.com.jkavdev.wpattern.mutrack.userpermission.UserPermissionRepository;
import br.com.jkavdev.wpattern.test.mutrack.utils.AbstractTest;

public class UserPermissionRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(UserPermissionRepositoryTest.class);

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	@Test
	public void testFindAll() {
		List<UserPermissionEntity> packages = this.userPermissionRepository.findAll();

		logger.info(packages);
	}

}
