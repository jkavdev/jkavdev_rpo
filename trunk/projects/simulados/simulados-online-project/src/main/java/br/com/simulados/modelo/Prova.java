package br.com.simulados.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.simulados.util.jpa.PersistenceObject;

@Entity
public class Prova extends PersistenceObject<Long> {

	private static final long serialVersionUID = 1L;

	private Calendar data;
	private Instituicao instituicao;
	private Area Area;
	private Cargo cargo;
	private Banca banca;
	private Nivel nivel;

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
	@Column(name = "data_prova")
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
	@JoinColumn(name = "instituicao_id")
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
