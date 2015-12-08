package escola.musica.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import escola.musica.dao.CursoDAO;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

@ManagedBean
@SessionScoped
public class CursoBean {

	private Curso curso = new Curso();
	// transformando um arrays em uma lista
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	private List<Curso> cursos = new ArrayList<>();

	public String salvar() {
		new CursoDAO().salvar(curso);
		cursos.add(curso);		
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Curso salvo com Sucesso", ""));
		limpar();
		return "curso_lista?faces-redirect=true";
	}

	private void limpar() {
		curso = new Curso();
	}
	
	public String getDataAtual(){
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
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

	public List<Curso> getCursos() {
		return cursos;
	}

}
