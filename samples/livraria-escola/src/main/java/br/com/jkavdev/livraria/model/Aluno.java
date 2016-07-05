package br.com.jkavdev.livraria.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "alunos")
public class Aluno extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sobrenome;
	private TipoSexo sexo;
	private Endereco endereco;
	private Contato contato;

	public Aluno(String nome, String sobrenome, TipoSexo sexo, Endereco endereco, Contato contato) {
		this(nome, sobrenome, sexo);
		this.endereco = endereco;
		this.contato = contato;
	}

	public Aluno(String nome, String sobrenome, TipoSexo sexo) {
		this();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
	}

	public Aluno() {
		super();
	}

	@Column(length = 64, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 64)
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Embedded
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
