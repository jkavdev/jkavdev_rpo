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

	//implementacao do hash e equals
	//quando o jsf compara um objeto com outro, 
	//por padrao ele compara sua posicao nao memoria se estes objetos sao iguais
	//no nosso caso, um objeto e igual se ele tiver a mesma chave primaria
	//para isso implementamos os metodos de verifacao de igualdade
	//em cima do codigo
	//se este tiverem os mesmos codigos, estes serao iguais
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
