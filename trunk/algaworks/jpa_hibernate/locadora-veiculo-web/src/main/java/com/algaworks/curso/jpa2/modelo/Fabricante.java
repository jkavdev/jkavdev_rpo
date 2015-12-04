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
	
	//implementando hashCode and equals
	//pois quando vamos cadastrar um modelo de carro
	//ele seleciona um fabricante e compara este selecionado
	//com um registro do fabricante
	//sem a implementacao do hash baseado no codigo
	//o java compararia a referencia de memoria destes objetos

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
