package classes;
public class Main {
	private static final Session session = new Session();
	private static final Maze maze = new Maze(); //CREO EL OBJETO MAZE
	public static void main(String[] args) {
	System.out.println(Config.WELCOME);
	int option;
	do {
		if (!session.isLogged()) {
		System.out.print(Config.UNLOGGED_MENU);
		option = input.getInt();
			if (option == 1) {
				session.login();
			} else if (option == 2) {
               	input.toContinue();
				session.signup();
			} else if (option == 0) {
				System.out.println(Config.GOODBYE);
			} else {
				System.out.println("La opción introducida no es válida \n");
			}
		} else {
					
               System.out.print(Config.LOGGED_MENU);
               option = input.getInt();
               if (option == 1) {
                input.toContinue();
               	maze.loadMaze();
               } else if (option == 2) {
               	maze.showMaze();
               } else if (option == 3) {
               	maze.setStartEnd();
               } else if (option == 4) {
               	System.out.println("Próximamente...");
               } else if (option == 5) {
                input.toContinue();
               	session.showUser();
               } else if (option == 6) {
                input.toContinue();
               	session.logout();
               	maze.reset(); // CUANDO SE CIERRE SESIÓN SE BORRARÁN LOS CAMBIOS
               } else if (option == 0) {
               	System.out.println(Config.GOODBYE);
               } else {
               	System.out.println("La opción introducida no es válida");
               }
           }
       } while (option != 0);
	}
}