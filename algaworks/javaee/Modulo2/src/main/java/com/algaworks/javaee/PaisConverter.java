package com.algaworks.javaee;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("paisConverter")
public class PaisConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		//no caso de usuario digitar muito rapido
		//nao dando tempo das dicas aparecerem e enviar uma string sem contexto
		Integer codigo = null;
		//tento atribuir o valor para codigo
		try{
			System.out.println("geetAsObject: " + value);
			codigo = Integer.valueOf(value);
			//se acontecer algo errado
			//minha variavel continua null
		}catch(NumberFormatException e){ }
		
		if (value != null) {			
			for (Pais pais : PerfilUsuario.PAISESAUTOCOMPLETEPOJO) {
				if (codigo.equals(pais.getCodigo())) {
					return pais;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Pais pais = (Pais) value;
			return String.valueOf(pais.getCodigo());
		}
		return null;
	}

}
