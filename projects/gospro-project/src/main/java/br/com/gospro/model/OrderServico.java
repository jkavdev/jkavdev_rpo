package br.com.gospro.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.gospro.util.jpa.BaseEntity;

@Entity
@Table(name="ordem_servicos")
public class OrderServico extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Date dataAbertura;
	private Date dataEncerramento;
	private String observacoes;
	private String pecaUtilizada;
	private String problema;
	private String servicoExecutado;
	private BigDecimal valorPacial;
	private BigDecimal valorTotal;

	@Column(name = "data_abertura")
	@Temporal(TemporalType.DATE)
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Column(name = "data_encerramento")
	@Temporal(TemporalType.DATE)
	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
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
