package br.com.jkavdev.algaworks.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.spring.model.Vinho;
import br.com.jkavdev.algaworks.spring.repository.Vinhos;

@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhos;

	public void salvar(Vinho vinho) {
		this.vinhos.save(vinho);
	}

}
