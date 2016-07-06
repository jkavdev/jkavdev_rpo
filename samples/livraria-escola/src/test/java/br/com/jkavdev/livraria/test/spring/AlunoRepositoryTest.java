package br.com.jkavdev.livraria.test.spring;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Aluno;
import br.com.jkavdev.livraria.repository.IAlunoRepository;
import br.com.jkavdev.livraria.test.AbstractDatabaseTest;

public class AlunoRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger.getLogger(AlunoRepositoryTest.class);

	@Autowired
	private IAlunoRepository alunoRepository;

	@Test
	public void testFindAllAlunos() {
		List<Aluno> alunos = alunoRepository.findAll();

		for (Aluno aluno : alunos) {
			logger.info(aluno);
		}

	}

	@Test
	public void insertAluno() {

		Aluno aluno = alunoRepository.findOne(1L);

		logger.info("Aluno do banco: " + aluno);

	}

}
