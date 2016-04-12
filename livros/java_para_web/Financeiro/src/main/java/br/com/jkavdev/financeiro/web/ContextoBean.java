package br.com.jkavdev.financeiro.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.jkavdev.financeiro.conta.Conta;
import br.com.jkavdev.financeiro.conta.ContaService;
import br.com.jkavdev.financeiro.usuario.Usuario;
import br.com.jkavdev.financeiro.usuario.UsuarioService;

@ManagedBean
@SessionScoped
public class ContextoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigoContaAtiva = 0;

	public Usuario getUsuarioLogado() {										
		FacesContext context = FacesContext.getCurrentInstance();			//obtem o login do usuario logado
		ExternalContext externalContext = context.getExternalContext();
		String login = externalContext.getRemoteUser();

		if (login != null) {												// se existir o login
			UsuarioService usuarioService = new UsuarioService();			//busca o usuario no banco
			return usuarioService.buscarPorLogin(login);					//retorna usuario
		}

		return null;
	}

	public Conta getContaAtiva() {											//fornece a conta ativa no momento
		Conta contaAtiva = null;

		if (this.codigoContaAtiva == 0) {									//se nao houver
			contaAtiva = this.getContaAtivaPadrao();						//obtem conta favorita ou a primeira conta cadastrada do usuario
		} else {
			ContaService contaService = new ContaService();					//se houver
			contaAtiva = contaService.carregar(this.codigoContaAtiva);		//buscara no banco
		}

		if (contaAtiva != null) {											//atribui o id da conta ativa ao codigoContaAtiva 
			this.codigoContaAtiva = contaAtiva.getConta();
			return contaAtiva;												//retorna conta ativa
		}

		return null;
	}

	private Conta getContaAtivaPadrao() {
		ContaService contaService = new ContaService();
		Conta contaAtiva = null;
		Usuario usuario = this.getUsuarioLogado();

		contaAtiva = contaService.buscarFavorita(usuario);				//busca conta favorita do usuario logado

		if (contaAtiva == null) {										//se nao existir conta favorita
			List<Conta> contas = contaService.listar(usuario);			//busca no banco as contas vinculadas ao usuario
			if (contas != null && contas.size() > 0) {
				contaAtiva = contas.get(0);								//atribui a conta ativa a primeira conta que tiver na lista 
			}
		}
		return contaAtiva;
	}

	public void changeContaAtiva(ValueChangeEvent event) {
		this.codigoContaAtiva = (Integer) event.getNewValue();
	}
	
	//um exemplo de como obter o contexto bean
	/*
	public ContextoBean getContextoBean(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(true);
		return (ContextoBean) session.getAttribute("contextoBean");
	}
	podemos obter o contexto bean de uma forma mais facil
	//podemos usar o managedProperty informando o nome do atributo
	*/

}


