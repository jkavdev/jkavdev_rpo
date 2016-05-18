package br.com.so.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prova implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Calendar data;
	private Instituicao instituicao;
	private Area Area;
	private Cargo cargo;
	private Banca banca;
	private Nivel nivel;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "area_id")
	public Area getArea() {
		return Area;
	}
		
	public void setArea(Area area) {
		Area = area;
	}

	@OneToOne
	@JoinColumn(name = "cargo_id")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Enumerated(EnumType.STRING)
	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@OneToOne
	@JoinColumn(name = "banca_id")
	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	@ManyToOne
	@JoinColumn(name = "intituicao_id")
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
