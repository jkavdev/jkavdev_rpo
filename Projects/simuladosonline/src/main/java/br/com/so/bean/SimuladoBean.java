package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.so.modelo.Cargo;
import br.com.so.modelo.Prova;

@ManagedBean
@ViewScoped
public class SimuladoBean implements Serializable {

	private String instituicao;
	private String banca;
	private String cargo;
	private String data;
	private String nivel;
	private String area;

	private List<Prova> provas;
	private Map<String, String> instituicoes;

	private List<String> bancas;
	private List<String> datas;
	private List<String> cargos;
	private List<String> niveis;
	private List<String> areas;

	@PostConstruct
	public void init() {

	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<String> getAreas() {
		return areas;
	}

	public List<String> getCargos() {
		return cargos;
	}

	public List<String> getDatas() {
		return datas;
	}

	public List<String> getNiveis() {
		return niveis;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getBanca() {
		return banca;
	}

	public void setBanca(String banca) {
		this.banca = banca;
	}

	public Map<String, String> getInstituicoes() {
		return instituicoes;
	}

	public List<String> getBancas() {
		return bancas;
	}

	public void mudaInstituicao() {

	}

	public void mudaCargo() {

	}

	public void mudaBanca() {

	}

	public void mudaArea() {

	}

	public void displayLocation() {
		FacesMessage msg;
		if (banca != null && instituicao != null)
			msg = new FacesMessage("Selecionado", banca + " of " + instituicao);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalido", "Banca Não foi selecionada.");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}