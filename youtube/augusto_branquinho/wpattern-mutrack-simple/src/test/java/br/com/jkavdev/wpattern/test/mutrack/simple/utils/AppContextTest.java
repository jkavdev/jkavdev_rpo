package br.com.jkavdev.wpattern.test.mutrack.simple.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.jkavdev.wpattern.mutrack.simple.utils.AppContext;

@Configuration
@Import(value = { AppContext.class })
@ComponentScan(basePackages = { "org.wpattern.test.mutrack.simple" })
public abstract class AppContextTest {

}
