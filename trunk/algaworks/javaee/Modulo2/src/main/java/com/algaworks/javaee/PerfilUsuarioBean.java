package com.algaworks.javaee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final List<Pais> PAISES = new ArrayList<>();
	private String nome;
	private Pais pais;

	static {
		PAISES.add(new Pais(1, "Alemanha"));
		PAISES.add(new Pais(2, "Argelia"));
		PAISES.add(new Pais(3, "Argentina"));
		PAISES.add(new Pais(4, "Belgica"));
		PAISES.add(new Pais(5, "Bolivia"));
		PAISES.add(new Pais(6, "Brasil"));
		PAISES.add(new Pais(7, "Bulgaria"));
		PAISES.add(new Pais(8, "Espanha"));
		PAISES.add(new Pais(9, "Estados Unidos"));
	}

	public void atualizar() {
		if (this.pais == null) {
			adicionaMensagem("Perfil atualizando sem pais");
		} else {
			adicionaMensagem("Perfil atualizado com pais: " + this.pais.getNome() + " (" + this.pais.getCodigo() + ")");
			System.out.println("Pais: " + this.pais.getNome());
		}		
	}

	public void adicionaMensagem(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
