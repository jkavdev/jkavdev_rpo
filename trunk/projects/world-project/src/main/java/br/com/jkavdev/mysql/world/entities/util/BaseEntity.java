package br.com.jkavdev.mysql.world.entities.util;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//classe base para todas as entidades do banco

//recebe o tipo da chave primaria
@MappedSuperclass
public abstract class BaseEntity<PK extends Serializable> implements Serializable {

	private PK id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;

	@Override
	// usando classe utilitaria do commons para imprimir o objetos em linhas
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	// comparacao dos objetos passados, valor por valor
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
