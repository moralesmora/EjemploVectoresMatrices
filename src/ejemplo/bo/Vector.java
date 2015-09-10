package ejemplo.bo;

import java.awt.Color;
import java.util.Random;

import ejemplo.ui.Ventana;

public class Vector {

	public void ejemploVectorInt() {

		// Objeto Random para valores aleatorios
		Random r = new Random();

		// v es una variable de tipo vector o array
		// que contiene 5 valores int
		//
		// Visualmente sería algo así
		//
		// { ?, ?, ?, ?, ?}
		// v[0] v[1] v[2] v[3] v[4]
		//
		// El vector se recorre con índices que van desde
		// 0 hasta n - 1, donde n es el tamaño del vector
		int v[] = new int[r.nextInt(5) + 5];

		// v es un objeto de tipo int[]
		// que tiene un atributo público length
		// (todos los vectores lo tienen)
		// que se puede acceder en cualquier momento
		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextInt(100);
		}

		// Se imprimen los valores del vector
		for (int i = 0; i < v.length; i++) {
			System.out.print("En la posicion " + i);
			System.out.println(" se encuentra " + v[i]);
		}

		Ventana ventana = new Ventana(1, v.length);
		ventana.visualizarVector(v);

		for (int i = 0; i < v.length; i++) {
			ventana.resaltar(0, i, Color.GREEN);
		}

		for (int i = v.length - 1; i >= 0; i--) {
			ventana.resaltar(0, i, Color.RED);
		}

		for (int i = 0; i < v.length; i += 2) {
			ventana.resaltar(0, i, Color.GREEN);
		}

		for (int i = v.length - 1; i >= 0; i -= 2) {
			ventana.resaltar(0, i, Color.RED);
		}

		for (int i = 0; i < v.length; i++) {
			
			ventana.marcar(0, i, Color.BLUE);
			int posMinima = i;
			
			for (int j = i + 1; j < v.length; j++) {
				
				ventana.resaltar(0, j, Color.GREEN);
				if(v[posMinima] > v[j]) {
					posMinima = j;
				}
			}
			
			ventana.desmarcar(0, i);
			
			ventana.marcar(0, i, Color.CYAN);
			ventana.marcar(0, posMinima, Color.CYAN);
			ventana.esperar();
			
			int tmp = v[i];
			v[i] = v[posMinima];
			v[posMinima] = tmp;
			
			ventana.visualizarVector(v);
			
			ventana.esperar();
			ventana.desmarcar(0, i);
			ventana.desmarcar(0, i);
			ventana.desmarcar(0, posMinima);
			
		}

	}
	
	public void ejemploVectorDouble() {
		
		Random r = new Random();
		
		double v[] = new double[3];
		Ventana ventana = new Ventana(1, 3);

		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextDouble();
		}

		ventana.visualizarVector(v);
		
	}
	
	public void ejemploVectorPersona() {
		
		Persona personas[] = new Persona[3];
		String nombres[] = {"Juan", "Agustino", "Carolina"};
		Ventana ventana = new Ventana(1, 3);
		
		for (int i = 0; i < personas.length; i++) {
			personas[i] = new Persona(i, nombres[i]);
		}
		
		ventana.visualizarVector(personas);
		
		
	}
	
	

}