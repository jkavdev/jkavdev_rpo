package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Fabricante {

	private Long codigo;
	private String nome;

	@Id
	@TableGenerator(
			name = "fabricante_generator",	//nome do gerador de id
			table = "gerador_codigo",		//nome da tabela no banco
			pkColumnName = "entidade",		//nome da coluna onde terao as entidades
			valueColumnName = "locacao",	//qual o id atual para aquela entidade
			allocationSize = 5 )			//quantidade de ids na memoria disponivel
	@GeneratedValue(
			generator = "fabricante_generator",	//usando o gerador de ids
			strategy = GenerationType.TABLE )	//informando qual tipo de geracao de id
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

	//implementacao do hash e equals com base no codigo
	//facilitara quando jsf precisar comparar objetos da tela 
	//com objetos vindo do banco, ou vice-versa
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
