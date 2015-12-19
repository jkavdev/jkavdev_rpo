package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	private FabricanteDAO fabricanteDAO;

	public FabricanteConverter() {
		this.fabricanteDAO = CDIServiceLocator.getBean(FabricanteDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;
		if (value != null) {
			//fara busca no banco pelo codigo informado
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		//sera retornado o valor do id do banco
		//e transformado para string para por exemplo um combobox ser exibido
		
		//quando for gravado o registro sera chamado getAsObject
		//mas quando ele busca no banco ele compara se o objeto da tela e o mesmo
		// do banco de dados
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}

}
