package br.com.caelum.livraria.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemaBean {

	private String tema = "aristo";

	public List<String> getTemas() {
		return Arrays.asList("afterdark", "afternoon", "afterwork", "black-tie", "blitzer", "bluesky", "bootstrap",
				"casablanca", "cruze", "cupertino", "dark-hive", "delta", "dot-luv", "eggplant", "excite-bike", "flick",
				"glass-x", "home", "hot-sneaks", "humanity", "le-frog", "midnight", "mint-choc", "overcast",
				"pepper-grinder", "redmond", "rocket", "sam", "smoothness", "south-street", "start", "sunny",
				"swanky-purse", "trontastic", "ui-darkness", "ui-lightness", "vader");
	}

	public String getTema() {
		return tema;
	}

}
