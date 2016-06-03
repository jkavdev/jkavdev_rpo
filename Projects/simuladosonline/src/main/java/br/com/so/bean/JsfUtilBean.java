package br.com.so.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.so.modelo.Instituicao;
import br.com.so.util.DataUtil;

@Named
@RequestScoped
public class JsfUtilBean {

	public String formatDate(Calendar data, String pattern) {
		return (new SimpleDateFormat(pattern)).format(DataUtil.getDateByCalendar(data));
	}

	public String formataTexto(String textoA, String textoB) {
		String texto = textoA + " - " + textoB;
		if (texto.length() > 22) {
			texto = texto.substring(0, 22);
			texto = texto + "[...]";
		}
		return texto;
	}

}
