// Se indica el paquete donde se encuentra esta clase
package ejemplo.bo;

// Se importa la clase Color para poder resaltar cosas
// en la ventana que se muestra para animar el código
import java.awt.Color;
// Se importa la clase Random para números aleatorios
import java.util.Random;

// Se importa la clase JOptionPane para mostrar mensajes
import javax.swing.JOptionPane;

// Se importa la clase Ventana que se encuentra dentro de este proyecto,
// pero dentro de otro paquete
import ejemplo.ui.Ventana;

/**
 * 
 * Esta es la clase Vector que solamente se utiliza para llamar a los métodos
 * que van a poner visualizaciones de vectores o arrays en pequeñas ventanas con
 * distintos tipos de datos.
 * 
 * @author Rubén Jiménez Goñi
 */
public class Animador {

	/**
	 * Se define un objeto de la clase Random como atributo
	 */
	private Random rand;

	/**
	 * Constructor por defecto de la clase Animador
	 * 
	 * Inicializa el atributo rand
	 */
	public Animador() {
		// Se inicializa el atributo rand con un objeto Random
		rand = new Random();
	}

	/**
	 * Este método crea un objeto Ventana y un vector de enteros, posteriormente
	 * recorre el vector de distintas formas que se visualizan en la ventana.
	 */
	public void ejemploVectorInt() {

		// Objeto Random para valores aleatorios
		Random r = new Random();

		// v es una variable de tipo vector, arreglo o array
		// que contiene 5 valores int
		//
		// Visualmente sería algo así
		//
		// {__?,___?,___?,___?,__?} <-- "Estructura" de datos
		// v[0] v[1] v[2] v[3] v[4] <-- Forma de acceder a cada posición
		//
		// Los "_" simbolizan espacios en blanco
		// Los "?" simbolizan que puede haber cualquier número
		//
		// El vector se recorre con índices que van desde
		// 0 hasta n - 1, donde n es el tamaño del vector
		//
		// Al declarar la variable, los "[]"
		// simbolizan que se declara un vector
		//
		// Al inicializar la variable, se pone new,
		// el tipo de dato correspondiente
		// y dentro de los corchetes el tamaño que
		// se le quiere dar al vector. Tiene que ser
		// un número entero
		//
		int v[] = new int[5];

		// v es un objeto de tipo de dato "int[]"
		// que tiene un atributo público length
		// (todos los vectores, sin importar de que sean, lo tienen)
		// que se puede acceder en cualquier momento
		for (int i = 0; i < v.length; i++) {

			// Se coloca en la posición i del vector v
			// un número aleatorio
			v[i] = r.nextInt(100);
		}

		// Se imprimen los valores del vector
		for (int i = 0; i < v.length; i++) {
			System.out.print("En la posicion " + i);
			System.out.println(" se encuentra " + v[i]);
		}

		// Se crea un objeto Ventana donde se muestra la animación
		// Al crear la ventana, se manda v como parámetro.
		// De esta forma la ventana copia los datos del vector
		Ventana ventana = new Ventana(v);
		ventana.esperar();

		// Se recorre el vector con un for desde 0 hasta 4 de 1 en 1
		for (int i = 0; i < v.length; i++) {
			// Se resalta en verde la posición i
			ventana.resaltar(0, i, Color.GREEN);
		}

		// Se recorre el vector con un for desde 4 hasta 0 de 1 en 1
		for (int i = v.length - 1; i >= 0; i--) {
			// Se resalta en verde la posición i
			ventana.resaltar(0, i, Color.RED);
		}

		// Se recorre el vector con un for desde 0 hasta 4 de 2 en 2
		for (int i = 0; i < v.length; i += 2) {
			// Se resalta en verde la posición i
			ventana.resaltar(0, i, Color.GREEN);
		}

		// Se recorre el vector con un for desde 4 hasta 0 de 2 en 2
		for (int i = v.length - 1; i >= 0; i -= 2) {
			// Se resalta en verde la posición i
			ventana.resaltar(0, i, Color.RED);
		}

		/*
		 * El siguiente código ordena el vector! Se utiliza el algoritmo de
		 * selección
		 * 
		 * El for externo recorre cada posición i del vector, mientras que el
		 * for interno recorre todo lo que queda del vector hacia la derecha,
		 * buscando el elemento mínimo entre i y n - 1. El elemento mínimo se
		 * intercambia con i.
		 * 
		 * No se revisa nunca entre 0 y i - 1, porque la parte izquierda del
		 * vector siempre se encuentra ordenada.
		 */

		for (int i = 0; i < v.length; i++) { // For Externo

			// Se marca en Azul la posición i actual
			ventana.marcar(0, i, Color.BLUE);

			// Se asume que la posición i es la que contiene el valor
			// mínimo del subrando del vector comprendido entre
			// i y n - 1
			int posMinima = i;

			// Se recorre con un for interno la porción a la derecha
			// de la posición i
			for (int j = i + 1; j < v.length; j++) { // For Interno

				// Se resalta en Verde la posición j actual
				ventana.resaltar(0, j, Color.GREEN);

				// Si la posición j contiene un elemento menor que el
				// elmento en posMinima
				if (v[posMinima] > v[j]) {

					// Se toma j como la posición mínima del vector
					posMinima = j;
				}

			} // Fin For Interno

			// Se desmarca la posición actual
			ventana.desmarcar(0, i);

			// Se marca la posición i y la posición con el elemento mínimo en
			// celeste
			// Nótese que en ninguna parte se dice que tienen que ser posiciones
			// distintas
			ventana.marcar(0, i, Color.CYAN);
			ventana.marcar(0, posMinima, Color.CYAN);

			// Se espera un tiempo antes de hacer el cambio en la ventana
			ventana.esperar();

			// Se hace un swap de la posición i y la posición posMinima
			int tmp = v[i]; // Se guarda el valor que se encuentra en i
			v[i] = v[posMinima];
			v[posMinima] = tmp;

			// Si no se utilizara la variable auxiliar tmp, no se podría
			// hacer el swap sin perder el valor en la posición i

			// Se copian los datos de nuevo a la interfaz
			ventana.visualizarVector(v);

			// Se espera un tiempo antes de seguir con el algoritmo
			ventana.esperar();

			// Se desmarcan las posiciones antes de la próxima iteración
			ventana.desmarcar(0, i);
			ventana.desmarcar(0, posMinima);

		} // Fin For Externo

		// Se muestra un mensaje antes de que se cierre la ventana
		JOptionPane.showMessageDialog(ventana,
				"Cuando haga click en Ok la ventana se va a cerrar.\nArrastre esta ventana para observar mejor el resultado", null,
				JOptionPane.WARNING_MESSAGE);

		// Se elimina la ventana
		ventana.dispose();

	}

	/**
	 * Se crea un vector de doubles y se visualiza en la ventana
	 */
	public void ejemploVectorDouble() {

		// Se crea un vector con un tamaño en el rango [2,4[
		double v[] = new double[2 + rand.nextInt(2)];

		// Se crea la ventana para visualizar el vector
		Ventana ventana = new Ventana(v);

		// Se generan datos aleatorios para las posiciones del vector
		for (int i = 0; i < v.length; i++) {
			v[i] = rand.nextDouble();
		}

		// Se visualiza el vector en pantalla
		ventana.visualizarVector(v);

		// Se muestra un mensaje antes de que se cierre la ventana
		JOptionPane.showMessageDialog(ventana,
				"Cuando haga click en Ok la ventana se va a cerrar.\nArrastre esta ventana para observar mejor el resultado", null,
				JOptionPane.WARNING_MESSAGE);

		// Se elimina la ventana
		ventana.dispose();

	}

	/**
	 * Se crea un vector de personas y se muestra en pantalla
	 */
	public void ejemploVectorPersona() {

		// Se crea un vector con un tamaño en el rango [2,4[
		Persona personas[] = new Persona[2 + rand.nextInt(2)];

		// Cuando se crean vectores, todos los campos se inician con
		// valores por defecto!!!!!

		// El valor por defecto de los objetos es null!!!!!

		// Se crea un vecto para escoger nombres aleatorios
		String nombres[] = { "Juan", "Agustino", "Carolina", "Fulgencio",
				"Picaporte" };

		// Se crea una ventana para visualizar el vector
		Ventana ventana = new Ventana(personas);

		// Se crean personas con nombres aleatorias
		for (int i = 0; i < personas.length; i++) {

			// Se crea un nuevo objeto persona para la posción i
			// del vector
			personas[i] = new Persona(i, nombres[rand.nextInt(nombres.length)]);

			// El nombre se escoge como un valor aleatorio dentro del vector de
			// nombres!
		}

		// Se copian los datos a la ventana
		ventana.visualizarVector(personas);

		// Se muestra un mensaje antes de que se cierre la ventana
		JOptionPane.showMessageDialog(ventana,
				"Cuando haga click en Ok la ventana se va a cerrar.\nArrastre esta ventana para observar mejor el resultado", null,
				JOptionPane.WARNING_MESSAGE);

		// Se elimina la ventana
		ventana.dispose();

	}

}
