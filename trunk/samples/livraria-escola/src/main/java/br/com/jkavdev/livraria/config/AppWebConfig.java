package br.com.jkavdev.livraria.config;

import java.math.BigDecimal;
import java.util.Locale;

import nz.net.ultraq.thymeleaf.LayoutDialect;

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

import br.com.jkavdev.livraria.controller.LivroController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { LivroController.class })
public class AppWebConfig extends WebMvcConfigurerAdapter {
	
	private static final String TEMPLATE_RESOLVER_PREFIX = "/WEB-INF/views";
    private static final String TEMPLATE_RESOLVER_SUFFIX = ".html";
    private static final String TEMPLATE_RESOLVER_TEMPLATE_MODE = "HTML5";
    private static final String TEMPLATE_RESOLVER_CHARACTER_ENCODING = "UTF-8";

	@Bean
	public TemplateResolver webTemplateResolver() {
		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix(TEMPLATE_RESOLVER_PREFIX);
		templateResolver.setSuffix(TEMPLATE_RESOLVER_SUFFIX);
		templateResolver.setTemplateMode(TEMPLATE_RESOLVER_TEMPLATE_MODE);
		templateResolver.setCharacterEncoding(TEMPLATE_RESOLVER_CHARACTER_ENCODING);
		templateResolver.setCacheable(false);
		
		return templateResolver;
	}

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
		viewResolver.setCharacterEncoding(TEMPLATE_RESOLVER_CHARACTER_ENCODING);
		
		return viewResolver;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService( true);
		NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter( "#,##0.00");
		conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);

		return conversionService;
	}

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
