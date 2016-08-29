package br.com.jkavdev.wpattern.mutrack.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.wpattern.mutrack.AppMain;

//Classe de configuracao do Spring

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = AppMain.class)
public class AppContext {

}
