package utils;

import java.util.Scanner;

public class Utils {
	static Scanner entrada = new Scanner(System.in);

	// LER A ENTRADA DE DADOS NO CONSOLE
	static public String lerEntrada(String texto) {
		System.out.print(texto);
		String textoDigitado = entrada.nextLine();
		return textoDigitado;
	}

	public void fechaConsole() {
		entrada.close();
	}
}