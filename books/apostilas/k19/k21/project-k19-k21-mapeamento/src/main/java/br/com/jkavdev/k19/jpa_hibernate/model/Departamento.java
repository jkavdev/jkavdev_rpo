package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Departamento extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Collection<Funcionario> funcionarios;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany
	@JoinTable(
			name = "departamento_funcionario",
			joinColumns = @JoinColumn(name = "departamento_id"),
			inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
