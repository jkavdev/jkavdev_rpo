package br.com.jkavdev.algaworks.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

import br.com.jkavdev.algaworks.jsf.util.jsf.FacesUtil;

@FacesValidator("br.com.jkavdev.algaworks.jsf.RequeridoCondicional")
public class RequeridoCondicionalValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		Boolean checado = (Boolean) component.getAttributes().get("checado");

		if (checado != null && checado && value == null) {
			Object label = MessageFactory.getLabel(context, component);
			String descricaoErro = FacesUtil.getMensagemI18n("fill_the_field") + label;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);

			throw new ValidatorException(message);
		}

	}

}