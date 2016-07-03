package br.com.jkavdev.algaworks.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
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

}
