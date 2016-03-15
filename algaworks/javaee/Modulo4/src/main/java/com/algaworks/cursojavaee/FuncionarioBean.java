package com.algaworks.cursojavaee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String[] nomes = {"joao", "maria", "eduardo", "sebastiao", "mariana", "francisco", "manoel", "fernando", "gabriela", "mario", "marcos"};
	private static final String[] sobrenomes = {"souza", "silva", "andrade", "machado", "junio", "albuquerque", "alencar", "assis", "batista", "camargo", "coelho", "costa", "dias", "rosas", "leal", "lima", "leite"};
	
	private List<Funcionario> funcionarios;
	
	public FuncionarioBean() {
		funcionarios = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			adicionarFuncionario();
		}
	}

	private void adicionarFuncionario() {
		String nomeCompleto = getNomeAleatorio() + " " + getSobrenomeAleatorio() + " " + getSobrenomeAleatorio();
		funcionarios.add(new Funcionario(getMatriculaAleatoria(), nomeCompleto, getDataAleatoria(), getSalarioAleatorio()));
	}
	
	private BigDecimal getSalarioAleatorio() {
		return new BigDecimal(1000 + (Math.random() * 29000));
	}

	private Date getDataAleatoria() {
		long dezAnosEmMillis = 24 * 60 * 60 * 1000;
		long periodoSorteadoEmMillis = ((long)(Math.random() * 10 * 365)) * dezAnosEmMillis;
		return new Date(System.currentTimeMillis() - periodoSorteadoEmMillis);
	}

	private Long getMatriculaAleatoria() {
		return (long)(Math.random() * 10000);
	}

	private String getNomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (nomes.length - 1));
		return nomes[posicao];
	}

	private String getSobrenomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (sobrenomes.length - 1));
		return sobrenomes[posicao];
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	

}
