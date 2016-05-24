package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;

@ManagedBean
@ViewScoped
public class SimuladoBean implements Serializable {

	private String instituicao;
	private Cargo cargo;

	private List<Instituicao> instituicoes;
	private List<Cargo> cargos;

	@PostConstruct
	public void init() {
		Instituicao instituicao = new Instituicao();
		instituicoes = new ArrayList<>();
		instituicao.setNome("Teste");
		instituicoes.add(instituicao);
	}

	public void onInstituicaoClick() {
		System.out.println("Chegou!");
	}

	public void iniciar() {

	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

}