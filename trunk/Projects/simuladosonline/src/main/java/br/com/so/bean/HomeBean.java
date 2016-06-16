package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.so.dao.interfacesDao.IInstituicaoDao;
import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.dao.interfacesDao.IQuestaoDao;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;
import br.com.so.service.HomeService;
import br.com.so.util.jsf.FacesUtil;

@Named
@ViewScoped
public class HomeBean implements Serializable {

	@Inject
	private Instituicao instituicao;
	private String cargo;
	private String area;
	private String banca;
	private String nivel;

	private List<Instituicao> instituicoes;
	private List<String> cargos;
	private List<String> areas;
	private List<String> bancas;
	private List<String> niveis;

	private List<Prova> provas;
	private List<Prova> provasSimulado;
	private List<Prova> provasAux;

	@Inject
	private IInstituicaoDao instituicaoDao;
	@Inject
	private IProvaDao provaDao;
	@Inject
	private IQuestaoDao questaoDao;

	@PostConstruct
	public void init() {
		if (instituicoes == null) {
			instituicoes = instituicaoDao.buscaTodasComProva();
		}
	}

	public void onInstituicaoClick() {
		areas = null;
		bancas = null;
		niveis = null;
		cargo = null;
		area = null;
		banca = null;
		nivel = null;
		if (instituicao != null && instituicao.getNome() != null && !instituicao.getNome().trim().equals("")) {
			provas = provaDao.provasPorInstituicao(instituicao);
			cargos = HomeService.getCargos(provas);
		} else {
			FacesUtil.addWarnMessage("Instituição deve ser selecionada!");
		}
	}

	public void onCargoClick() {
		bancas = null;
		niveis = null;
		banca = null;
		nivel = null;
		area = null;
		provasAux = new ArrayList<>();
		areas = new ArrayList<>();
		areas = HomeService.getAreas(cargo, areas, provasAux, provas, area, bancas);
		if (areas.size() == 1) {
			area = HomeService.areaVazia;
			bancas = new ArrayList<>();
			for (Prova p : provasAux) {
				if (p.getBanca() != null && p.getBanca().getNome() != null) {
					if (!bancas.contains(p.getBanca().getNome())) {
						bancas.add(p.getBanca().getNome());
					}
				}
			}
			RequestContext.getCurrentInstance().update("painel:painelGrid:banca");
		}
	}

	public void onAreaClick() {
		niveis = null;
		nivel = null;
		banca = null;
		bancas = HomeService.getBancas(area, areas, provasAux);
	}

	public void onBancaClick() {
		nivel = null;
		niveis = HomeService.getNiveis(banca, provasAux);
	}

	public void onNivelClick() {
		provasSimulado = HomeService.getProvaSimulado(nivel, provasAux);
	}

	public void iniciar() {
		if (instituicao != null && cargo != null && banca != null && nivel != null && provasSimulado != null) {
			List<Questao> questoes = new ArrayList<>();
			for (Prova p : provasSimulado) {
				System.out.println("Prova id:" + p.getId());
				List<Questao> aux = questaoDao.getQuestoesByProva(p);
				if (aux != null && !aux.isEmpty()) {
					questoes.addAll(aux);
				}
			}
		} else {
			FacesUtil.addWarnMessage("Todos com campos com * devem ser preenchidos!");
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public List<String> getCargos() {
		return cargos;
	}

	public List<String> getAreas() {
		return areas;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBanca() {
		return banca;
	}

	public void setBanca(String banca) {
		this.banca = banca;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<String> getBancas() {
		return bancas;
	}

	public List<String> getNiveis() {
		return niveis;
	}

}