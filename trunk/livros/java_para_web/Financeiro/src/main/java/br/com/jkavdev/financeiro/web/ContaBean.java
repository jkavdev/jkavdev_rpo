package br.com.jkavdev.financeiro.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.jkavdev.financeiro.conta.Conta;
import br.com.jkavdev.financeiro.conta.ContaService;

@ManagedBean
@RequestScoped
public class ContaBean {

	private Conta contaSelecionada = new Conta();
	private List<Conta> lista = null;
	@ManagedProperty(value = "#{contextoBean}") 									// injetando uma instancia de contextoBean
	private ContextoBean contextoBean;

	public String salvar() {
		this.contaSelecionada.setUsuario(this.contextoBean.getUsuarioLogado());
		ContaService contaService = new ContaService();

		contaService.salvar(this.contaSelecionada);

		refresh();

		return null;
	}

	public String excluir() {
		ContaService contaService = new ContaService();
		contaService.excluir(this.contaSelecionada);

		refresh();

		return null;
	}

	public void refresh() {
		this.contaSelecionada = new Conta();
		this.lista = null;
	}

	public String tornarFavorita() {
		ContaService contaService = new ContaService();
		contaService.tornarFavorita(this.contaSelecionada);

		this.contaSelecionada = new Conta();
		return null;
	}

	public Conta getContaSelecionada() {
		return contaSelecionada;
	}

	public void setContaSelecionada(Conta contaSelecionada) {
		this.contaSelecionada = contaSelecionada;
	}

	public List<Conta> getLista() {
		if (this.lista == null) {
			ContaService contaService = new ContaService();
			this.lista = contaService.listar(this.contextoBean.getUsuarioLogado());
		}
		return lista;
	}

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}

}
