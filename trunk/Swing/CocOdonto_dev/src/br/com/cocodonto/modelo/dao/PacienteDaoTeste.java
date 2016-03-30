package br.com.cocodonto.modelo.dao;

import br.com.cocodonto.frameworkdao.CreateDaoException;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDaoTeste {

	public static void main(String[] args) throws CreateDaoException {

		Paciente paciente = new Paciente("Lucas", "3148437", "2258289100", SexoType.M);
		PacienteDao dao = new PacienteDao();
		
		dao.inserir(paciente);
		
		System.out.println("Inseriu");

	}

}
