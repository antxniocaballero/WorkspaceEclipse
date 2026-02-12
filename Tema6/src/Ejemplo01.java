public class Ejemplo01 {
	public static void main(String[] args) {
		// Ejemplo con el método concat
		String nombre = "David";
		String apellido = "Munuera";
		
		System.out.println("Nombre completo:");
		System.out.println(nombre.concat(" ").concat(apellido));
		
		System.out.println("\nDe la forma tradicional con el operador +");
		System.out.println(nombre + " " + apellido);
	}
}
