package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

//estamos informando que esta classe
//eh dependente da classe que a injeta

//se a classe que injetar esta classe for
//requestScope esta classe tambem sera 
//ela depende da classe
@Dependent
public class Somador implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	//metodo a ser chamado quando contruir a tela
	@PostConstruct
	public void iniciar(){
		this.nome = "Jhonatan";
	}

	public int soma(int i) {
		return i + 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
