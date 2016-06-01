package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.IAreaDao;
import br.com.so.dao.interfacesDao.IBancaDao;
import br.com.so.dao.interfacesDao.ICargoDao;
import br.com.so.dao.interfacesDao.IInstituicaoDao;
import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Area;
import br.com.so.modelo.Banca;
import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Nivel;
import br.com.so.modelo.Prova;
import br.com.so.util.DataUtil;
import br.com.so.util.jsf.FacesUtil;

@Named
@RequestScoped
public class ProvaBean implements Serializable {

	@Inject
	private IProvaDao provaDao;
	@Inject
	private Prova prova;
	private String data;

	private List<Instituicao> instituicoes;
	private List<Banca> bancas;
	private List<Area> areas;
	private List<String> niveis;
	private List<Cargo> cargos;

	@Inject
	private IInstituicaoDao instituicaoDao;
	@Inject
	private IBancaDao bancaDao;
	@Inject
	private IAreaDao areaDao;
	@Inject
	private ICargoDao cargoDao;

	@PostConstruct
	public void init() {
		instituicoes = instituicaoDao.buscarTodos();
		bancas = bancaDao.buscarTodos();
		areas = areaDao.buscarTodos();
		cargos = cargoDao.buscarTodos();

		niveis = new ArrayList<>();
		for (Nivel nivel : Nivel.values()) {
			niveis.add(nivel.toString());
		}
	}

	public void cadastrar() {
		boolean dataValida = false;
		if (prova != null) {
			if (data != null) {
				dataValida = DataUtil.validaData(data);
			}
			if (dataValida) {
				if (prova.getCargo() != null && prova.getArea() != null && prova.getBanca() != null
						&& prova.getNivel() != null) {
					Calendar d = Calendar.getInstance();
					d.setTime(DataUtil.getDateByString(this.data));
					prova.setData(d);
					provaDao.salvar(prova);
					FacesUtil.addSuccessMessage("Prova Cadastrada com Sucesso!");
				} else {
					FacesUtil.addWarnMessage("Todos os Campos devem ser Preenchidos!");
				}
			} else {
				FacesUtil.addWarnMessage("Data Invalida!");
			}
		}
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public List<Banca> getBancas() {
		return bancas;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public List<String> getNiveis() {
		return niveis;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
