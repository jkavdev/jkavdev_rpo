package br.com.jkavdev.hibernate.utils.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//classe responsavel por fornecer uma base para todos os beans

public class BaseBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object obj) {
		// classe util que fara a comparacao de todos os atibutos dos objetos
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		// permite que possamos imprimir o objeto inteiro
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
