package com.algaworks.cursojavaee.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


//configurando um qualificador para indica que certo tipo tenha precedencia
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
//usado em todo tipo
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface Urgente {

}
