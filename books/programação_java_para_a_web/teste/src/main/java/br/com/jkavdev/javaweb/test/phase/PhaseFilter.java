package br.com.jkavdev.javaweb.test.phase;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

//Implementando filtro que pode interceptar as fases do JSF

public class PhaseFilter implements PhaseListener {

	private static final long serialVersionUID = 1L;

	// Sempre depois da fase na qual atribuimos
	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Depois da aplicacao");
		System.out.println("END PHASE " + event.getPhaseId());

		// retornando a pagina atual, nao deixando acessar 'mostra-usuario'
		FacesContext context = FacesContext.getCurrentInstance();
		String paginaAcessada = context.getViewRoot().getViewId();
		if (paginaAcessada.equals("/mostra-usuario.xhtml")) {
			return;
		}
	}

	// Sempre antes da fase na qual atribuimos
	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Antes da Aplicacao");
		System.out.println("START PHASE " + event.getPhaseId());
	}

	// Fase na qual queremos interceptar
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
