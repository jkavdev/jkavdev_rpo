package br.com.jkavdev.caelum.fj21.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;

public class FindAllContacts implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		List<Contato> contatos = new ContatoDao().getFindAll();

		request.setAttribute("contatos", contatos);

		return "/contato/lista-contatos.jsp";
	}

}
