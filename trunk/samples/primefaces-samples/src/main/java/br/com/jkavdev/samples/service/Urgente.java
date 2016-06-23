package br.com.jkavdev.samples.service;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

//indicando que e um quilificador
@Qualifier
// para classes, metodos, parametros e atributos
@Target({ TYPE, METHOD, PARAMETER, FIELD })
// em tempo de execucao
@Retention(RUNTIME)
@Documented
public @interface Urgente {

}
