package com.algaworks.curso.jpa2.temp;

import com.algaworks.curso.jpa2.modelo.Fabricante;

public class ObjetosIguais {
	
	public static void main(String[] args) {
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);
		//deste modo os fabricantes nao sao iguais 
		System.out.println("f1.equals(f1) ? " + f1.equals(f2));
		
		f1.setCodigo(1L);
		f2.setCodigo(1L);
		
		//deste modo os fabricantes tambem nao sao iguais
		//de acordo com o nosso sistema quando um objeto tem o mesmo 
		//codigo que outro objeto, esses objetos sao iguais
		System.out.println("f1.equals(f1) ? " + f1.equals(f2));
		

		//isso acontece pois o hashCode e equals estao sendo gerados por padrao
		//no qual eles comparam o endereco de memoria e nao o codigo da chave primaria
		f1 = f2;
		System.out.println("f1.equals(f1) ? " + f1.equals(f2));
		
		//para resolvermos isso, precisaremos gerar o hashCode and equals com base na chave 
		//primaria da entidade

		
	}

}
