package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//os nomes das named querys tem que ser
//unicos, pois a aplicacao fara uso delas
//sem distincao

//usando uma lista de querys
@NamedQueries({
	@NamedQuery(name="Carro.buscarTodos", query="select c from Carro c"),
	@NamedQuery(name="Carro.buscarCarroComAcessorios", query="select c from Carro c JOIN c.acessorios a where c.codigo = :codigo")
})

public class Carro {

	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;
	private BigDecimal valorDiaria;
	private ModeloCarro modelo;
	private List<Acessorio> acessorios;
	private List<Aluguel> alugueis;
	
	private Date dataCriacao;
	private Date dataModificacao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@JoinColumn(name="valor_diaria")
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@ManyToOne
	@JoinColumn(name = "codigo_modelo")
	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	//como carros tem uma lista de acessorios
	//podemos retornar estes na hora que 
	//carro for carregado
	//para isso usamos eager
	
	//mas pode ocorrer problemas
	//pois com esse atributo
	//seram carregados todos os
	//acessorios de todos os carros retornados
//	@ManyToMany(fetch=FetchType.EAGER)
	
	//podemos trazer os acessorios
	//apenas quando solicitado
	//para isso usaremos lazy
	//padrao paro manytomany
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "carro_acessorio", // nome da tabela no banco
	joinColumns = @JoinColumn(name = "codigo_carro") , // nome da coluna da
														// entidade carro
	inverseJoinColumns = @JoinColumn(name = "codigo_acessorio") ) // nome da
																	// coluna de
																	// acessorios
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@OneToMany(mappedBy="carro") //informando que o relacionamento ja foi realizado 
	public List<Aluguel> getAlugueis() {	//atraves do atributo carro de aluguel
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	//toda vez antes de persistir um objeto
	//ou atualizar, este metodo sera 
	//chamado
	@PrePersist
	@PreUpdate
	public void configuraDatasCriacaoEAlteracao(){
		this.dataModificacao = new Date();
		//se for null significa que eh um novo registro
		//se nao um registro a ser alterado
		if(this.dataCriacao == null){
			this.dataCriacao = new Date();
		}
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
		Carro other = (Carro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
