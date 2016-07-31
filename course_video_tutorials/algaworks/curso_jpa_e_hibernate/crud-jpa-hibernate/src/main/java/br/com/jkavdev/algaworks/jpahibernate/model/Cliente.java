package br.com.jkavdev.algaworks.jpahibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//informando que esta é uma classe que 
//representará uma tabela no banco de dados
@Entity
public class Cliente {

	private Long codigo;
	private String nome;
	private Integer idade;
	private String sexo;
	private String profissao;

	// toda entidade precisa de uma chave primaria
	@Id
	// informando como será gerada a chave
	// no caso identity específico do mysql
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
