package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
//implementando novo gerador de chave primaria
@TableGenerator(
		name="codigo_generator",	//nome do mode de geração da chave, usado no generatorValue 
		table="gerador_codigo",		//nome da tabela no banco de dados
		pkColumnName="entidade",	//nome da entidade
		valueColumnName="alocacao",	//nome do campo do valor gerado
		allocationSize=5			//quantidade de registros fornecidos pelo banco
)
public class Fabricante {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator="codigo_generator", strategy=GenerationType.TABLE)
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
