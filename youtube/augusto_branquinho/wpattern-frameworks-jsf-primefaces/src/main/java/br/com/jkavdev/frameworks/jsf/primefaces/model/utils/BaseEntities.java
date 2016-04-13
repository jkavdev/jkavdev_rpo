package br.com.jkavdev.frameworks.jsf.primefaces.model.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

//classe base para os beans
//recebe um tipo da chave primaria

public abstract class BaseEntities<PK extends Serializable> extends AbstractPersistable<PK> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override

	// primary key do bean
	public void setId(PK id) {
		super.setId(id);
	}

	@Override
	// imprime informacoes do objeto em linhas quebradas
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	// comparacao de valor por valor
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
