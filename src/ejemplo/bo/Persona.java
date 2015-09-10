package ejemplo.bo;

public class Persona {

	private int id;
	private String nombre;
	
	public Persona(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return id + " " + nombre;
	}
	
}
