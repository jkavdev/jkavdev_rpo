package br.com.jkavdev.samples.observer.aniversario;

import java.util.Date;

public class ChegadaAniversarianteEvent {

	private final Date horaDaChegada;

	public ChegadaAniversarianteEvent(Date horaDaChegada) {
		this.horaDaChegada = horaDaChegada;
	}

	public Date getHoraDaChegada() {
		return horaDaChegada;
	}

}
