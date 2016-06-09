package br.com.so.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Questao implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private List<Opcao> opcoes;
	private String resposta;
	private Disciplina disciplina;
	private String tipo;
	private String enunciado;
	private Prova prova;
	private String texto;
	private String referenciaTexto;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	@ManyToOne
	@JoinColumn(name = "disciplina_codigo")
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}

	@ManyToMany
	@JoinTable(name = "opcao_questao")
	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@ManyToOne
	@JoinColumn(name = "prova_codigo")
	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getReferenciaTexto() {
		return referenciaTexto;
	}

	public void setReferenciaTexto(String referenciaTexto) {
		this.referenciaTexto = referenciaTexto;
	}

}
