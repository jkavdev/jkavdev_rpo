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
import escola.musica.dao.FacesUtil;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

@ManagedBean
@SessionScoped
public class CursoBean {

	private Curso curso;
	// transformando um arrays em uma lista
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	private List<Curso> cursos = new ArrayList<>();
	private List<Curso> cursosAccordion = new ArrayList<>();
	
	//metodo a ser chamado pelo
	//pretty face
	public void iniciarBean() {
		cursos = new CursoDAO().listarTodos();
		cursosAccordion = CursoDAO.listarCursosAccordion();
		this.limpar();
	}
	
	public String salvar() {
		new CursoDAO().salvar(curso);
//		cursos.add(curso);
		cursos = new CursoDAO().listarTodos();
		FacesUtil.addSuccessMessage("Curso salvo com Sucesso");
		limpar();
		return "curso_lista?faces-redirect=true";
	}
	
	public String editar(Curso curso){
		this.curso = curso;
		return "curso_formulario?faces-redirect=true";
	}
	
	public void excluir(){
		new CursoDAO().excluir(curso);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Curso excluido com sucesso!"));
		cursos = new CursoDAO().listarTodos();
	}
	
	public void prepararExclusao(Curso curso){
		this.curso = curso;
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

	public List<Curso> getCursosAccordion() {
		return cursosAccordion;
	}
	
	

}
