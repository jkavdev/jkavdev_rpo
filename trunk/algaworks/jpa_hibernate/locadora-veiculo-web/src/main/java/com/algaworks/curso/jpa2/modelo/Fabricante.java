package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

//camada de modelo de dados

@Entity
@TableGenerator(
		name = "fabricante_generator",	//nome do gerador 
		table = "gerador_codigo", 		//nome da tabela no banco
		allocationSize = 1, 			//quantidade de ids fornecidos pelo banco	
		pkColumnName = "entidade", 		//nome do campo, do qual sera de qual entidade sera gerada o id
		valueColumnName = "alocacao")	//quantidade de ids gerados
public class Fabricante {

	private Long codigo;
	private String nome;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(generator = "fabricante_generator", strategy = GenerationType.TABLE)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
