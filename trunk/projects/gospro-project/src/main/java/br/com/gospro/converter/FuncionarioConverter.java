package br.com.gospro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.model.Funcionario;
import br.com.gospro.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	// @Inject
	private IFuncionarioDao fabricanteDao;

	public FuncionarioConverter() {
		this.fabricanteDao = CDIServiceLocator.getBean(IFuncionarioDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String codigo) {
		Funcionario retorno = null;

		if (codigo != null) {
			retorno = this.fabricanteDao.buscarPorId(new Long(codigo));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}
}