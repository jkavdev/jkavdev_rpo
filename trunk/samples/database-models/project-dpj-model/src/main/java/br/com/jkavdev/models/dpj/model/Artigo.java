package br.com.jkavdev.models.dpj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "artigos")
public class Artigo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String tipoArtigo;

	@Column(name = "tipo_artigo", nullable = false, length = 100)
	public String getTipoArtigo() {
		return tipoArtigo;
	}

	public void setTipoArtigo(String tipoArtigo) {
		this.tipoArtigo = tipoArtigo;
	}

}
