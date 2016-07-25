package br.com.jkavdev.persistence.model.id.composite;

import java.io.Serializable;

public class AlbumIdClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private Integer secTime;

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

	public AlbumIdClass() {
		super();
	}

	public AlbumIdClass(String title, Integer secTime) {
		this();
		this.title = title;
		this.secTime = secTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((secTime == null) ? 0 : secTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		AlbumIdClass other = (AlbumIdClass) obj;
		if (secTime == null) {
			if (other.secTime != null)
				return false;
		} else if (!secTime.equals(other.secTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
