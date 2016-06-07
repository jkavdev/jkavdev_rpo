package br.com.gospro.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import br.com.gospro.dao.IContatoDao;
import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.dao.hibernate.HibernateContatoDao;
import br.com.gospro.dao.hibernate.HibernateFuncionarioDao;
import br.com.gospro.model.Contato;
import br.com.gospro.model.Funcionario;
import br.com.gospro.util.jpa.JpaUtil;

public class ContatoTestDao {

	private static EntityManager manager;
	private EntityTransaction transaction;
	IFuncionarioDao funcionarioDao = new HibernateFuncionarioDao();
	IContatoDao contatoDao = new HibernateContatoDao();

	@Test
	public void insertContato() {
		Contato contato = createContato("jhonatan@gmail.com", "99220468", "36376648");
		Contato contato1 = createContato("jhonatankolen@gmail.com", "9879754", "321321654");
		Contato contato2 = createContato("jhonatan.viana@foton.com", "2131548", "213214");
		Contato contato3 = createContato("lucas@gmail.com", "1112132135", "545487");
		Contato contato4 = createContato("lucas.viana@gmail.com", "32546546", "122231");
		
		contatoDao.salvar((contato));
		contatoDao.salvar((contato1));
		contatoDao.salvar((contato2));
		contatoDao.salvar((contato3));
		contatoDao.salvar((contato4));

		List<Funcionario> funcionarios = funcionarioDao.buscarTodos();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome() + " - " + funcionario.getCodigo());

			if (funcionario.getCodigo() == 1L) {
				System.out.println("Nice");
				funcionario.getContatos().add(contato);
				contato.setPessoa(funcionario);
				funcionario.getContatos().add(contato1);
				contato1.setPessoa(funcionario);
				funcionario.getContatos().add(contato2);
				contato2.setPessoa(funcionario);
				
				funcionarioDao.salvar(funcionario);

			} else if (funcionario.getCodigo() == 4L) {
				System.out.println("Nice4");
				funcionario.getContatos().add(contato3);
				contato3.setPessoa(funcionario);
				funcionario.getContatos().add(contato4);
				contato4.setPessoa(funcionario);
				
				funcionarioDao.salvar(funcionario);
			}
		}
		
		JpaUtil.close();

	}

	@Test
	public void selectContatos() {
		List<Funcionario> funcionarios = manager
				.createQuery("select f from Funcionario f join f.contatos", Funcionario.class).getResultList();

		for (Funcionario funcionario : funcionarios) {
			List<Contato> contatos = funcionario.getContatos();
			for (Contato contato : contatos) {
				System.out.println(contato.getEmail());
			}
		}
	}

	public Contato createContato(String email, String telefone, String celular) {
		Contato contato = new Contato(email, telefone, celular);
		return contato;
	}

}
