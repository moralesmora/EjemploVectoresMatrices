
// Se indica el paquete donde se encuentra esta clase
package ejemplo.main;

// Se importa la clase Vector que se encuentra dentro
// de este proyecto, pero en otro paquete.
import ejemplo.bo.Vector;


/**
 * 
 * Esta es la clase Main que contiene el punto de entrada de la aplicación
 * 
 * @author Rubén Jiménez Goñi
 */
public class Main {

	/**
	 * Punto de entrada de la aplicación
	 * 
	 * @param args
	 *            Argumentos que vienen fuera del programa
	 */
	public static void main(String[] args) {

		// Se crea un objeto de la clase Vector
		// de nuestro proyecto
		Vector v = new Vector();

		// ========================================================
		// == Ejemplos ============================================
		// ========================================================
		
		/*
		 * NOTA: Comente o descomente líneas de código, 
		 * según necesite
		 */
		
		// Se corren los ejemplos de vectores de int
		// v.ejemploVectorInt();

		// Se corren los ejemplos de vectores de double
		// v.ejemploVectorDouble();
		
		// Se corren los ejemplos de vectores de Persona
		v.ejemploVectorPersona();
	}

}
