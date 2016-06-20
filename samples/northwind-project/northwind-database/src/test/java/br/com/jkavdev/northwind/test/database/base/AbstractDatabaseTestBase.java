package br.com.jkavdev.northwind.test.database.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//base de todas os testes unitarios
//carrega tambem o context de configuracao de test

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ctx-northwind-test-database.xml" })
public abstract class AbstractDatabaseTestBase {

}