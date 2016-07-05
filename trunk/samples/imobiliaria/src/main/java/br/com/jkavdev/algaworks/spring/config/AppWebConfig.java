package br.com.jkavdev.algaworks.spring.config;

import java.math.BigDecimal;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import br.com.jkavdev.algaworks.spring.controller.ImoveisController;
import nz.net.ultraq.thymeleaf.LayoutDialect;

//classe de configuracao da aplicacao
//que habilitara o spring web mvc
//fara tambem a configuracao dos controllers da aplicacao

@Configuration
@EnableWebMvc
// informando que todas as classes onde está
// imoveisController sera controllers
@ComponentScan(basePackageClasses = { ImoveisController.class })
public class AppWebConfig extends WebMvcConfigurerAdapter {

	// beans que serão usados no contexto do spring mvc
	@Bean
	public TemplateResolver webTemplateResolver() {
		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		// onde sera salvo minhas paginas
		// e quais serao a extensao das paginas
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		// informando que sera usado o html 5
		// e o tipo de utf-8 como encoding
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCacheable(false);

		return templateResolver;
	}

	// configurando o thymeleaf
	@Bean
	public TemplateEngine templateEngine(TemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new LayoutDialect());

		return templateEngine;
	}

	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setCharacterEncoding("UTF-8");

		return viewResolver;
	}
	// configurando o thymeleaf

	// definindo idioma da aplicacao
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	// habilitando os recursos estaticos css, js images
	// para o servidor de aplicacao
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// formatador de string para Bigdecimal
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
		NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter("#,##0.00");
		conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);

		return conversionService;
	}

	// configuracao de mensagens
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/i18n/messages");
		bundle.setDefaultEncoding("UTF-8"); // http://www.utf8-chartable.de/
		bundle.setCacheSeconds(1);
		return bundle;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource());
		return validatorFactoryBean;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

}
