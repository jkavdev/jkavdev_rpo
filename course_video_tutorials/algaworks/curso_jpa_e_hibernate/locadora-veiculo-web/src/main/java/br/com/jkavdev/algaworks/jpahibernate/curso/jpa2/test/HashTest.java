package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.test;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;

public class HashTest {

	public static void main(String[] args) {

		Fabricante fabricante = new Fabricante();
		fabricante.setCodigo(2L);

		Fabricante fabricante2 = new Fabricante();
		fabricante2.setCodigo(2L);

		// no nosso caso objetos com mesmo id, indicam que sao o mesmo registro
		// nesta caso resultará em false pois o hashCode está implementado
		// sobre a posição de memoria do objeto
		System.out.println("Fabricante iguais : " + fabricante.equals(fabricante2));

		fabricante = new Fabricante();
		fabricante.setCodigo(2L);

		fabricante2 = new Fabricante();
		fabricante2.setCodigo(1L);
		
		System.out.println("Fabricante 1: " + fabricante.getCodigo());
		System.out.println("Fabricante 2: " + fabricante2.getCodigo());
		System.out.println("Fabricante iguais : " + fabricante.equals(fabricante2));

	}

}
