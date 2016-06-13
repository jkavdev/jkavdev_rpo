package br.com.jkavdev.samples.observer.aniversario;

public class Namorada implements ChegadaAniversarianteObserver {

	@Override
	public void chegou(ChegadaAniversarianteEvent event) {
		System.out.println("Apagar as Luzes");
		System.out.println("Fazer Silencio");
		System.out.println("Supresa");
	}

}
