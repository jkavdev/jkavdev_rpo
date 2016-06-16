package br.com.so.service;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.context.RequestContext;

import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;
import br.com.so.util.jsf.FacesUtil;

public class HomeService {
	public static final String areaVazia = "Nenhuma Área";

	public static List<String> getBancas(String area, List<String> areas, List<Prova> provasAux) {
		List<String> bancas = new ArrayList<>();
		if (!area.trim().equals("")) {
			for (Prova p : provasAux) {
				if (!area.equals("Nenhuma Área")) {
					if (areas.size() > 1 && !area.equalsIgnoreCase(areaVazia)) {
						if (p.getArea() != null && p.getArea().getNome() != null
								&& !p.getArea().getNome().equalsIgnoreCase(area)) {
							provasAux.remove(p);
						}
						if (provasAux.contains(p)) {
							if (p.getBanca() != null && p.getBanca().getNome() != null) {
								if (!bancas.contains(p.getBanca().getNome())) {
									bancas.add(p.getBanca().getNome());
								}
							}
						}
					}
				} else {
					if (p.getBanca() != null && p.getBanca().getNome() != null) {
						if (!bancas.contains(p.getBanca().getNome())) {
							bancas.add(p.getBanca().getNome());
						}
					}
				}
			}
		} else {
			FacesUtil.addWarnMessage("Selecione uma Área!");
		}
		return bancas;
	}

	public static List<String> getNiveis(String banca, List<Prova> provasAux) {
		List<String> niveis = new ArrayList<>();
		if (!banca.trim().equals("")) {
			for (Prova p : provasAux) {
				if (p.getBanca() != null && p.getBanca().getNome() != null
						&& !p.getBanca().getNome().equalsIgnoreCase(banca)) {
					provasAux.remove(p);
				}
				if (provasAux.contains(p)) {
					if (p.getNivel() != null) {
						if (!niveis.contains(p.getNivel().toString())) {
							niveis.add(p.getNivel().toString());
						}
					}
				}
			}
		} else {
			FacesUtil.addWarnMessage("Banca deve ser selecionada!");
		}
		return niveis;
	}

	public static List<Prova> getProvaSimulado(String nivel, List<Prova> provasAux) {
		List<Prova> provasSimulado = new ArrayList<>();
		if (!nivel.trim().equals("")) {
			for (Prova p : provasAux) {
				if (p.getNivel() != null) {
					if (p.getNivel().toString().equalsIgnoreCase(nivel)) {
						provasSimulado.add(p);
					}
				}
			}
		} else {
			FacesUtil.addWarnMessage("Nivel deve ser selecionado!");
		}
		return provasSimulado;
	}

	public static List<String> getCargos(List<Prova> provas) {
		List<String> cargos = new ArrayList<>();
		for (Prova p : provas) {
			cargos.add(p.getCargo().getNomeCargo());
		}
		return cargos;
	}

	public static List<String> getAreas(String cargo, List<String> areas, List<Prova> provasAux, List<Prova> provas,
			String area, List<String> bancas) {
		areas.add(HomeService.areaVazia);
		if (!cargo.trim().equals("")) {
			for (Prova p : provas) {
				if (p.getCargo() != null && p.getCargo().getNomeCargo() != null
						&& p.getCargo().getNomeCargo().equalsIgnoreCase(cargo)) {
					provasAux.add(p);
				}
				if (!provasAux.isEmpty() && provasAux.contains(p)) {
					if (p.getArea() != null && p.getArea().getNome() != null) {
						if (!areas.contains(p.getArea().getNome())) {
							areas.add(p.getArea().getNome());
						}
					}
				}
			}
			
		} else {
			FacesUtil.addWarnMessage("Cargo deve ser Selecionado!");
		}
		return areas;
	}
}
