package org.wpattern.frameworks.jsf.primefaces.support.settings;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

//usando escopos do spring
//usando escopo de sessao, que 
//funcionara junto com a sessao do usuario 
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "languageMB")
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// lingua padrao
	private String localeCode;
	// conjunto de idiomas padrao
	private static Map<String, Locale> countries;

	// igual para todos independente da aplicacao
	static {
		countries = new LinkedHashMap<>();
		countries.put("Portugues", new Locale("pt"));
		countries.put("English", new Locale("en"));
	}

	public LanguageBean() {
	}

	public static Map<String, Locale> getCountries() {		
		return countries;
	}

	public String getLocaleCode() {
		// se o idioma for nulo, e o idioma do browser nao for nulo
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		if ((this.localeCode == null) && (viewRoot != null) && (viewRoot.getLocale() != null)) {
			// seta o idioma com o idioma do browser
			this.localeCode = viewRoot.getLocale().getLanguage();
		}

		return this.localeCode;
	}

	public void localeCodeChanged(AjaxBehaviorEvent e) {
		String newLocaleValue = ((SelectOneMenu) e.getSource()).getValue() + "";

		for (Entry<String, Locale> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
			}
		}
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

}
