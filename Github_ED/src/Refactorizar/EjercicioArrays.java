package Refactorizar;
import java.util.Arrays;
import java.util.List;

public class EjercicioArrays {
    
    public static void main(String[] args) {
        int numAlumnos = 40;
        //vector con las notas generadas
        Integer[] control = new Integer[numAlumnos];
		int[] listaClase;
		int[] practicas;
		float[] calificaciones;
		float[] estadistica;
		int[] aprobados;
		int[] suspensos;
        int maxNota = 0;
        int minNota = 0;
        int indMaxNota, indMinNota;
        int postEval;
		double[] calif;
		
        //Genera notas random entre 1 y 10
		for(int i=0; i < control.length; i++){
            control[i]=(int)(Math.random()*11);
            int preEval = control[i];
            if(preEval < minNota) {
            	minNota = preEval;
                postEval = control[i];
            }
            if(preEval > maxNota) {
            	maxNota = preEval;
                postEval = control[i];
            }
        }

		listaClase = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++){
            listaClase[i] = i+1;
        }
        //Empezamos el uso de listas para facilitar la tarea de índices.
        List notas = Arrays.asList(control);
        indMinNota = notas.indexOf(minNota) + 1;
        indMaxNota = notas.indexOf(maxNota) + 1;

        //Comprobamos el resultado del ejercicio   
        System.out.println("Mínimo: " + minNota + "\nMaximo: " + maxNota);
        System.out.println("Indice del mínimo: " + indMinNota + "\nIndice del máximo: " + indMaxNota);
        System.out.println("Lista de clase :" + Arrays.toString(listaClase));
        System.out.println("Array de Notas :" + notas);
        
        //creamos el array de notas "practicas"
        practicas = new int[numAlumnos];
        calificaciones = new float[numAlumnos];
        for(int i=0; i < practicas.length; i++){
            practicas[i] = (int)(Math.random()*11);
        }
        for(int i = 0; i<control.length; i++){
            calificaciones[i] = 
                    (((float) control[i] 
                    + (float) practicas[i]) 
                    / 2);
        }
        System.out.println("Prácticas: " + Arrays.toString(practicas) + "Calificaciones: " + Arrays.toString(calificaciones));

        //Sacamos la estadística de calificaciones
        //hacemos un array de 10 para la estadística.
        estadistica = new float[10];
        
        for (int i=0; i<calificaciones.length; i++){
            int count = (int) calificaciones[i];
            if(count >= 10) {
            	count = 9;
            } else if(count < 0) {
            	count = 0;
            }
            estadistica[count]++;
        }
        for(int i = 0; i < 10; i++) {
        	float porcentaje = (estadistica[i] / numAlumnos) *100;
        	double sol = (Math.round(porcentaje*100))/100;
        	System.out.println("Estadística nota tramo <=" 
                    + (i+1) + " = " 
                    + sol + "%");
        }

        //Aprobados y suspensos
        aprobados = new int[numAlumnos];
        suspensos = new int[numAlumnos];

        int[] a = new int[numAlumnos];
        int[] s = new int[numAlumnos];

        int x = 0;
        int y = 0;

        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] < 5) {
                aprobados[i] = i;
                if (i != 0) { 
                	a[x] = i; 
                	x++; 
                } 
            } else {
                suspensos[i] = i;
                if (i != 0) { 
                	s[y] = i; 
                	y++; 
                }
            }
        }
        System.out.println("Relación de aprobados: " + Arrays.toString(aprobados));
        System.out.println("Relación de suspensos: " + Arrays.toString(suspensos));
        System.out.println("Resumen de aprobados: " + Arrays.toString(Arrays.copyOf(a, x)));
        System.out.println("Resumen de suspensos: " + Arrays.toString(Arrays.copyOf(s, y)));

    
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        calif = new double[40];
        for (int j=0; j<31; j++){
            calif[j] = (int)(Math.random()*11);
        }
        System.out.println("Nota antigua alumno nº4: " + calif[3]); 
        calif[3] = 6;
        System.out.println("Nota nueva   alumno nº4: " + calif[3]);
    }
}

