package proyectoFinalSecundotremestre;

import java.util.HashMap;

public class Estudiante extends Personal {
	HashMap<Asignatura, EstadoAsignatura> map;

	public Estudiante(String nombre) {
		super(nombre);
		this.map = new HashMap<>();
	}

	// no vamos a usar getters y setters por que no voy a llamar la mapa fuera del
	// esa clase !!

	public boolean aniadirasignatura(Asignatura asignatura, EstadoAsignatura estado) {
		if (map.containsKey(asignatura)) {
			return false;
		}
		map.put(asignatura, estado);
		return true;

	}

	public int borrarAsignatura(Asignatura asignatura) {
		if (map.isEmpty()) {
			return 1;
		}
		return (map.remove(asignatura) != null) ? 2 : 3;// si la key que existia esta borrado me da un 2 si no la key
														// nunca existia

	}


	public void MostrarAsignatura() {
		if (map.isEmpty()) {
			System.out.println("No tiene nada registradoi para mostrar!!");
		}
		for (var entry : map.entrySet()) {
			System.out.printf("%s\nEstado: %s\n", entry.getKey(), entry.getValue());
		}
	}

}

