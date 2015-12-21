package com.algaworks.curso.jpa2.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//usando heranca no jpa

@Entity
//com single_table no banco adicionara
//o tipo da subclasse a classe pessoa 
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//		name="tipo_pessoa",	//informando o nome da coluna adicionada na tabela pessoa 
//		discriminatorType=DiscriminatorType.STRING)	//sera adicionada o nome da entidade a ser salva como pessoa

//podemos usar tambem a estrategia joined
//no qual ira cria a tabela pessoa 
//e mais a tabela que herda de pessoa
//sera apenas criado uma chave estrangeira 
//na entidade que herdar de pessoa
//representando aquela pessoa, ou qualquer coisa
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_pessoa",discriminatorType=DiscriminatorType.STRING)
public abstract class Pessoa {

	private Long codigo;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private Sexo sexo;

	@Id
	@GeneratedValue
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

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	

}
