package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriaRepository;
import com.algaworks.pedidovenda.repository.ProdutoRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	private ProdutoRepository produtoRepository;

	public ProdutoConverter() {
		// retorna uma instancia de categoryRepository
		this.produtoRepository = CDIServiceLocator.getBean(ProdutoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = produtoRepository.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = ((Produto) value);
			return produto.getId() == null ? null : produto.getId().toString();
		}
		return "";
	}

}
