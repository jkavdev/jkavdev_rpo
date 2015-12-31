package escola.musica.modelo;

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

@ManagedBean
@SessionScoped
public class CursoBean {

	private Curso curso;
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	private List<Curso> cursos = new ArrayList<>();
	private List<Curso> cursosAccordion = new ArrayList<>();
	
	//metodo a ser chamado pelo pretty-config
	public void inicializarBean(){
		cursos = new CursoDAO().listarTodos();
		cursosAccordion = CursoDAO.listaCursosAccordion();
	}
	
	public void novoCurso(){
		curso = new Curso();
	}

	public void salvar() {
		new CursoDAO().salvar(curso);
		cursos = new CursoDAO().listarTodos();
		curso = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso salvo com sucesso"));
	}

	// retornando a data atual
	public String getDataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public void editar(Curso curso) {
		this.curso = curso;
	}

	// depois de preparar a exclusao,
	// o jsf sabera que o curso sera o do bean
	public void excluir() {
		new CursoDAO().excluir(curso);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso excluido com sucesso!"));
		cursos = new CursoDAO().listarTodos();
	}

	// setando o o curso do bean,
	// com o curso selecionado da datatable
	public void prepararExclusao(Curso curso) {
		this.curso = curso;
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

	public void setTipos(List<TipoCurso> tipos) {
		this.tipos = tipos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursosAccordion() {
		return cursosAccordion;
	}

	public void setCursosAccordion(List<Curso> cursosAccordion) {
		this.cursosAccordion = cursosAccordion;
	}

}
