package br.com.so.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.ICargoDao;
import br.com.so.modelo.Cargo;
import br.com.so.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CargoBean {

	@Inject
	private ICargoDao cargoDao;
	@Inject
	private Cargo cargo;

	public void salvar() {
		if (cargo != null && cargo.getNomeCargo() != null && !cargo.getNomeCargo().trim().equals("")) {
			if (!cargoDao.existe(cargo)) {
				cargoDao.salvar(cargo);
				FacesUtil.addSuccessMessage("Cargo salvo com Sucesso!");
			}
		} else {
			FacesUtil.addWarnMessage("Todos os Campos devem ser Preenchidos!");
		}
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
