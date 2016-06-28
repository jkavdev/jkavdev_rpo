package br.com.jkavdev.caelum.fj21.database;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.caelum.fj21.database.connection.DaoException;
import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.util.data.DataUtil;

public class ContatoDaoTest {

	private ContatoDao contatoDao;

	@Before
	public void init() throws DaoException {
		contatoDao = new ContatoDao();
	}

	@Test
	public void insertContato() throws DaoException {

		Contato contato = createContato(1L, "Jhonatan Kolen", "jhonatan@gmail.com", "qr 12 casa 15");

		contatoDao.insert(contato);

		System.out.println("Contato: " + contato.getNome() + " salvo com sucesso");
	}

	@Test
	public void findlAllContatos() throws DaoException {
		List<Contato> contatos = contatoDao.findAll();

		for (Contato contato : contatos) {
			System.out.println(contato);
			System.out.println(contato.getNome() + " - " + DataUtil.formataData(contato.getDataNascimento()) + " - " + contato.getDataNascimento().getTime());
		}
	}
	
	@Test
	public void findlAllContatosByName() throws DaoException {
		String nome = "Jhonatan";
		
		List<Contato> contatos = contatoDao.findAllContatosByName(nome);

		for (Contato contato : contatos) {
			System.out.println("Nada");
			System.out.println(contato);
			System.out.println(contato.getNome() + " - " + DataUtil.formataData(contato.getDataNascimento()) + " - " + contato.getDataNascimento().getTime());
		}
	}
	
	@Test
	public void findContato(){
		Long id = 1L;
		Contato contato = contatoDao.find(id);
		
		Long id1 = 3L;
		Contato contato1 = contatoDao.find(id1);
		
		System.out.println("Contato buscado: " + contato);
		System.out.println("Contato buscado: " + contato1);
	}

	private Contato createContato(Long id, String nome, String email,
			String endereco) {
		Contato contato = new Contato(id, nome, email, endereco,
				Calendar.getInstance());
		return contato;
	}

}
