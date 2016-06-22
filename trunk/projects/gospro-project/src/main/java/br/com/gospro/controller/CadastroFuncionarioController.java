package br.com.gospro.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.dao.ICidadeDao;
import br.com.gospro.dao.IEstadoDao;
import br.com.gospro.model.Cargos;
import br.com.gospro.model.Cidade;
import br.com.gospro.model.Estado;
import br.com.gospro.model.Funcionario;
import br.com.gospro.model.Sexo;
import br.com.gospro.service.FuncionarioService;
import br.com.gospro.service.NegocioException;
import br.com.gospro.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;
	@Inject
	private Funcionario funcionario;
	@Inject
	private IEstadoDao estadoDao;
	@Inject
	private ICidadeDao cidadeDao;
	private List<Sexo> sexos;
	private List<Cargos> cargos;
	private List<Estado> estados;
	private List<Cidade> cidades;
	private Estado estado;

	@PostConstruct
	public void init() {
		this.sexos = Arrays.asList(Sexo.values());
		this.cargos = Arrays.asList(Cargos.values());
		this.estados = this.estadoDao.buscarTodos();
	}

	public void salvar() {
		try {
			this.funcionarioService.salvar(this.funcionario);
			FacesUtil.addSuccessMessage("Funcionario: " + this.funcionario.getNome() + " salvo com Sucesso");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		limpaFormulario();
	}

	private void limpaFormulario() {
		this.funcionario = new Funcionario();
	}

	public void buscaCidadePorEstado() {
		this.cidades = this.cidadeDao.buscarCidadePorEstado(this.estado);
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Sexo> getSexos() {
		return this.sexos;
	}

	public List<Cargos> getCargos() {
		return this.cargos;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

}
