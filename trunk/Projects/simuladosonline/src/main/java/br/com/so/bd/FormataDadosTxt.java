package br.com.so.bd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.so.modelo.Banca;
import br.com.so.util.jpa.JpaUtil;

public class FormataDadosTxt {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream arquivo = new FileInputStream("cargodados.txt");
			InputStreamReader reader = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(reader);
			String linha = br.readLine();
			List<String> lista = new ArrayList<>();
			while (linha != null) {
				linha = linha.trim();
				if (!lista.contains(linha)) {
					lista.add(linha);
				}
				System.out.println(linha);
				linha = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
