package br.com.gospro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

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

	public String getServicoExecutado() {
		return servicoExecutado;
	}

	public void setServicoExecutado(String servicoExecutado) {
		this.servicoExecutado = servicoExecutado;
	}

	public BigDecimal getValorPacial() {
		return valorPacial;
	}

	public void setValorPacial(BigDecimal valorPacial) {
		this.valorPacial = valorPacial;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
