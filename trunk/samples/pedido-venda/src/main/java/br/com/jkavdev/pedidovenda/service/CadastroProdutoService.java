package br.com.jkavdev.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.repository.ProdutoRepository;
import br.com.jkavdev.pedidovenda.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;

	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = this.produtoRepository.porSku(produto.getSku());

		if (produtoExistente != null) {
			throw new NegocioException("Já existe um produto com o SKU informado!");
		}

		return produtoRepository.salvar(produto);
	}

}
