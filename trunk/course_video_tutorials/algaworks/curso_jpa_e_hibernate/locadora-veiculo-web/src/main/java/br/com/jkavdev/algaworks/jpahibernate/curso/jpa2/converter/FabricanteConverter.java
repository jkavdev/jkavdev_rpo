package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao.FabricanteDao;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	private FabricanteDao fabricanteDao;

	public FabricanteConverter() {
		this.fabricanteDao = CDIServiceLocator.getBean(FabricanteDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;

		if (value != null) {
			retorno = this.fabricanteDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
