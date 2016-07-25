package br.com.jkavdev.persistence.model.id.composite;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "album")
@IdClass(AlbumIdClass.class)
@AttributeOverrides({
	@AttributeOverride(name = "title", column = @Column(length = 50, nullable = false)),
	@AttributeOverride(name = "secTime", column = @Column(name="sec_time", nullable = false))
})
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String title;
	@Id
	private Integer secTime;
	private BigDecimal price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSecTime() {
		return secTime;
	}

	public void setSecTime(Integer secTime) {
		this.secTime = secTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
