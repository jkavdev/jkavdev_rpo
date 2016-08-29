package br.com.jkavdev.wpattern.test.mutrack.utils;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Classe base para os tests

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppContextTest.class })
public abstract class AbstractTest {

}
