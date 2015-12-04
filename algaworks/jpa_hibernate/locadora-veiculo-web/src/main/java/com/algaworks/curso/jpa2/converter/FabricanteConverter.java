package com.algaworks.curso.jpa2.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

//conversor do fabricante

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	private static final long serialVersionUID = 1L;

	// para buscar do banco o fabricante a ser editado
	private FabricanteDAO fabricanteDAO;

	public FabricanteConverter() {
		this.fabricanteDAO = CDIServiceLocator.getBean(FabricanteDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		//criamos um fabricante nulo, para receber o codigo
		Fabricante retorno = null;
		//pegamos o codigo enviado pela requisao
		if (value != null) {
			//setamos este fabricante com o registro do banco de dados, passando o codigo para a busca no banco
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	//por exemplo quando usamos um combo box
	//queremos que ele use apenas o codigo
	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}

}
