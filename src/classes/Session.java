package classes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Session {
	private User user;
	private boolean logged;
	// RUTA DEL FICHERO RELATIVA
	private static final String FILE_PATH = "src/files_AC/users.txt";
	public Session() {
		logged = false;
		user = null;
	}
	// LOGIN
	public void login() {
	String username = input.getString("Nombre de usuario: ");
	String password = input.getString("Contraseña: ");
	boolean found = false;
		try (Scanner reader = new Scanner(new File(FILE_PATH))) {
			while (reader.hasNextLine()) {
				String[] data = reader.nextLine().split("#");
				if (data[0].equalsIgnoreCase(username) &&
					data[1].equals(password)) {
					String role = data.length > 7 ? data[7] : "user";
					user = new User(
							data[0],
							data[2],
							data[3],
							data[4],
							data[5],
							data[6],
							role);
					logged = true;
					found = true;
					System.out.println("Sesión iniciada correctamente");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Error al leer el fichero de usuarios");
		}
		if (!found) {
			System.out.println("Usuario y/o contraseña incorrectos");
		}
	}
	// REGISTRO
	public void signup() {
	String username = input.getString("Nombre de usuario: ");
	String password = input.getString("Contraseña: ");
	// COMPROBAR SI EL USUARIO + SU CONTRASEÑA EXISTE
		try (Scanner reader = new Scanner(new File(FILE_PATH))) {
			while (reader.hasNextLine()) {
				String[] data = reader.nextLine().split("#");
				if (data[0].equalsIgnoreCase(username) &&
					data[1].equals(password)) {
					System.out.println("No se ha podido completar el registro ya que los datos ya existen");
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Error al leer el fichero");
			return;
		}
		//PEDIR LOS DATOS MEDIANTE LOS GETS DEL INPUT
		String name = input.getString("Nombre completo: ");
		String nif = input.getString("NIF: ");
		String email = input.getString("Email: ");
		String address = input.getString("Dirección: ");
		String birthdate = input.getString("Fecha de nacimiento: ");
		String role = "user";
		//ESCRIBIR EN EL FICHERO EL USUARIO
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			writer.newLine();
			writer.write(username + "#" + password + "#" + name + "#" +
                        nif + "#" + email + "#" + address + "#" + birthdate + "#" + role);
		} catch (IOException e) {
			System.out.println("Error al guardar el usuario");
			return;
		}
		//UNA VEZ REGISTRADO SE CREA EL USUARIO Y PONEMOS LA SESIÓN EN INICIADA
		user = new User(username, name, nif, email, address, birthdate, role);
		logged = true;
		System.out.println("Registro completado y sesión iniciada con éxito");
	}
	public boolean isLogged() {
		return logged;
	}
	public void showUser() {
		if (user != null) {
			user.showinfo();
		}
	}
	public void logout() {
		user = null;
		logged = false;
		System.out.println("Sesión cerrada correctamente");
	}
}