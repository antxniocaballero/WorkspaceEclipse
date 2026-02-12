package classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Maze {
    
    // ATRIBUTOS DEL LABERINTO
    private char[][] map;
    private String filename;
    private boolean loaded;
    private int startI, startJ, endI, endJ;
    
    // CONSTRUCTOR CON VALORES POR DEFECTO
    public Maze() {
        this.loaded = false;
        this.startI = -1;
        this.startJ = -1;
        this.endI = -1;
        this.endJ = -1;
    }
    
    //METODO CARGAR EL LABERINTO
    public void loadMaze() {

        File folder = new File("src/mazes");
        
        //AQUÍ CREO UN ARRAY LLAMADO ARCHIVOS DONDE BUSCO EN LA CARPETA TODOS LOS ARCHIVOS QUE ACABEN EN .TXT
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt")); 
        Arrays.sort(files);

        //COMPRUEBO SI LA CARPETA ESTA VACIA O NO TIENE NINGUN ARCHIVO
        if (files == null || files.length == 0) {
            System.out.println("No se ha encontrado ningun laberinto...");
            return;
        }

        System.out.println("------------ Selecciona un laberinto ----------");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + " - " + files[i].getName());
        }
        //Y MUESTRO APARTE LA OPCIÓN DE VOLVER AL MENÚ
        System.out.println("0 - Volver al menú");
        int option = -1;
        
        //CREO UN BUCLE QUE SE REPITA HASTA QUE LA OPCIÓN ESTE DENTRO DEL RANGO
        while (option < 0 || option > files.length) {
            System.out.print("Introduzca una opción -> ");
            option = input.getInt();
        }
        
        if (option == 0) return;

        // GUARDAMOS LINEAS Y COLUMNAS PARA HACER LA MATRIZ CON DICHOS DATOS
        File selectedFile = files[option - 1];
        try {
            List<String> lines = Files.readAllLines(selectedFile.toPath());
            int rows = lines.size();
            int cols = lines.get(0).length();
            map = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                map[i] = lines.get(i).toCharArray();
            }
            
            //EN ESTA VARIABLE SACO EL NOMBRE DEL ARCHIVO Y SI NO DA ERROR LE ASIGNO TRUE
            filename = selectedFile.getName();
            loaded = true;
            System.out.println("Se ha cargado el laberinto " + filename + " exitosamente");

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo...");
        }
    }

    public void showMaze() {
        if (!loaded) {
            System.out.println("ERROR: No hay ningun laberinto cargado...");
            return;
        }
        
        // MOSTRAR LOS NUMEROS DE LAS COLUMNAS
        System.out.print("   ");
        for (int j = 0; j < map[0].length; j++) {
            if (j >= 10) {
                System.out.print((j / 10) + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();

        // MOSTRAR LAS UNIDADES DE LAS COLUMNAS
        System.out.print("   ");
        for (int j = 0; j < map[0].length; j++) {
            System.out.print((j % 10) + " ");
        }
        System.out.println();

        // AQUÍ MUESTRO EL INICIO Y EL FINAL
        for (int i = 0; i < map.length; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < map[i].length; j++) {
                if (i == startI && j == startJ) {
                    System.out.print("I ");
                } else if (i == endI && j == endJ) {
                    System.out.print("F ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    //METODO PARA EL PUNTO DE INICIO Y DE FIN
    public void setStartEnd() {
        if (!loaded) {
            System.out.println("ERROR: No hay ningun laberinto cargado...");
            return;
        }

        // PEDIR LAS COORDENADAS DEL INICIO 
        do {
            System.out.print("Introduzca la fila de inicio (0 - " + (map.length - 1) + ") -> ");
            startI = input.getInt();

            System.out.print("Introduzca la columna de inicio (0 - " + (map[0].length - 1) + ") -> ");
            startJ = input.getInt();

            if (!isValidPosition(startI, startJ)) {
                System.out.println("ERROR: Coordenadas fuera del laberinto");
            } else if (map[startI][startJ] == '#') {
                System.out.println("ERROR: No se puede colocar el inicio en una pared");
            }

        } while (!isValidPosition(startI, startJ) || map[startI][startJ] == '#');

        // PEDIR LAS COORDENADAS DEL FINAL
        do {
            System.out.print("Introduzca la fila de fin (0 - " + (map.length - 1) + ") -> ");
            endI = input.getInt();

            System.out.print("Introduzca la columna de fin (0 - " + (map[0].length - 1) + ") -> ");
            endJ = input.getInt();
            
            if (!isValidPosition(endI, endJ)) {
                System.out.println("ERROR: Coordenadas fuera del laberinto");
            } else if (map[endI][endJ] == '#') {
                System.out.println("ERROR: No se puede colocar el fin en una pared");
            }

        } while (!isValidPosition(endI, endJ) || map[endI][endJ] == '#');

        //ULTIMA COMPROBACION PARA QUE NO SEAN EL MISMO PUNTO
        if (startI == endI && startJ == endJ) {
            System.out.println("ERROR: El inicio y el fin no pueden ser el mismo punto");
            startI = startJ = endI = endJ = -1;
        } else {
            System.out.println("El inicio y el fin han sido establecidos correctamente");
        }
    }

    public boolean isLoaded() {
        return loaded;
    }

    //METODO PARA VOLVER A LOS VALORES INICIALES
    public void reset() {
        loaded = false;
        map = null;
        filename = null;
        startI = startJ = endI = endJ = -1;
    }
    
    // METODO PARA VALIDAR LAS COORDENADAS
    private boolean isValidPosition(int i, int j) {
        return i >= 0 && i < map.length && j >= 0 && j < map[0].length;
    }
}