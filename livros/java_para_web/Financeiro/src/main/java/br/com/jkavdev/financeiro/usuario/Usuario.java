package br.com.jkavdev.financeiro.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private Date dataNascimento;
	private String celular;
	private Set<String> permissao = new HashSet<String>();
	private String idioma;
	private boolean ativo;

	@Id
	@GeneratedValue
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// unico
	@NaturalId
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	//informamos qual a classe a ser carregada no set, no caso String
	@ElementCollection(targetClass = String.class)
	@JoinTable(
			name = "usuario_permissao", 														//informa qual sera o nome da tabela do relacionamento 
			uniqueConstraints = {@UniqueConstraint(columnNames = { "usuario", "permissao" }) }, //criara um indice unico entre os atributos usuario e permissao  
			joinColumns = @JoinColumn(name = "usuario")) 										//informa qual a coluna de ligacao entre as tabelas
	@Column(name = "permissao", length = 50) 													//informa o nome da coluna permissao
	public Set<String> getPermissao() { 														//armazenaremos num set, pois nao sera admitido usuario com permissao repetidos
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
