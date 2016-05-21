package br.com.so.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.so.modelo.Instituicao;

@ManagedBean
@RequestScoped
public class InstituicaoBean implements Serializable {

	private Instituicao instituicao = new Instituicao();

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void cadastrar() {
		System.out.println("Nome:");
	}

}
