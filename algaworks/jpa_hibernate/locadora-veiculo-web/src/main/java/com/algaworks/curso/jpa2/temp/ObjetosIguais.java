package com.algaworks.curso.jpa2.temp;

import com.algaworks.curso.jpa2.modelo.Fabricante;

//a importancia do hashCode e equals para o nosso projeto
public class ObjetosIguais {

	public static void main(String[] args) {

		// de acordo com o nosso sistema, um objeto eh igual a outro objeto
		// se estes objetos tiverem o mesmo codigo de chave primaria

		// com a implementação padrao do metodos acima
		// eles verificam se os objetos tem a mesma referencia na memoria

		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);

		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);

		// deste modo eles nao sao iguais, certo
		System.out.println(f1.equals(f2));

		// mas se os codigos forem iguais
		f1.setCodigo(1L);
		f2.setCodigo(1L);

		// deste modo eles tambem nao sao iguais, errado de acordo com o
		// nosso projeto, pois se o fabricante tiver o mesmo codigo
		// que outro fabricante, quer dizer que eles sao iguais
		System.out.println(f1.equals(f2));

		// para implementar a igualdade dos objetos
		// podemos setar o hashCode e equals com base no codigo, a chave
		// primaria do objeto

		// com a sobrescrita dos metodos com base no codigo
		//os objetos agora sao igauis
		f1.setCodigo(1L);
		f2.setCodigo(1L);
		System.out.println(f1.equals(f2));

	}

}
