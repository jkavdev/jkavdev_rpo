package br.com.so.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.so.modelo.Area;
import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;

public class DaoTeste implements Serializable {

	private Map<String, List<Prova>> listaProvas = new HashMap<String, List<Prova>>();
	private List<Prova> auxProvas;
	private List<Prova> provas;
	private Map<String, String> instituicoes;

	public DaoTeste() {
		instituicoes = new HashMap<String, String>();
		instituicoes.put("INSS", "INSS");
		instituicoes.put("RECEITA FEDERAL", "RECEITA FEDERAL");

		Cargo cargo = new Cargo("SECRETARIO");
		Cargo cargo2 = new Cargo("SEGURANÇA");
		Area area = new Area("ADMINISTRATIVA");

		List<Cargo> cargos = new ArrayList<>();
		cargos.add(cargo);
		cargos.add(cargo2);

		Instituicao inst = new Instituicao();
		inst.setNome("INSS");

		Prova prova = new Prova();
		prova.setInstituicao(inst);
		prova.setCargo(cargo2);
		prova.setArea(area);
//		prova.setNivel("MEDIO");
//		prova.setBanca("CESPE");
//		prova.setData("15/05/2016");

		List<Prova> provas = new ArrayList<>();
		provas.add(prova);

		listaProvas.put("INSS", provas);
	}

	public Map<String, List<Prova>> getListaProvas() {
		return listaProvas;
	}

	public void setListaProvas(Map<String, List<Prova>> listaProvas) {
		this.listaProvas = listaProvas;
	}

	public Map<String, String> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(Map<String, String> instituicoes) {
		this.instituicoes = instituicoes;
	}

	public List<Cargo> getCargosByInstituicao(String instituicao) {
		if (instituicao != null && instituicao != "") {
			if (instituicao.equals("INSS")) {
				Cargo cargo = new Cargo("ADMINISTRATIVO");
				Cargo cargo2 = new Cargo("SEGURANÇA");

				List<Cargo> cargos = new ArrayList<>();
				cargos.add(cargo);
				cargos.add(cargo2);
				return cargos;
			}
		}
		return new ArrayList<>();
	}

	public List<Prova> getProvas(String instituicao) {
		return listaProvas.get(instituicao);
	}

}
