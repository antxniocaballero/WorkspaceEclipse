import java.util.Scanner;

public class Ejemplo02 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método getChars
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		
		System.out.println("Obtener subcadena de la frase anterior");
		System.out.print("Indica el índice del principio: ");
		int inicio = Integer.parseInt(teclado.nextLine().trim());
		System.out.print("Indica el índice del final: ");
		int fin = Integer.parseInt(teclado.nextLine().trim());
		
		char[] caracteres = new char[fin-inicio];
		// El inicio incluye ese carácter, pero la posición fin no incluye el carácter
		frase.getChars(inicio, fin, caracteres, 0);
		
		System.out.println("Tamaño del array de char: " + caracteres.length);
		for(int i = 0; i < caracteres.length; i++) {
			System.out.println(caracteres[i]);
		}
	}
}
