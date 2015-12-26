package escola.musica.modelo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CursoBean {

	private Curso curso = new Curso();

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
