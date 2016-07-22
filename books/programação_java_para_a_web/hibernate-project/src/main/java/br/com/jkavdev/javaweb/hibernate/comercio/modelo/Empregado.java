package br.com.jkavdev.javaweb.hibernate.comercio.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empregados")
public class Empregado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empregado;
	private String nome;
	private Empregado chefe;

	@Id
	@GeneratedValue
	@Column(name = "cod_empregado")
	public Integer getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Integer empregado) {
		this.empregado = empregado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToOne
	@JoinColumn(name = "cod_chefe")
	public Empregado getChefe() {
		return chefe;
	}

	public void setChefe(Empregado chefe) {
		this.chefe = chefe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empregado == null) ? 0 : empregado.hashCode());
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
		Empregado other = (Empregado) obj;
		if (empregado == null) {
			if (other.empregado != null)
				return false;
		} else if (!empregado.equals(other.empregado))
			return false;
		return true;
	}

}
