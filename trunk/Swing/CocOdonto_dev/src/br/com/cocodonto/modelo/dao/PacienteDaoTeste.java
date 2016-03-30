package br.com.cocodonto.modelo.dao;

import br.com.cocodonto.frameworkdao.CreateDaoException;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDaoTeste {

	public static void main(String[] args) throws CreateDaoException {

		Paciente paciente = new Paciente("Douglas", "3148567", "2118289100", SexoType.M);		
		Endereco endereco = new Endereco("Qr12 casa 15", "Planaltina de Goiais", "Itapua", "73754012");
		
		paciente.setEndereco(endereco);
		
		PacienteDao dao = new PacienteDao();
		
		dao.inserir(paciente);
		
		System.out.println("Inseriu");

	}

}
