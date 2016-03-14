package com.algaworks.javaee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PerfilUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private String nome;
	private String sobre;
	private Date dataNascimento;
	private String profissao;
	private Interesse interesse;
	private String estado;
	private String cidade;
	private String sexo;
	private String estadoCivil;
	private String pais;
	private Pais paisAutoCompletePojo;
	
	public static final List<Interesse> INTERESSES = new ArrayList<>();
	public static final List<Pais> PAISESAUTOCOMPLETEPOJO = new ArrayList<>();
	private List<String> estados = new ArrayList<>();
	private List<String> cidades = new ArrayList<>();
	private List<String> interessesM;
	private List<String> paises = new ArrayList<>();
	
	public PerfilUsuario() {
		estados.add("MG");
		estados.add("SP");
		estados.add("RJ");
		
		paises.add("Alemanha");
		paises.add("Argelia");
		paises.add("Argentina");
		paises.add("Belgica");
		paises.add("Bolivia");
		paises.add("Brasil");
		paises.add("Bulgaria");
		paises.add("Espanha");
		paises.add("Estados Unidos");
		
		PAISESAUTOCOMPLETEPOJO.add(new Pais(1, "Alemanha"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(2, "Argelia"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(3, "Argentina"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(4, "Belgica"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(5, "Bolivia"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(6, "Brasil"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(7, "Bulgaria"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(8, "Espanha"));
		PAISESAUTOCOMPLETEPOJO.add(new Pais(9, "Estados Unidos"));
	}
	
	public void carregarCidades(){
		cidades.clear();
		if("MG".equals(estado)){
			cidades.add("Uberlandia");
			cidades.add("Uberaba");
			cidades.add("Belo Horizonte");
		}else if("SP".equals(estado)){
			cidades.add("Sao Paulo");
			cidades.add("Franca");
			cidades.add("Ribeirao");
		}else if("RJ".equals(estado)){
			cidades.add("Rio de Janeiro");
			cidades.add("Belo Niteroi");
		}
	}
	
	//inicializando lista de interesses
	static{		
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
	}

	public void atualizar() {
		System.out.println("Pais: " + this.paisAutoCompletePojo);
		if(this.paisAutoCompletePojo == null){
			adicionarMensagem("Perfil atualizado sem Pais");
		}else{
			adicionarMensagem("Perfil atualizado com Pais " + this.paisAutoCompletePojo.getNome()
					+ " (" + this.paisAutoCompletePojo.getCodigo() + ").");
		}
	}
	
	public List<String> completarTexto(String consulta){
		List<String> resultados = new ArrayList<String>();
		
		if(consulta.startsWith("Thi")){
			resultados.add("Thiago");
			resultados.add("Thiago Faria");
			resultados.add("Thiago Faria de Andrade");
			resultados.add("Thiago da Algaworks");
		}
		
		return resultados;
	}
	
	public List<String> sugerirPaises(String consulta){
		System.out.println("Consulta: " + consulta);
		
		List<String> paisesSugeridos = new ArrayList<>();
		
		for (String pais : this.paises) {
			if(pais.toLowerCase().startsWith(consulta.toLowerCase())){
				paisesSugeridos.add(pais);
			}
		}
		
		return paisesSugeridos;
	}
	
	public List<Pais> sugerirPaisesAutoCompletePojo(String consulta){
		List<Pais> paisesSugeridos = new ArrayList<>();
		for (Pais pais : PAISESAUTOCOMPLETEPOJO) {
			if(pais.getNome().toLowerCase().startsWith(consulta.toLowerCase())){
				paisesSugeridos.add(pais);
			}
		}
		
		return paisesSugeridos;
	}
	
	private void adicionarMensagem(String messagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messagem));
	}
	
	//retorna a data atual
	public Date getDataHoje(){
		return new Date();
	}
	
	public List<Interesse> getInteresses(){
		return INTERESSES;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<String> getInteressesM() {
		return interessesM;
	}

	public void setInteressesM(List<String> interessesM) {
		this.interessesM = interessesM;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public static List<Pais> getPaisesa() {
		return PAISESAUTOCOMPLETEPOJO;
	}

	public Pais getPaisAutoCompletePojo() {
		return paisAutoCompletePojo;
	}

	public void setPaisAutoCompletePojo(Pais paisA) {
		this.paisAutoCompletePojo = paisA;
	}
	
	

}
