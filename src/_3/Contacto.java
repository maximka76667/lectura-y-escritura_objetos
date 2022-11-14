package _3;

import java.io.Serializable;

public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String dni, nombre, apellidos, telefono;

	public Contacto(String dni, String nombre, String apellidos, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		return dni.equals(((Contacto) obj).dni);
	}

}
