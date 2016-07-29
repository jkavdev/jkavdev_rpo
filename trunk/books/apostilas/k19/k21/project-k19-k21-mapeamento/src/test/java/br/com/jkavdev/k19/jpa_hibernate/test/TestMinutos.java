package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

public class TestMinutos {
	
	@Test
	public void testMinutos() {

		int minutos, hora = 0;
		boolean parar = false;

		minutos = 378;

		while (parar != true) {
			if (minutos >= 60) {
				minutos -= 60;
				hora += 1;
			} else {
				parar = true;
			}
		}
		
		System.out.println(minutos);
		System.out.println(hora);

	}

}
