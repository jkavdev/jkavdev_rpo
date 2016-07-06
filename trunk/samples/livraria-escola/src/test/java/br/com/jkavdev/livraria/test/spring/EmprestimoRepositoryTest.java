package br.com.jkavdev.livraria.test.spring;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Emprestimo;
import br.com.jkavdev.livraria.repository.IEmprestimoRepository;
import br.com.jkavdev.livraria.test.AbstractDatabaseTest;

public class EmprestimoRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger.getLogger(EmprestimoRepositoryTest.class);

	@Autowired
	private IEmprestimoRepository emprestimoRepository;
	
	@Test
	public void selectAllEmprestimos(){
		
		List<Emprestimo> emprestimos = emprestimoRepository.findAll();
		
		for (Emprestimo emprestimo : emprestimos) {
			logger.info(emprestimo);
		}
		
	}

}
