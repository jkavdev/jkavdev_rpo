package com.algaworks.curso.jpa2.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// informando o nome a ser salvo na classe no banco
//@DiscriminatorValue("MOTORISTA")

//usando joined
//inserimos um inteiro
@DiscriminatorValue("1")
public class Motorista extends Pessoa {

	private String numeroCNH;

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

}
