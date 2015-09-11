// Se indica el paquete donde se encuentra esta clase
package ejemplo.ui;

// Imports de la librería awt
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
//Imports de la librería Swing
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Esta clase es una ventana de Java Swing que sirve para hacer animaciones de
 * vectores o matrices y contiene métodos para facilitar eso
 * 
 * @author Rubén Jiménez Goñi
 */
public class Ventana extends JFrame {

	// Esto tiene que ver con serializar y deserializar objetos
	// No es parte del curso!
	private static final long serialVersionUID = 1L;

	/**
	 * Esta variable, mejor conocida como constante, define el tiempo de espera
	 * de la simulación. Representa una cantidad de milisegundos
	 */
	private static final int ESPERA = 500;

	/**
	 * Esta matriz contiene los botones que se despliegan en el panel durante la
	 * animación
	 */
	private JPanel panel[][];
	private JLabel label[][];

	/**
	 * Este constructor permite crear una ventana que despliega un vector de
	 * enteros
	 * 
	 * @param v
	 *            Vector de enteros a desplegar
	 */
	public Ventana(int[] v) {
		this.init(1, v.length);
		this.visualizarVector(v);
	}

	/**
	 * Este constructor permite crear una ventana que despliega un vector de
	 * doubles
	 * 
	 * @param v
	 *            Vector de doubles a desplegar
	 */
	public Ventana(double[] v) {
		this.init(1, v.length);
		this.visualizarVector(v);
	}

	/**
	 * Este constructor permite crear una ventana que despliega cualquier vector
	 * de objetos
	 * 
	 * @param v
	 *            Vector de objetos a desplegar
	 */
	public <T> Ventana(T v[]) {
		this.init(1, v.length);
	}

	/**
	 * Este método crea una ventana de f x c e inicializa el atributo de botones
	 * 
	 * La ventana creada tiene botones sin texto y con blanco como color de
	 * fondo
	 * 
	 * @param f
	 *            Cantidad de filas de la ventana a crear
	 * @param c
	 *            Cantidad de columnas de la ventana a crear
	 */
	private void init(int f, int c) {

		// Se pone el tamaño en formato
		// Ancho x Alto
		this.setSize(c * 200, f * 200);

		// Se asigna el layout de la ventana
		this.setLayout(new GridLayout(f, c));

		// Se crea la matriz de paneles y de labels
		panel = new JPanel[f][c];
		label = new JLabel[f][c];

		// Se recorre la matriz
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {

				// Se crea cada panel y label
				panel[i][j] = new JPanel();
				label[i][j] = new JLabel();

				// El BorderLayout permite que el JLabel 
				// quede en el centro del panel verticalmente
				panel[i][j].setLayout(new BorderLayout());

				// Se asigna la fuente y el color de texto de cada label
				label[i][j].setFont(new Font("Sans Serif", Font.BOLD, 30));
				label[i][j].setForeground(Color.BLACK);

				// Se centra el texto de cada label horizontalmente
				label[i][j].setHorizontalAlignment(SwingConstants.CENTER);

				// Se asigna el color de cada panel
				panel[i][j].setBackground(Color.WHITE);

				// Se añade un borde a cada panel
				panel[i][j].setBorder(BorderFactory
						.createLineBorder(Color.BLACK));

				// Se añade el label al panel
				panel[i][j].add(label[i][j]);

				// Se añade cada panel a la ventana
				this.add(panel[i][j], i, j);
			}
		}

		// Se añade un borde al panel principal que contiene todo
		((JPanel) this.getContentPane()).setBorder(BorderFactory
				.createLineBorder(Color.BLACK));

		// Se visibiliza la ventana
		this.setVisible(true);
	}

	/**
	 * Este método permite visualizar un vector de enteros en la ventana
	 * @param v Vector de enteros a visualizar
	 */
	public void visualizarVector(int v[]) {
		for (int i = 0; i < v.length; i++) {
			this.changeText(0, i, "" + v[i]);
		}
		this.repaint();
	}

	/**
	 * Este método permite visualizar un vector de doubles en la ventana
	 * @param v Vector de doubles a visualizar
	 */
	public void visualizarVector(double v[]) {
		for (int i = 0; i < v.length; i++) {
			this.changeText(0, i, "" + v[i]);
		}
		this.repaint();
	}

	/**
	 * Este método permite visualizar cualquier vector de objetos en la ventana
	 * @param v Vector de objetos a visualizar
	 */
	public <T> void visualizarVector(T v[]) {
		for (int i = 0; i < v.length; i++) {
			this.changeText(0, i, v[i].toString());
		}
		this.repaint();
	}

	/**
	 * Este método permite cambiar el texto de una posición de la ventana
	 * @param i Fila
	 * @param j Columna
	 * @param text Texto a escribir en la posición i, j
	 */
	public void changeText(int i, int j, String text) {
		label[i][j].setText(text);
		this.repaint();
	}

	/**
	 * Este método permite resaltar ESPERA ms una celda de la ventana
	 * @param i Fila
	 * @param j Columna
	 * @param c Color a utilizar para resaltar
	 */
	public void resaltar(int i, int j, Color c) {
		panel[i][j].setBackground(c);
		this.repaint();
		esperar();
		panel[i][j].setBackground(Color.WHITE);
		this.repaint();
	}

	/**
	 * Este método permite marcar de un color en específico una celda de la ventana
	 * @param i Fila
	 * @param j Columna
	 * @param c Color a utilizar para marcar
	 */
	public void marcar(int i, int j, Color c) {
		panel[i][j].setBackground(c);
		this.repaint();
	}

	/**
	 * Este método permite desmarcar una celda de la ventana
	 * @param i Fila 
	 * @param j Columna
	 */
	public void desmarcar(int i, int j) {
		panel[i][j].setBackground(Color.WHITE);
		this.repaint();
	}

	/**
	 * Este método "pausa" la ejecución del programa ESPERA ms
	 * 
	 * Lo que hace es devolver el control al sistema operativo, mientras pasa el tiempo.
	 */
	public void esperar() {
		// Esta es una estructura llamada try catch que se ve más adelante en el curso
		try {
			Thread.sleep(ESPERA);
		} catch (InterruptedException e) {
		}
	}

}
