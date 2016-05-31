package br.com.jkavdev.persistence.model.id.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@IdClass(MusicId.class)
public class Music implements Serializable {

	private static final long serialVersionUID = 1L;

	private UniquePk id;
	private Person autor;
	private String name;

	@Id
	@OneToOne
	@JoinColumn(name = "unique_id")
	public UniquePk getId() {
		return id;
	}

	public void setId(UniquePk id) {
		this.id = id;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "person_id")
	public Person getAutor() {
		return autor;
	}

	public void setAutor(Person autor) {
		this.autor = autor;
	}

	@Column(name = "music_name", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
