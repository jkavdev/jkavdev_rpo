package br.com.jkavdev.wpattern.test.mutrack.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.jkavdev.wpattern.mutrack.utils.AppContext;

//Configuracao do context dos test
//fara tambem um import do context principal da aplicacao

@Configuration
@Import(value = { AppContext.class })
@ComponentScan(basePackageClasses = AppContextTest.class)
public abstract class AppContextTest {

}
