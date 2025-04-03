package proyectoFinalSecundotremestre;

import java.util.Objects;

public class Asignatura {
	private String nombre;//
	private String profesor;
	private int creditos;

	public Asignatura(String nombre, String profesor, int creditos) {
		this.creditos = creditos;
		this.nombre = nombre;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditos, nombre, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return creditos == other.creditos && Objects.equals(nombre, other.nombre)
				&& Objects.equals(profesor, other.profesor);
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", profesor=" + profesor + ", creditos=" + creditos + "]";
	}
	

}
