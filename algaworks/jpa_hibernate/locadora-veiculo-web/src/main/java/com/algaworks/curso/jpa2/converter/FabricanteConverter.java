package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.mapping.Value;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

//conversor para a classe fabricante
@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	private FabricanteDAO fabricanteDAO;

	public FabricanteConverter() {
		this.fabricanteDAO = CDIServiceLocator.getBean(FabricanteDAO.class);
	}

	//o id do fabricante vira como value, uma string
	@Override
	public Object getAsObject(FacesContext context, UIComponent componente, String value) {
		Fabricante retorno = null;
		
		//busco no banco o fabricante com o id value
		if(value != null){
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componente, Object value) {
		if(value != null){
			Long codigo = ((Fabricante)value).getCodigo();
			String retorno = ((codigo == null ? null : codigo.toString()));
		}
		return "";
	}

}
