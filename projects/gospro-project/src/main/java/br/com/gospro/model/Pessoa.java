package br.com.gospro.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.gospro.util.jpa.BaseEntity;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String rg;
	private Sexo sexo;
	private Date dataNascimento;
	private Calendar dataCadastro;
	private Usuario usuario;
	private Contato contato;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@OneToOne
	@JoinColumn(name = "usuario_codigo")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_codigo")
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_codigo")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
