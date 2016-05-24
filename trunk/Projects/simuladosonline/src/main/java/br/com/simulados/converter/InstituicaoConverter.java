package br.com.simulados.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.simulados.util.CDIServiceLocator;
import br.com.so.dao.InstituicaoDao;
import br.com.so.modelo.Instituicao;

@FacesConverter(forClass = Instituicao.class)
public class InstituicaoConverter implements Converter {

	private InstituicaoDao instituicaoDao;

	public InstituicaoConverter() {
		instituicaoDao = CDIServiceLocator.getBean(InstituicaoDao.class);
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
