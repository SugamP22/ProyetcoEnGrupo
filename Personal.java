package proyectoFinalSecundotremestre;

import java.util.Objects;

public class Personal implements Comparable<Personal> {
	protected String nombre;

	// Constructor
	public Personal(String nombre) {
		this.nombre = nombre;
	}

	// Getter for nombre
	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Personal otro) {
		return this.nombre.compareTo(otro.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String toString() {
		return nombre.toString();
	}

}
