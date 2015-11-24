package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
		name = "fabricante_generator", 
		table = "gerador_codigo", 
		pkColumnName = "entidade", 
		valueColumnName = "Alocacao", 
		allocationSize = 5)
public class Fabricante {

	@Id
	@GeneratedValue(generator="fabricante_generator", strategy=GenerationType.TABLE)
	private Long codigo;
	private String nome;

	//mudando a estrategia de geracao de chaves primarias
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//iremos usar a table que e mais portavel entre os bancos	
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
