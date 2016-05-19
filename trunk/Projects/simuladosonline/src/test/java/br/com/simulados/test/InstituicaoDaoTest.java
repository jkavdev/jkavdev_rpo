package br.com.simulados.test;

import br.com.so.dao.InstituicaoDao;
import br.com.so.modelo.Instituicao;

public class InstituicaoDaoTest {

	public static void main(String[] args) {

		InstituicaoDao daoInstituicao = new InstituicaoDao();
		Instituicao instituicao = new Instituicao();
		instituicao.setNome("STJ");

		try {
			daoInstituicao.adiciona(instituicao);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Nice");

	}

}
