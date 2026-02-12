package classes;
public class User {
	private String username;
	private String name;
	private String nif;
	private String email;
	private String address;
	private String birthdate;
	private String role;
	// Constructor que recibe todos los parámetros
	public User(String username, String name, String nif, String email, String address, String birthdate, String role) {
		this.username = username;
		this.name = name;
		this.nif = nif;
		this.email = email;
		this.address = address;
		this.birthdate = birthdate;
		this.role = role;
	}
	// Getters y Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
	    this.nif = nif;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
	    this.role = role;
	}
	// Método para mostrar la información del usuario (Lo he añadido yo para que sea menos codigo en el main)
	public void showinfo() {
		System.out.println("Usuario: " + username);
		System.out.println("Nombre: " + name);
		System.out.println("NIF: " + nif);
		System.out.println("Email: " + email);
		System.out.println("Dirección: " + address);
		System.out.println("Fecha de nacimiento: " + birthdate);
		System.out.println("Rol: " + role);
	}
}