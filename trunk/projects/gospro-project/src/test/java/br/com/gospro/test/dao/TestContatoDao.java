package br.com.gospro.test.dao;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.gospro.dao.IContatoDao;
import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.dao.hibernate.HibernateContatoDao;
import br.com.gospro.dao.hibernate.HibernateFuncionarioDao;
import br.com.gospro.model.Contato;
import br.com.gospro.model.Funcionario;

public class TestContatoDao {

	IFuncionarioDao funcionarioDao = new HibernateFuncionarioDao();
	IContatoDao contatoDao = new HibernateContatoDao();

	@Test
	public void insertContato() {
		Contato contato = createContato("jhonatan@gmail.com", "99220468",
				"36376648");
		Contato contato1 = createContato("jhonatankolen@gmail.com", "9879754",
				"321321654");
		Contato contato2 = createContato("jhonatan.viana@foton.com", "2131548",
				"213214");
		Contato contato3 = createContato("lucas@gmail.com", "1112132135",
				"545487");
		Contato contato4 = createContato("lucas.viana@gmail.com", "32546546",
				"122231");

		contatoDao.salvar(contato);
		contatoDao.salvar(contato1);
		contatoDao.salvar(contato2);
		contatoDao.salvar(contato3);
		contatoDao.salvar(contato4);

		System.out.println("Contatos salvos!");

	}

	@Test
	public void selectAllContacts() {
		List<Contato> contatos = contatoDao.buscarTodos();

		for (Contato contato : contatos) {
			System.out
					.println(contato.getCodigo() + " - " + contato.getEmail());
		}
	}

	@Test
	public void removeContact() {
		Contato contatoARemover = contatoDao.buscarPorId(2L);

		if (contatoARemover != null) {
			System.out.println(contatoARemover.getEmail());

			contatoDao.remover(contatoARemover);

			System.out.println(contatoARemover.getCodigo() + " - "
					+ contatoARemover.getEmail());
		}
	}

	@Test
	public void insertContatoWithPerson() {
		Funcionario jhonatan = createFuncionario(Calendar.getInstance(), "Jhonatan", "Kolen", Calendar.getInstance(), "M", "04488289100", "3168437", "Administrador");
		Contato contato = createContato("jhonatan@gmail.com", "99220468", "36376648");

		jhonatan.getContatos().add(contato);
		contato.setPessoa(jhonatan);
		
		funcionarioDao.salvar(jhonatan);
	}
	
	@Test
	public void insertContactAndPerson(){
		Funcionario jhonatan = createFuncionario(Calendar.getInstance(), "Lucas", "Alves", Calendar.getInstance(), "M", "04488289100", "3168437", "Administrador");
		Contato contato = createContato("luycas@gmail.com", "99220468", "36376648");
		
		funcionarioDao.salvar(jhonatan);
		contatoDao.salvar(contato);
	}
	
	@Test
	public void mergeContactAndPerson(){
		Funcionario funcionario = funcionarioDao.buscarPorId(3L);
		Contato contato = contatoDao.buscarPorId(4L);
		
		contato.setPessoa(funcionario);
		funcionario.getContatos().add(contato);
		
		funcionarioDao.alterar(funcionario);
	}

	public Contato createContato(String email, String telefone, String celular) {
		Contato contato = new Contato(email, telefone, celular);
		return contato;
	}

	public Funcionario createFuncionario(Calendar dataCadastro, String nome,
			String sobrenome, Calendar DataNascimento, String sexo, String cpf,
			String rg, String cargo) {
		Funcionario funcionario = new Funcionario(dataCadastro, nome,
				sobrenome, DataNascimento, sexo, cpf, rg, cargo);
		return funcionario;
	}

}
