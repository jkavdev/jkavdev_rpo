package br.com.jkavdev.k19.jpa_hibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// alterando o nome da tabela
@Table(name = "pessoas")
public class Pessoa {

	private Long id;
	private String nome;
	private BigDecimal altura;

	@Id
	@GeneratedValue
	// alterando o nome da coluna
	@Column(name = "pessoa_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// alterando atributos de pessoas
	@Column(length = 30, nullable = false, unique = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// alterando a precisao e a escala
	@Column(precision = 3, scale = 2)
	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

}
