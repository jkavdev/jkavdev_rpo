package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.InstituicaoDao;
import br.com.so.dao.ProvaDao;
import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;

@Named
@ViewScoped
public class SimuladoBean implements Serializable {

	@Inject
	private Instituicao instituicao;
	@Inject
	private Cargo cargo;

	private List<Instituicao> instituicoes;
	private List<Cargo> cargos;
	private List<Prova> provas;

	@Inject
	private InstituicaoDao instituicaoDao;
	@Inject
	private ProvaDao provaDao;

	@PostConstruct
	public void init() {
		if (instituicoes == null) {
			instituicoes = instituicaoDao.buscarTodos();
		}
	}

	public void onInstituicaoClick() {
		System.out.println("ID:" + instituicao.getId());
		provas = provaDao.provasPorInstituicao(instituicao);
		System.out.println(provas.size());
		cargos = new ArrayList<>();
		for (Prova p : provas) {
			cargos.add(p.getCargo());
		}
	}

	public void iniciar() {
		System.out.println("Iniciou");
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
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

	public List<Cargo> getCargos() {
		return cargos;
	}

}