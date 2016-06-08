package br.com.gospro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderServico implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private Calendar dataAbertura;
	private Calendar dataEncerramento;
	private String observacoes;
	private String pecaUtilizada;
	private String problema;
	private String servicoExecutado;
	private BigDecimal valorPacial;
	private BigDecimal valorTotal;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "data_abertura")
	@Temporal(TemporalType.DATE)
	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Column(name = "data_encerramento")
	@Temporal(TemporalType.DATE)
	public Calendar getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Calendar dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Column(name = "peca_utilizada")
	public String getPecaUtilizada() {
		return pecaUtilizada;
	}

	public void setPecaUtilizada(String pecaUtilizada) {
		this.pecaUtilizada = pecaUtilizada;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	@Column(name = "servico_executado")
	public String getServicoExecutado() {
		return servicoExecutado;
	}

	public void setServicoExecutado(String servicoExecutado) {
		this.servicoExecutado = servicoExecutado;
	}

	public BigDecimal getValorPacial() {
		return valorPacial;
	}

	@Column(name = "valor_parcial")
	public void setValorPacial(BigDecimal valorPacial) {
		this.valorPacial = valorPacial;
	}

	@Column(name = "valor_total")
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
