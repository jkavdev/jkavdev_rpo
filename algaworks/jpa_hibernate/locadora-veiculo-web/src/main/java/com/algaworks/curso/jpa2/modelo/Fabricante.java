package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

//classe de modelo de fabricante 
//mudando a geração da chave primaria para um metodo mais portavel a mais bancos
@TableGenerator(
		name="codigo_generator",			//nome do gerador da chave primaria
		table="gerador_codigo",					//nome da tabela gerada no banco de dados
		allocationSize=5,								//total de ids que a aplicacao buscara no banco
		pkColumnName="entidade",			//nome da entidade para qual foi gerada a chave primaria
		valueColumnName="alocacao"	//quantas alocacoes de chaves que o banco teve que realizar
)
@Entity
public class Fabricante {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator="codigo_generator", strategy=GenerationType.TABLE)
	@Column(name="codigo_fabricante")
	private Long codigo;
	private String nome;

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
