package br.com.cocodonto.modelo.dao.teste;

import br.com.cocodonto.framework.dao.CreateDAOException;
import br.com.cocodonto.modelo.dao.PacienteDAO;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDAOTest {
	
	public static void main(String[] args) throws CreateDAOException {
		
		Paciente paciente = new Paciente("Lucas", "3168227", "0448828554", SexoType.M);
		PacienteDAO dao = new PacienteDAO();
		
		dao.inserir(paciente);
		
	}

}
