package com.algaworks.curso.jpa2.temp;

import com.algaworks.curso.jpa2.modelo.Fabricante;

// 

public class ObjetosIguais {

	public static void main(String[] args) {
		
		//no nosso sistema dois registros sao iguais se sua chave primaria forem iguais
		//pois nao se pode duplicar a chave primaria
		
		//no caso do java, por padrao o metodo de indentificacao dos objetos
		//ja vem implementado verificando a referencia de memoria daquele objeto 
		//instanciado
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);
		
		//neste caso esta correto, os dois fabricantes nao
		//sao iguais pois seus codigos sao diferentes
		System.out.println("f1.equals(f2) " + f1.equals(f2));
		
		f1.setCodigo(1L);
		f2.setCodigo(1L);

		//neste caso ja acontece ao contrario
		//as duas instancias tem o codigo igual 
		//mas nao sao o mesmo fabricante
		//de acordo com o nosso sistema se o fabricante tem o mesmo id que outro fabricante 
		//quer dizer que eles sao iguais
		System.out.println("f1.equals(f2) " + f1.equals(f2));
		
		//por padrao o java compara a referencia de 
		//memoria destes objetos
		//neste caso eles sao iguais nem importa se os fabricantes tem ou nao o mesmo
		//codigo
		f1.setCodigo(3L);
		f1 = f2;
		f2.setCodigo(4L);
		System.out.println("f1.equals(f2) " + f1.equals(f2));
		
		//para alterarmos isso
		//podemos sobrescrever os metodos hash e equals
		//com base no codigo

	}

}
