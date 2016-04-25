package br.com.jkavdev.mysql.world.entities.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

//classe base para todas as entidades do banco

public abstract class BaseEntity<PK extends Serializable> extends
		AbstractPersistable<PK> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	// primary key do bean
	public void setId(PK id) {
		super.setId(id);
	}

	@Override
	// usando classe utilitaria do commons para imprimir o objetos em linhas
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	// usando classe utilitaria do commons para comparar os objetos passados
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
