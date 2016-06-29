package br.com.jkavdev.caelum.fj21.service.contato;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.service.Logica;

public class FindAllContacts implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		List<Contato> contatos = new ContatoDao().getFindAll();

		request.setAttribute("contatos", contatos);

		return "WEB-INF/jsp/contato/lista-contatos.jsp";
	}

}
