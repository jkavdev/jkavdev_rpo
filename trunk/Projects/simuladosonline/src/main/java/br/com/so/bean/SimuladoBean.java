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
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;
import br.com.so.util.jsf.FacesUtil;

@Named
@ViewScoped
public class SimuladoBean implements Serializable {

	@Inject
	private Instituicao instituicao;
	private String cargo;
	private String area;
	private String banca;
	private String nivel;

	private String areaVazia = "Nenhuma Área";

	private List<Instituicao> instituicoes;
	private List<String> cargos;
	private List<String> areas;
	private List<String> bancas;
	private List<String> niveis;

	private List<Prova> provas;
	private List<Prova> provasFinal;
	private List<Prova> provasAux;

	@Inject
	private IInstituicaoDao instituicaoDao;
	@Inject
	private IProvaDao provaDao;

	@PostConstruct
	public void init() {
		if (instituicoes == null) {
			instituicoes = instituicaoDao.buscarTodos();
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
		cargos = new ArrayList<>();
		if (instituicao != null && instituicao.getNome() != null) {
			provas = provaDao.provasPorInstituicao(instituicao);
			for (Prova p : provas) {
				cargos.add(p.getCargo().getNomeCargo());
			}
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
		provasAux.addAll(provas);
		areas = new ArrayList<>();
		if (cargo != null && !cargo.equals("")) {
			for (Prova p : provasAux) {
				if (p.getCargo() != null && p.getCargo().getNomeCargo() != null
						&& !p.getCargo().getNomeCargo().equals(cargo)) {
					provasAux.remove(p);
				}
				if (p.getCargo().getNomeCargo() == null) {
					provasAux.remove(p);
				}
				if (provasAux != null && provasAux.contains(p)) {
					areas.add(areaVazia);
					if (p.getArea() != null && p.getArea().getNome() != null) {
						if (!areas.isEmpty()) {
							if (!areas.contains(p.getArea().getNome())) {
								areas.add(p.getArea().getNome());
							}
						} else {
							areas.add(p.getArea().getNome());
						}
					}
				}
			}
			if (areas != null && areas.size() == 1) {
				onAreaClick();
				RequestContext.getCurrentInstance().update("banca");
				area = areaVazia;
			}
		} else {
			FacesUtil.addWarnMessage("Cargo deve ser Selecionado!");
		}
	}

	public void onAreaClick() {
		niveis = null;
		nivel = null;
		banca = null;
		if (area != "") {
			bancas = new ArrayList<>();
			for (Prova p : provasAux) {
				if (areas != null && areas.size() > 1 && !area.equals(areaVazia)) {
					if (p.getArea() != null && p.getArea().getNome() != null && !p.getArea().getNome().equals(area)) {
						provasAux.remove(p);
					}
					if (provasAux != null && provasAux.contains(p)) {
						if (p.getBanca() != null && p.getBanca().getNome() != null) {
							if (!bancas.isEmpty()) {
								if (!bancas.contains(p.getBanca().getNome())) {
									bancas.add(p.getBanca().getNome());
								}
							} else {
								bancas.add(p.getBanca().getNome());
							}
						}
					}
				} else {
					if (provasAux != null && provasAux.contains(p)) {
						if (p.getBanca() != null && p.getBanca().getNome() != null) {
							if (!bancas.isEmpty()) {
								if (!bancas.contains(p.getBanca().getNome())) {
									bancas.add(p.getBanca().getNome());
								}
							} else {
								bancas.add(p.getBanca().getNome());
							}
						}
					}
				}
			}
		}
	}

	public void onBancaClick() {
		nivel = null;
		niveis = new ArrayList<>();
		if (banca != "") {
			for (Prova p : provasAux) {
				if (p.getBanca() != null && p.getBanca().getNome() != null && !p.getBanca().getNome().equals(banca)) {
					provasAux.remove(p);
				}
				if (provasAux != null && provasAux.contains(p)) {
					if (p.getNivel() != null) {
						if (!niveis.isEmpty()) {
							if (!niveis.contains(p.getNivel().toString())) {
								niveis.add(p.getNivel().toString());
							}
						} else {
							niveis.add(p.getNivel().toString());
						}
					}
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta! ", "Banca deve ser selecionada!"));
		}
	}

	public void onNivelClick() {
		if (nivel != "") {
			provasFinal = new ArrayList<>();
			for (Prova p : provasAux) {
				if (p.getNivel() != null) {
					if (p.getNivel().toString().equalsIgnoreCase(nivel)) {
						provasFinal.add(p);
					}
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta! ", "Nivel deve ser selecionado!"));
		}
	}

	public void iniciar() {
		System.out.println("Provas: " + provasFinal.size());
		for (Prova p : provasFinal) {
			System.out.println("IDS: " + p.getId());
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