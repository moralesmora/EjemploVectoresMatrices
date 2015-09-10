package ejemplo.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import ejemplo.bo.Persona;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int ESPERA = 1000;
	
	private JButton botones[][];
	
	public <T> Ventana(T v[]) {
		this.init(1, v.length);
	}
	
	public Ventana(int[] v) {
		this.init(1, v.length);
		this.visualizarVector(v);
	}
	
	public Ventana(double[] v) {
		this.init(1, v.length);
		this.visualizarVector(v);
	}
	
	public Ventana(Persona[] v) {
		this.init(1, v.length);
	}

	private void init(int f, int c) {
		
		this.setSize(600, 600);
		
		this.setLayout(new GridLayout(f, c));
		
		botones = new JButton[f][c];
		
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				botones[i][j] = new JButton("");
				botones[i][j].setFont(new Font("Courier New", Font.BOLD, 20));
				botones[i][j].setBackground(Color.WHITE);
				botones[i][j].setEnabled(false);
				this.add(botones[i][j], i, j);
			}
		}
		
		this.setVisible(true);
	}
	
	
	public void visualizarVector(int v[]) {
		for (int i = 0; i < v.length; i++) {
			this.changeText(0, i, "" + v[i]);
		}
	}
	
	public void visualizarVector(double v[]) {
		for (int i = 0; i < v.length; i++) {
			this.changeText(0, i, "" + v[i]);
		}
	}
	
	public void visualizarVector(Persona v[]) {
		for (int i = 0; i < v.length; i++) {
			this.changeText(0, i, v[i].toString());
		}
	}
	
	
	public void changeColor(int i, int j, Color c) {
		botones[i][j].setBackground(c);
		esperar();
	}
	
	public void changeText(int i, int j, String text){
		botones[i][j].setText(text);
	}
	
	public void resaltar(int i, int j, Color c) {
		botones[i][j].setBackground(c);
		esperar();
		botones[i][j].setBackground(Color.WHITE);
	}
	
	public void marcar(int i, int j, Color c) {
		botones[i][j].setBackground(c);
	}
	
	public void desmarcar(int i, int j) {
		botones[i][j].setBackground(Color.WHITE);
	}
	
	public void esperar() {
		try {
			Thread.sleep(ESPERA);
		} catch (InterruptedException e) {
		}
	}
	
}
