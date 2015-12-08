package escola.musica.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

@ManagedBean
public class CursoBean {

	private Curso curso = new Curso();
	//transformando um arrays em uma lista
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	
	public void salvar(){
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Curso salvo com Sucesso", ""));;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TipoCurso> getTipos() {
		return tipos;
	}

}
