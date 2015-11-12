package br.com.cocodonto.modelo.dao;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDAOTest {
	
	public static void main(String[] args) throws CreateDaoException {
		
		Paciente p = new Paciente("Lucas Alves", "35556", "11223", SexoType.M);
		PacienteDAO dao = new PacienteDAO();
		
		dao.inserir(p);
		
	}
}
