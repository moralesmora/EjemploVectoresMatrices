// Se indica el paquete donde se encuentra esta clase
package ejemplo.bo;

/**
 * 
 * Clase que representa personas
 * 
 * @author Rubén Jiménez Goñi
 */
public class Persona {

	/**
	 * Atributo id de la persona
	 */
	private int id;
	
	/**
	 * Atributo nombre de la persona
	 */
	private String nombre;
	
	/**
	 * Constructor de personas que recibe id y nombre
	 * @param id Id para la persona
	 * @param nombre Nombre para la persona
	 */
	public Persona(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}
	
	/**
	 * Asigna un nombre a la persona
	 * @param nombre Nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el nombre de la persona
	 * @return Nombre de la persona
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Asigna un id a la persona
	 * @param id Nuevo id de la persona
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Devuelve el id de la persona
	 * @return Id de la persona
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Devuelve un mensaje que contiene el id y el nombre de la persona
	 * @return Id y nombre de la persona
	 */
	@Override
	public String toString() {
		return id + " " + nombre;
	}
	
}