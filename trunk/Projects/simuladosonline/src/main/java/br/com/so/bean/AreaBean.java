package br.com.so.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.IAreaDao;
import br.com.so.modelo.Area;
import br.com.so.util.jsf.FacesUtil;

@Named
@RequestScoped
public class AreaBean {

	@Inject
	private IAreaDao areaDao;
	@Inject
	private Area area;

	public void salvar() {
		if (area != null && area.getNome() != null && !area.getNome().trim().equals("")) {
			if (!areaDao.existe(area)) {
				areaDao.salvar(area);
				FacesUtil.addSuccessMessage("Area salva com Sucesso!");
			}
		} else {
			FacesUtil.addWarnMessage("Todos os Campos devem ser Preenchidos!");
		}
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
