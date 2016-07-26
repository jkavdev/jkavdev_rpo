package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Autor;
import br.com.jkavdev.k19.jpa_hibernate.model.Livro;

public class ManyToMnayTest extends AbstractJUnitConfig {

	@Test
	public void insertLivros() {

		Autor jhonatan = new Autor();
		jhonatan.setNome("Jhonatan");

		Autor ian = new Autor();
		ian.setNome("Ian");

		Livro conto = new Livro();
		conto.setTitulo("Conto de Bruxelas");

		Livro mauto = new Livro();
		mauto.setTitulo("Mauto de Conte");

		Livro snague = new Livro();
		snague.setTitulo("Snague Horrendo");

		Collection<Livro> livrosIan = new LinkedList<>();
		livrosIan.add(snague);
		livrosIan.add(mauto);

		Collection<Livro> livrosJhonatan = new LinkedList<>();
		livrosJhonatan.add(snague);
		livrosJhonatan.add(mauto);
		livrosJhonatan.add(conto);

		ian.setLivros(livrosIan);
		jhonatan.setLivros(livrosJhonatan);

		beginTransaction();

		this.getManager().persist(conto);
		this.getManager().persist(snague);
		this.getManager().persist(mauto);
		this.getManager().persist(ian);
		this.getManager().persist(jhonatan);

		commit();

	}

}
