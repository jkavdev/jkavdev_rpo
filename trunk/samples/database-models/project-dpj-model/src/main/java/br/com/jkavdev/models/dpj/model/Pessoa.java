package br.com.jkavdev.models.dpj.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "pessoas")
public class Pessoa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nomeCompleto;
	private String nacionalidade;
	private EstadoCivil estadoCivil;
	private Date dataNascimento;
	private String profissao;
	private String naturalidade;
	private String nomePai;
	private String nomeMae;
	private Set<String> telefones;
	private EnderecoPessoa endereco;
	private Cargo cargo;

	@Column(name = "nome_completo", nullable = false, length = 64)
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Column(nullable = false, length = 32)
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Column(name = "estado_civil", nullable = false, length = 13)
	@Enumerated(EnumType.STRING)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Column(name = "data_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(length = 32)
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Column(nullable = false, length = 32)
	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	@Column(name = "nome_pai", nullable = false, length = 64)
	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	@Column(name = "nome_mae", nullable = false, length = 64)
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@ElementCollection
	@CollectionTable(name = "pessoa_telefones", joinColumns = @JoinColumn(name = "pessoa_id"))
	@Column(name = "telefone", length = 20)
	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Embedded
	public EnderecoPessoa getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoPessoa endereco) {
		this.endereco = endereco;
	}

	@OneToOne
	@JoinColumn(name = "cargo_id")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public void adicionaTelefone(String telefone){
		this.getTelefones().add(telefone);
	}

}
