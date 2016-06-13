package br.com.gospro.test.dao;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.gospro.dao.IEnderecoDao;
import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.dao.hibernate.HibernateEnderecoDao;
import br.com.gospro.dao.hibernate.HibernateFuncionarioDao;
import br.com.gospro.model.Contato;
import br.com.gospro.model.Endereco;
import br.com.gospro.model.Funcionario;

public class TestEnderecoDao {

//	IFuncionarioDao funcionarioDao = new HibernateFuncionarioDao();
//	IEnderecoDao enderecoDao = new HibernateEnderecoDao();
//
//	@Test
//	public void insertEndereco() {
//		Endereco endereco = createEndereco("itapua 1", "73754012", "casa", "15");
//		Endereco endereco1 = createEndereco("itapua 1", "73754052", "empresa",
//				"14");
//		Endereco endereco2 = createEndereco("itapua 2", "73754212", "casa",
//				"21");
//		Endereco endereco3 = createEndereco("itapua 1", "73744442", "casa",
//				"25");
//		Endereco endereco4 = createEndereco("itapua 2", "73753552", "casa",
//				"17");
//
//		enderecoDao.salvar(endereco);
//		enderecoDao.salvar(endereco1);
//		enderecoDao.salvar(endereco2);
//		enderecoDao.salvar(endereco3);
//		enderecoDao.salvar(endereco4);
//
//		System.out.println("Enderecos salvos!");
//
//	}
//
//	@Test
//	public void selectAllContacts() {
//		List<Endereco> enderecos = enderecoDao.buscarTodos();
//
//		for (Endereco endereco : enderecos) {
//			System.out
//					.println(endereco.getCodigo() + " - " + endereco.getCep());
//		}
//	}
//
//	@Test
//	public void removeContact() {
//		Endereco enderecoARemover = enderecoDao.buscarPorId(5L);
//
//		if (enderecoARemover != null) {
//			enderecoDao.remover(enderecoARemover);
//
//			System.out.println(enderecoARemover.getCodigo() + " - "
//					+ enderecoARemover.getCep());
//		}
//	}
//
//	@Test
//	public void insertEnderecoWithPerson() {
//		Funcionario jhonatan = createFuncionario(Calendar.getInstance(),
//				"Jhonatan", "Kolen", Calendar.getInstance(), "M",
//				"04488289100", "3168437", "Administrador");
//		Endereco ceilandiaSula = createEndereco("ceilandia sul", "55422",
//				"casa", "21");
//
//		jhonatan.setEndereco(ceilandiaSula);
//
//		funcionarioDao.salvar(jhonatan);
//	}
//
//	@Test
//	public void mergeEnderecoAndPerson() {
//		Funcionario funcionario = funcionarioDao.buscarPorId(3L);
//		Endereco endereco = enderecoDao.buscarPorId(7L);
//
//		funcionario.setEndereco(endereco);
//		funcionarioDao.alterar(funcionario);
//	}
//
//	public Endereco createEndereco(String bairro, String cep,
//			String complemento, String numero) {
//		Endereco endereco = new Endereco();
//		endereco.setBairro(bairro);
//		endereco.setCep(cep);
//		endereco.setComplemento(complemento);
//		endereco.setNumero(numero);
//		return endereco;
//	}
//
//	public Funcionario createFuncionario(Calendar dataCadastro, String nome,
//			String sobrenome, Calendar DataNascimento, String sexo, String cpf,
//			String rg, String cargo) {
//		Funcionario funcionario = new Funcionario(dataCadastro, nome,
//				sobrenome, DataNascimento, sexo, cpf, rg, cargo);
//		return funcionario;
//	}

}
