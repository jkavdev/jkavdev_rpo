package br.com.jkavdev.samples.cdi.producer.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.jkavdev.samples.cdi.producer.dao.FileSimpleDao;
import br.com.jkavdev.samples.cdi.producer.dao.SimpleDao;

//@ApplicationScoped
public class SimpleDaoProducer {

	private final Logger log = LoggerFactory.getLogger(getClass());

	// informando um produtor para o tipo SimpleDao
	// informando que sera criado apenas uma instancia durante a aplicacao
	// mesmo se solicitado por outra requisicao
	@Produces
	@ApplicationScoped
	public SimpleDao createFileDao() {
		log.info("-- > creating FileDao");

		return new FileSimpleDao("/anyDirectory");
	}

}

