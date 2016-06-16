package br.com.so.dao.interfacesDao;

import java.util.List;

import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;

public interface IQuestaoDao extends GenericDao<Questao, Long> {

	public List<Questao> getQuestoesByProva(Prova prova);

}
