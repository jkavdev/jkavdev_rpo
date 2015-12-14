package controller;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Soma {

	@Inject
	private Somador somador;

	public int retorna() {
		return somador.soma(2);
	}

	public Somador getSomador() {
		return somador;
	}

	public void setSomador(Somador somador) {
		this.somador = somador;
	}

	// @PostConstruct
	// public void main(){
	// System.out.println("Iniciou");
	// }

}
