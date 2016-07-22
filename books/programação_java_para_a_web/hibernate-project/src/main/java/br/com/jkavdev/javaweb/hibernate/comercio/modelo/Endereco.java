package br.com.jkavdev.javaweb.hibernate.comercio.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer endereco;
	private Cliente cliente;
	private String rua;
	private String cidade;

	@Id
	@GeneratedValue(generator = "fk_endereco_cod_cliente")
	//indica que quando um cliente for salvo
	//o id gerado para o cliente tambem sera usado para
	//a identificacao do endereco
	@GenericGenerator(name = "fk_endereco_cod_cliente", strategy = "foreign", parameters = @Parameter(name = "property", value = "cliente"))
	@Column(name = "cod_cliente")
	public Integer getEndereco() {
		return endereco;
	}

	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}

	@OneToOne(mappedBy = "endereco")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		return true;
	}

}
