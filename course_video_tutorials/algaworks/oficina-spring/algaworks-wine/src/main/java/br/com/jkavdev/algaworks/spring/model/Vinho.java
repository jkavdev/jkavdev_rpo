package br.com.jkavdev.algaworks.spring.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "vinhos")
public class Vinho {

	private Long codigo;
	private String nome;
	private TipoVinho tipo;
	private Integer safra;
	private Integer volume;
	private BigDecimal valor;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@NotBlank(message = "Nome é obrigatório!")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "Tipo é obrigatório!")
	@Enumerated(EnumType.STRING)
	public TipoVinho getTipo() {
		return tipo;
	}

	public void setTipo(TipoVinho tipo) {
		this.tipo = tipo;
	}

	@NotNull(message = "Safra é obrigatório!")
	public Integer getSafra() {
		return safra;
	}

	public void setSafra(Integer safra) {
		this.safra = safra;
	}

	@NotNull(message = "Volume é obrigatório!")
	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@NotNull(message = "Valor é obrigatório!")
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		Vinho other = (Vinho) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
