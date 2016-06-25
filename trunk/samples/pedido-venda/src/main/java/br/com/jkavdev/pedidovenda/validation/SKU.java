package br.com.jkavdev.pedidovenda.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Pattern;
import javax.validation.Payload;;

@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
// recebe uma lista de classes que implementama validacao
// validar no codigo
@Constraint(validatedBy = {})
// indicando padrao
@Pattern(regexp = "([a-zA-Z]{2}\\d{4, 18})?")
public @interface SKU {

	// vou receber esta mensagem via arquivo properties
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "{SKU.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
