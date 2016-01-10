package controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

//informando que eh um bean gerenciado pelo cdi
@Named

// escopos no cdi

// escopo por padrao do cdi
//@Dependent

// tempo de vida sera apenas de uma requisicao
// @RequestScoped

// tempo de vida sera toda a sessao do usuario
// a informacao so sera perdida se trocarmos
// de usuario ou matar a sessao
 @SessionScoped

// tempo de vida sera durante toda a aplicacao
// @ApplicationScoped

// tempo de vida eh controlado
// @ConversationScoped
public class Soma implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// testando cdi
	// para termos acesso ao metodo soma de somador
	// precisariamos instanciar um objeto de somador
	// com cdi e diferente

	// para indicar que o objeto sera injetado
	// usamos a anotacao inject

	@Inject
	private Somador somador;
	private String nome;

	public int retorna() {
		//chamando nome iniciado pelo postConstruct
		this.nome = somador.getNome();
		System.out.println(this.nome);
		return somador.soma(2);
	}

	public Somador getSomador() {
		return somador;
	}

	public void setSomador(Somador somador) {
		this.somador = somador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
