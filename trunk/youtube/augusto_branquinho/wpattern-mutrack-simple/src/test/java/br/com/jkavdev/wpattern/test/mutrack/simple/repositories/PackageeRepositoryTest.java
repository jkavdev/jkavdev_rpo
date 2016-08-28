package br.com.jkavdev.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.simple.packagee.PackageeEntity;
import br.com.jkavdev.wpattern.mutrack.simple.packagee.PackageeRepository;
import br.com.jkavdev.wpattern.test.mutrack.simple.utils.AbstractTest;

public class PackageeRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private PackageeRepository packageeRepository;

	@Test
	public void findAllTest() {
		List<PackageeEntity> packagees = this.packageeRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + packagees);
		}
	}

}
