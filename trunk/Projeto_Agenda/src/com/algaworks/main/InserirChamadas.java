package com.algaworks.main;

import java.util.Calendar;

import com.algaworks.dao.AgendaDAO;
import com.algaworks.modelo.Agenda;

public class InserirChamadas {

	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		agenda.setNome("Jhonatan");
		agenda.setTelefone("99346554");
		agenda.setDataRegistro(Calendar.getInstance().getTime());

		 AgendaDAO dao = new AgendaDAO();
		 dao.inserirRegistro(agenda);

	}

}
