package br.com.gospro.test;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.gospro.dao.IContatoDao;
import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.dao.jpa.HibernateContatoDao;
import br.com.gospro.dao.jpa.HibernateFuncionarioDao;
import br.com.gospro.model.Contato;
import br.com.gospro.model.Funcionario;

public class GenericFuncionarioDao {

//	IFuncionarioDao funcionarioDao = new HibernateFuncionarioDao();
//	IContatoDao contatoDao = new HibernateContatoDao();
//
//	@Test
//	public void insertFuncionario() {
//
//		Funcionario jhonatan = createFuncionario(Calendar.getInstance(), "Jhonatan", "Kolen", Calendar.getInstance(),
//				"M", "04488289100", "3168437", "Administrador");
//		Funcionario maria = createFuncionario(Calendar.getInstance(), "Maria", "Helena", Calendar.getInstance(), "F",
//				"04488289100", "3168437", "Requisitos");
//		Funcionario lucas = createFuncionario(Calendar.getInstance(), "Lucas", "Alves", Calendar.getInstance(), "M",
//				"04488289100", "3168437", "Implementador");
//		Funcionario douglas = createFuncionario(Calendar.getInstance(), "Douglas", "Viana", Calendar.getInstance(), "M",
//				"04488289100", "3168437", "Documentador");
//
//		funcionarioDao.salvar(douglas);
//		funcionarioDao.salvar(jhonatan);
//		funcionarioDao.salvar(lucas);
//		funcionarioDao.salvar(maria);
//
//	}
//
//	@Test
//	public void selectFuncionario() {
//		List<Funcionario> funcionarios = funcionarioDao.buscarTodos();
//
//		for (Funcionario funcionario : funcionarios) {
//			System.out.println("Funcionario: " + funcionario.getNome());
//		}
//
//		Long id = 1L;
//
//		Funcionario funcionario = funcionarioDao.buscarPorId(id);
//		System.out.println("Funcionario retornado: " + funcionario.getNome());
//	}
//
//	@Test
//	public void insertContatoIntoFuncionario() {
//		List<Contato> contatos = contatoDao.buscarTodos();
//
//		for (Contato contato : contatos) {
//			System.out.println("Contato: " + contato.getTelefone());
//		}
//	}
//
//	private Funcionario createFuncionario(Calendar dataCadastro, String nome, String sobrenome, Calendar DataNascimento,
//			String sexo, String cpf, String rg, String cargo) {
//		Funcionario funcionario = new Funcionario(dataCadastro, nome, sobrenome, DataNascimento, sexo, cpf, rg, cargo);
//		return funcionario;
//	}

}
