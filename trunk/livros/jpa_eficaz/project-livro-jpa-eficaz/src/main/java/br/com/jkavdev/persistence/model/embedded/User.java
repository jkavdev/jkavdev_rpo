package br.com.jkavdev.persistence.model.embedded;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private StatusCompra statusCompra;
	private PapelUsuario papelUsuario;
	private Set<String> emails = new HashSet<>();
	private List<PerfilUsuario> perfis = new ArrayList<>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	public StatusCompra getStatusCompra() {
		return statusCompra;
	}

	public void setStatusCompra(StatusCompra statusCompra) {
		this.statusCompra = statusCompra;
	}

	@Enumerated(EnumType.ORDINAL)
	public PapelUsuario getPapelUsuario() {
		return papelUsuario;
	}

	public void setPapelUsuario(PapelUsuario papelUsuario) {
		this.papelUsuario = papelUsuario;
	}

	//sera criado uma tabela
	//sem a necessidade de criar uma entidade
	@ElementCollection
	@CollectionTable(name = "user_has_emails")
	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	@ElementCollection(targetClass = PapelUsuario.class)
	@Enumerated(EnumType.STRING)
	@Column(name="perfil")
	public List<PerfilUsuario> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilUsuario> perfis) {
		this.perfis = perfis;
	}

}
