package com.algaworks.javaee;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class InversaoNomeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// variaveis de intancias
	private String nome;
	private String nomeInvertido;
	private int quantidadePalavras;

	// metodo de inversao de nome
	public void inverter() {
		this.nomeInvertido = "";
		this.quantidadePalavras = 0;

		//para evitar nullPointer
		//verificamos se o nome estar nulo ou vazio
		if (this.nome != null && !this.nome.isEmpty()) {
			this.quantidadePalavras = 1;
		}

		//for invertido
		for (int i = this.nome.length() - 1; i >= 0; i--) {
			//pegando o caractere correspondente ao indice
			char letra = this.nome.charAt(i);
			//concatenando a letra no nome invertido
			this.nomeInvertido += letra;

			if (letra == ' ') {
				//quer dizer que existe mais de uma palavra
				this.quantidadePalavras++;
			}
		}
		System.out.println("Nome Ivertido: " + this.nomeInvertido);
		System.out.println("Quantidade : " + this.quantidadePalavras);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeInvertido() {
		return nomeInvertido;
	}

	public void setNomeInvertido(String nomeInvertido) {
		this.nomeInvertido = nomeInvertido;
	}

	public int getQuantidadePalavras() {
		return quantidadePalavras;
	}

	public void setQuantidadePalavras(int quantidadePalavras) {
		this.quantidadePalavras = quantidadePalavras;
	}

}
