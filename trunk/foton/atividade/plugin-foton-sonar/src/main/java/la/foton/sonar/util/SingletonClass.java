package la.foton.sonar.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import la.foton.modelo.Metodo;

public class SingletonClass {
	private static SingletonClass singletonObject;
	private static List<Metodo> metodos;
	
	/** A private Constructor prevents any other class from instantiating. */
	private SingletonClass() {
	}
	
	public static List<Metodo> getMetodos() {
		return metodos;
	}
	public static synchronized SingletonClass getSingletonObject() {
		if (singletonObject == null) {
			singletonObject = new SingletonClass();
		}
		return singletonObject;
	}
	
	public static void  addValue(Metodo metodo) {
		if(metodos == null){
			metodos = new ArrayList<Metodo>();
		}
		metodos.add(metodo);
	}

	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
