package br.com.jkavdev.k19.jpa_hibernate.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
// alterando o nome da tabela
@Table(name = "pessoas")
public class Pessoa {

	private Long id;
	private String nome;
	private BigDecimal altura;
	private byte[] avatar;
	private Calendar dataNascimento;
	private int idade;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	// informando que este campo pode ser maior que o comum
	@Lob
	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	@Column(name = "data_nascimento")
	// informando que apenas será persistido a data
	@Temporal(TemporalType.DATE)
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	// informando que este campo não será persistido
	@Transient
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
