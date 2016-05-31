package br.com.jkavdev.persistence.model.id.composite;

import java.io.Serializable;

public class MusicId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long autor;

	public MusicId() {
		super();
	}

	public MusicId(Long uniqueId, Long autor) {
		this();
		this.id = uniqueId;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAutor() {
		return autor;
	}

	public void setAutor(Long autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
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
		MusicId other = (MusicId) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
