package br.com.jkavdev.comercio.modelo.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cliente;
	private Endereco endereco;
	private List<Pedido> pedidos;
	private String nome;

	@Id
	@GeneratedValue
	@Column(name = "cod_cliente")
	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	@OneToOne
	// usada quando duas tabelas usam a mesma chave primaria da tabela forte
	@PrimaryKeyJoinColumn(name = "cod_cliente")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// um cliente tem varios pedidos
	// com mappedBy indica que eh um relacionamento bidirecional
	// onde o relacionamento esta na classe endereco com o atributo cliente
	// com lazy indicamos quando for carregado um pedido
	// apenas os atributos de pedido serao carregado, outros terao que ser
	// demandados
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Column(length = 45)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}

}
