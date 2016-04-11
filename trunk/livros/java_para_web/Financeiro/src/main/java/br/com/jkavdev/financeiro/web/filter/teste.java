package br.com.jkavdev.financeiro.web.filter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class teste {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext context = new InitialContext();
		
		DataSource lookup = (DataSource) context.lookup("java:/comp/env/financeiroDataSource");
		
		System.out.println("Conectou");
		
	}

}
