package com.algaworks.javaee;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//conversor da classe interesse

//como sera chamado nas telas
@FacesConverter("interesse")
// tem que implementar Converter
public class InteresseConverter implements Converter {

	//sera chamado quando eviaremos informaçoes da tela para bean
	//convertera uma string em objeto
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			// faço um pesquinas nos interesse
			for (Interesse interesse : PerfilUsuario.INTERESSES) {
				// se o valor for igual nome do icone
				if (value.equals(interesse.getNomeIcone())) {
					// retorna o interesse
					return interesse;
				}
			}
		}
		return null;
	}

	// recebera um objeto e convertera em string
	// sera chamado para renderizacao dos componentes do jsf
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// se tem um objeto
		if (value != null) {
			// fazemos o cast
			Interesse interesse = (Interesse) value;
			// retorna o nome do icone
			return interesse.getNomeIcone();
		}
		return null;
	}

}
