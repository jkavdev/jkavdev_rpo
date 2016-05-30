package br.com.so.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.so.dao.hibernate.HibernateInstituicaoDao;
import br.com.so.modelo.Instituicao;
import br.com.so.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Instituicao.class)
public class InstituicaoConverter implements Converter {

	private HibernateInstituicaoDao instituicaoDao;

	public InstituicaoConverter() {
		instituicaoDao = CDIServiceLocator.getBean(HibernateInstituicaoDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Instituicao instituicao = null;

		if (value != null) {
			instituicao = this.instituicaoDao.buscarPorId(new Long(value));
			System.out.println(instituicao.getNome());
		}
		return instituicao;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Instituicao) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}

}
