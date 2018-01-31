package entities;

public class Jugador {
	private int id;
	private String nombre, apellido, posicion;
	private boolean estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
