package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluguel {

	private Long codigo;
	private BigDecimal valorTotal;
	private Carro carro;
	private ApoliceSeguro apoliceSeguro;
	private Calendar dataPedido;
	private Date dataEntrega;
	private Date dataDevolucao;
	private Motorista motorista;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@JoinColumn(name = "valor_total")
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@ManyToOne
	@JoinColumn(name = "codigo_carro")
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	// para salvar um dado referenciando uma outra tabela
	// este dado tem que ser primeiro salvo
	// podemos criar o proprio dao da apolice
	// ou podemos configurar o onetoone
	// com cascade all , verificara se alguel tem alguma dependencia
	// a ser feita no banco
	// no nosso caso apolice tem que ser gravada primeiro
	// ele ira fazer isso
	// @OneToOne(cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "codigo_apolice_seguro")
	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}

	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}

	// sera gravado apenas a data no banco
	@Temporal(TemporalType.DATE)
	@JoinColumn(name = "data_pedido")
	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	// sera gravado data e hora no banco
	@Temporal(TemporalType.TIMESTAMP)
	@JoinColumn(name = "data_entrega")
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@JoinColumn(name = "data_devolucao")
	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@ManyToOne
	@JoinColumn(name = "codigo_motorista")
	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
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
		Aluguel other = (Aluguel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
