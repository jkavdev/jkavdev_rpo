package br.com.jkavdev.caelum.fj21.database;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.caelum.fj21.database.connection.DaoException;
import br.com.jkavdev.caelum.fj21.database.dao.FuncionarioDao;
import br.com.jkavdev.caelum.fj21.model.Funcionario;

public class FuncionarioDaoTest {

	private FuncionarioDao FuncionarioDao;

	@Before
	public void init() throws DaoException {
		FuncionarioDao = new FuncionarioDao();
	}

	@Test
	public void insertFuncionario() throws DaoException {

		Funcionario jkavdev = createFuncionario(1L, "Jhonatan Kolen", "jkavdev", "123456");
		Funcionario antonio = createFuncionario(1L, "Antonio Junio", "anton", "123456");
		Funcionario ricardo = createFuncionario(1L, "Ricardo Gomes", "ricc", "123456");

		FuncionarioDao.insert(jkavdev);
		FuncionarioDao.insert(antonio);
		FuncionarioDao.insert(ricardo);

		System.out.println("Funcionario: " + jkavdev.getNome() + " salvo com sucesso");
		System.out.println("Funcionario: " + jkavdev.getNome() + " salvo com sucesso");
		System.out.println("Funcionario: " + jkavdev.getNome() + " salvo com sucesso");
	}

	@Test
	public void findlAllFuncionarios() throws DaoException {
		List<Funcionario> Funcionarios = FuncionarioDao.findAll();

		for (Funcionario Funcionario : Funcionarios) {
			System.out.println(Funcionario);
		}
	}
	
	@Test
	public void findlAllFuncionariosByName() throws DaoException {
		String nome = "Jhonatan";
		
		List<Funcionario> Funcionarios = FuncionarioDao.findAllFuncionariosByName(nome);

		for (Funcionario Funcionario : Funcionarios) {
			System.out.println(Funcionario);
		}
	}
	
	@Test
	public void findFuncionario(){
		Long id = 1L;
		Funcionario Funcionario = FuncionarioDao.find(id);
		
		Long id1 = 3L;
		Funcionario Funcionario1 = FuncionarioDao.find(id1);
		
		System.out.println("Funcionario buscado: " + Funcionario);
		System.out.println("Funcionario buscado: " + Funcionario1);
	}
	
	@Test
	public void updateFuncionario(){
		List<Funcionario> Funcionarios = FuncionarioDao.findAll();
		
		for (Funcionario Funcionario : Funcionarios) {
			if(Funcionario.getId() == 3){
				Funcionario.setNome("Lucas Alves");
				FuncionarioDao.update(Funcionario);
				
				System.out.println(Funcionario.getNome());
			}else if(Funcionario.getId() == 2){
				Funcionario.setNome("Douglas Alves");
				FuncionarioDao.update(Funcionario);
				
				System.out.println(Funcionario.getNome());
			}
		}
	}
	
	@Test
	public void removeFuncionario(){
		List<Funcionario> Funcionarios = FuncionarioDao.findAll();
		
		for (Funcionario Funcionario : Funcionarios) {
			if(Funcionario.getId() == 1){
				FuncionarioDao.remove(Funcionario);
				
				System.out.println(Funcionario.getNome());
			}
		}
	}

	private Funcionario createFuncionario(Long id, String nome, String usuario, String senha) {
		Funcionario Funcionario = new Funcionario(id, nome, usuario, senha);
		
		return Funcionario;
	}

}
