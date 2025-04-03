package proyectoFinalSecundotremestre;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	private static Scanner sn = new Scanner(System.in);// sccanner para numeros
	private static Scanner sl = new Scanner(System.in);// scanner para letras
	private static TreeSet<Personal> personal = new TreeSet<>();

	public static void main(String[] args) {
		iniciarMain();
		System.out.println("\033[45mGracais por su particpacion\033[0m");
	}

	private static void iniciarMain() {
		int opcion = 0;
		do {
			menu();
			try {
				opcion = sn.nextInt();
				switchMain(opcion);
			} catch (InputMismatchException e) {
				System.err.println("Error: Introduce un numero!!");
				sn.next();
			}
		} while (opcion != 6);
	}

	private static void switchMain(int opcion) {
		String resultado;
		switch (opcion) {
		case 1:
			System.out.println(">>>>  Añadir Personas <<<<\n:::::::::>");
			resultado = aniadirPersonas();
			System.out.println(resultado);
			break;
		case 2:
			System.out.println(">>>>  Eliminar Personas <<<<\n:::::::::>");
			resultado = eliminarPersonas();
			System.out.println(resultado);

			break;
		case 3:
			System.out.println(">>>>  Añadir asignaturas <<<<\n:::::::::>");
			resultado = aniadirAsignaturas();
			System.out.println(resultado);

			break;
		case 4:
			System.out.println(">>>>  Eliminar asignaturas <<<<\n:::::::::>");
			resultado = eliminarAsignaturas();
			System.out.println(resultado);

			break;
		case 5:
			System.out.println(">>>> Mostrar informacion <<<<\n:::::::::>");
			MostrarInfo();
			break;
		case 6:
			System.out.println("Saliendo...");
			break;
		default:
			System.out.println("Error : Ingresa un numero entre (1-6)");
			break;
		}

	}

	private static void MostrarInfo() {
		if (personal.isEmpty()) {
			System.out.println("No hay ningun alumno registrado!!"); // If the list is empty, return this message
		}

		// If the list isn't empty, print all the people
		System.out.println("Personal en el sistema: ");
		for (Personal p : personal) {
			if (p instanceof Estudiante) {

			} else {
				System.out.println(p);
			}
		}

		System.out.println("Alumnos en el sistema: ");
		for (Personal p : personal) {
			if (p instanceof Estudiante) {
				Estudiante e1 = (Estudiante) p;
				e1.MostrarAsignatura();
			}
		}
	}

	private static String eliminarAsignaturas() {
		System.out.print("Introduce el nombre del alumno:");
		String nombreAlumno = sl.nextLine().toUpperCase();
		Personal persona = new Personal(nombreAlumno);
		for (Personal p : personal) {
			if (p.equals(persona) && (p instanceof Estudiante)) {
				Estudiante estudiante = (Estudiante) p;
				System.out.println("introduce un nombre de asignatura:");
				String nombreasignatura = sl.nextLine();
				System.out.println("introduce un nombre de asignatura:");
				String nombreProfe = sl.nextLine();
				System.out.println("ingresa el cedito para la asignatura:");
				int creditoasignatura = sn.nextInt();
				Asignatura asignatura = new Asignatura(nombreasignatura, nombreProfe, creditoasignatura);
				int resultado = estudiante.borrarAsignatura(asignatura);
				if (resultado == 1) {
					return "No hay ningun asignatura registrado para eliminar";

				}
				return resultado == 2 ? "Erro: Eliminado con exito!!" : "No existe ningun asignatura con este nombre";
			}
		}
		return "Error: no existe ningun alumno con este nombre";

	}

	private static String aniadirAsignaturas() {
		System.out.print("Introduce el nombre del estudainte: ");
		String nombre = sl.nextLine().toUpperCase();
		for (Personal p : personal) {
			if (p.getNombre().equals(nombre)) {

				if (p instanceof Estudiante) {
					Estudiante estudiante = (Estudiante) p;
					System.out.println("introduce un nombre de asignatura:");
					String nombreasignatura = sl.nextLine();
					System.out.println("introduce un nombre de Profesor:");
					String nombreProfe = sl.nextLine();
					System.out.println("ingresa el cedito para la asignatura:");
					int creditoasignatura = sn.nextInt();
					Asignatura asignatura = new Asignatura(nombreasignatura, nombreProfe, creditoasignatura);
					boolean flag = false;
					while (!flag) {
						System.out.println("Introduce estado | SUPERADO| CURSADO | ABANDONADO|");
						String estado = sl.nextLine();
						try {
							EstadoAsignatura validoEstado = EstadoAsignatura.valueOf(estado);
							boolean aniadido = estudiante.aniadirasignatura(asignatura, validoEstado);
							flag = true;
							return aniadido ? "Asignatura añadido con exito"
									: "Error: duplicacion la asignatura ya existe!!";

						} catch (IllegalArgumentException e) {
							System.out.println("Error: Ingresa estado | SUPERADO| CURSADO | ABANDONADO|");
						}
					}

				}
			}
		}
		return "Error: no existe ningun alumno con este nombre";
	}

	private static String eliminarPersonas() {
		if (personal.isEmpty()) {
			return "Error: no existe ningun persona registrado para eliminarlo!!";
		}
		System.out.println("Introduce un nombre del persona:");
		String nombre = sl.nextLine().toUpperCase();
		Iterator<Personal> it = personal.iterator();
		while (it.hasNext()) {
			Personal persona = it.next();
			if (persona.getNombre().equalsIgnoreCase(nombre)) {
				it.remove();
				if (persona instanceof Estudiante) {
					return "Estudainte eliminado con exito";
				}
				return "Persona eliminado con exito";

			}
		}

		return "Error: No exite ningun persona con este nombre";
	}

	private static String aniadirPersonas() {

		System.out.println("¿Es un Estudainte(Sí/no)?");
		System.out.print(":::>");
		boolean tipo = sn.next().equalsIgnoreCase("sí");
		System.out.print("Introduce un nombre:");
		String nombre = sl.nextLine().toUpperCase();
		Personal persona = tipo ? new Estudiante(nombre) : new Personal(nombre);
		return personal.add(persona) ? (tipo ? "Estudiante añadido con exito!!" : "Personal añadido con exito")
				: "Error: duplicacion ya existe en la sistema";
	}

	private static void menu() {

		System.out.println("::::::: Menu Principal :::::");
		System.out.println("1. Añadir Personas");
		System.out.println("2. Eliminar Personas");
		System.out.println("3. Añadir asignaturas");
		System.out.println("4. Eliminar asignaturas");
		System.out.println("5. Mostrar informacion");
		System.out.println("6. Salir");
		System.out.print(">>>>>>>>>>>>");
	}

}
