package br.com.jkavdev.frameworks.jsf.primefaces.support.settings;

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

//escopo de sessao
@Scope(value = WebApplicationContext.SCOPE_SESSION)
// bean gerenciavel
@Named(value = "languageBean")
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// informa o idioma da pagina
	private String localeCode;
	// idiomas padroes do sistema
	private static Map<String, Locale> countries;

	static {
		// instanciando e carregando idiomas
		countries = new LinkedHashMap<String, Locale>();
		countries.put("English", new Locale("en"));
		countries.put("Português", new Locale("pt"));
	}

	public LanguageBean() {
	}

	public static Map<String, Locale> countries() {
		return countries;
	}

	public String getLocaleCode() {
		// se o locale for nulo, ainda nao verificamos o idioma atual
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		if ((this.localeCode == null) && (viewRoot != null) && (viewRoot.getLocale() != null)) {
			// atribui as configuracoes de idioma do usuario para o localecode
			this.localeCode = viewRoot.getLocale().getLanguage();
		}

		return this.localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void localeCodeChanged(AjaxBehaviorEvent e) {
		// recebe as informacoes do idioma selecionado no combobox
		String newLocaleValue = ((SelectOneMenu) e.getSource()).getValue() + "";

		for (Entry<String, Locale> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
			}
		}
	}

}
