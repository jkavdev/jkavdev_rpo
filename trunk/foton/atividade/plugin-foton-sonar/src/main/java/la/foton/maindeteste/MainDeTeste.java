package la.foton.maindeteste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import la.foton.modelo.Metodo;

import org.sonar.wsclient.Sonar;
import org.sonar.wsclient.services.Resource;
import org.sonar.wsclient.services.ResourceQuery;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainDeTeste {

	public static void main(String[] args) {
		ArrayList<Metodo> metodos = new ArrayList<Metodo>();
		Type listType = new TypeToken<ArrayList<Metodo>>() {}.getType();
		
//		Gson gson = new Gson();
//		Metodo m = new Metodo("C:teste/caminho/metodo", 10);
//		Metodo m2 = new Metodo("C:teste/caminho/metodo2", 55);
//		
//		metodos.add(m);
//		metodos.add(m2);
//		
//		String conteudo = gson.toJson(metodos);
//		
//		try {
//			//write converted json data to a file named "file.json"
//			FileWriter writer = new FileWriter("c:\\file.json");
//			writer.write(conteudo);
//			writer.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		
//		
//		System.out.println(metodos);
		
		Gson gson = new Gson();
		
		try {

			BufferedReader br = new BufferedReader(
				new FileReader("c:\\file.json"));

			//convert the json string back to object
			ArrayList<Metodo> objs = gson.fromJson(br, listType);

			System.out.println(objs);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
