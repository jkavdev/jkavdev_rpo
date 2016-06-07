package br.com.so.util;

public class AlfabetoUtil {
	private static char[] alfaLetra = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public static String pegaLetra(int posicao){
		return String.valueOf(alfaLetra[posicao]).toUpperCase();
	}

}
