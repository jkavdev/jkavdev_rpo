package br.com.jkavdev.wpattern.test.mutrack.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.packagee.PackageeEntity;
import br.com.jkavdev.wpattern.mutrack.packagee.PackageeRepository;
import br.com.jkavdev.wpattern.test.mutrack.utils.AbstractTest;

public class PackageeRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(PackageeRepositoryTest.class);

	@Autowired
	private PackageeRepository packageeRepository;

	@Test
	public void testFindAll() {
		List<PackageeEntity> packages = this.packageeRepository.findAll();

		logger.info(packages);
	}

}
