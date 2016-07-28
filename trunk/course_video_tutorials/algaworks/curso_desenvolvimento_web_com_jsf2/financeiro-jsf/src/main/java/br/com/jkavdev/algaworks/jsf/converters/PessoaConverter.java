package br.com.jkavdev.algaworks.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import br.com.jkavdev.algaworks.jsf.model.Pessoa;
import br.com.jkavdev.algaworks.jsf.util.jpa.HibernateUtil;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;

		if (value != null) {
			Session session = HibernateUtil.getSession();
			
			retorno = session.load(Pessoa.class, new Integer(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getCodigo().toString();
		}

		return null;
	}

}
