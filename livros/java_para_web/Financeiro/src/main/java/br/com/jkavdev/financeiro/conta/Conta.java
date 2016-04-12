package br.com.jkavdev.financeiro.conta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.jkavdev.financeiro.usuario.Usuario;

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer conta;
	private Usuario usuario;
	private String descricao;
	private Date dataCadastro;
	private float saldoInicial;
	private boolean favorita;

	@Id
	@GeneratedValue
	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	@ManyToOne															//muitas contas vinculadas a um usuario
	@OnDelete(action = OnDeleteAction.CASCADE)							//permite que quando o usuario removido, suas contas tambem sera removidas
	@JoinColumn(nullable = false)										//indicando que o usuario e obrigatorio 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "data_cadastro", updatable = false, nullable = false)	//a data nao fara parte de updates e nao pode ser nula
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name="saldo_inicial")
	public float getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isFavorita() {
		return favorita;
	}

	public void setFavorita(boolean favorita) {
		this.favorita = favorita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
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
		Conta other = (Conta) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		return true;
	}

}
