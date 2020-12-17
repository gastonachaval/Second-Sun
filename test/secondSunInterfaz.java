package secondSun.test;

import java.util.Scanner;

import secondSun.dominio.AlarmaComunal;
import secondSun.dominio.Persona;

public class secondSunInterfaz {

	static AlarmaComunal secondSun = new AlarmaComunal("Second Sun");
	static Scanner teclado = new Scanner(System.in);
	static Persona usuarioQueEstaUsandoLaApp = null;
	static Integer opcionSeleccionada = 0;

	private static void mostrarOpciones() {
		System.out.println("*************************************");
		System.out.println("Seleccione una opcion");
		System.out.println("*************************************");
		System.out.println("3.Historial de activaciones");
		System.out.println("159.Hacer Sonar Alarma");
		System.out.println("9.Salir");

	}

	private static void seleccionOpcion(int opcion) {
		switch (opcion) {

		case 3:
			System.out.println("*************************************");
			System.out.println(secondSun.getHistorialDeActivaciones());
			System.out.println("*************************************");
			break;

		case 9:
			System.out.println("*************************************");
			System.out.println("Nos vemos");
			System.out.println("*************************************");
			break;

		case 159:
			System.out.println("*************************************");
			secondSun.registrarActivacion(usuarioQueEstaUsandoLaApp);
			System.out.println("ALARMA SONANDO !!!");
			System.out.println("*************************************");
			break;

		default:
			System.out.println("Opcion Invalida");
			System.out.println("*************************************");
			break;
		}

	}

	public static void main(String[] args) {
		System.out.println("Bienvenido al sistema de alerta comunal " + secondSun.getNombre());
		System.out.println("*************************************");
		System.out.println("Registrese para utilizar el boton antipanico");
		System.out.println("*************************************");

		System.out.println("Ingrese su nombre y apellido");
		String nombreIngresado = teclado.nextLine();
		System.out.println("Ingrese su direccion");
		String direccionIngresada = teclado.nextLine();
		System.out.println("Ingrese su DNI");
		Integer dniIngresado = teclado.nextInt();
		System.out.println("Ingrese su telefono");
		Long telefonoIngresado = teclado.nextLong();

		if (secondSun.registrarUsuario(nombreIngresado, dniIngresado, direccionIngresada, telefonoIngresado)
				.equals(true)) {
			System.out.println("*************************************");
			System.out.println("Registracion Exitosa");
			System.out.println("*************************************");
			System.out.println("Por favor abone el costo del boton antipanico");
			if (secondSun.cobrarleAUnUsuario(dniIngresado).equals(true)) {
				usuarioQueEstaUsandoLaApp = secondSun.getUsuario(dniIngresado);
				System.out.println("Cobro Exitoso");
			}
		} else {
			System.out.println("Hubo un problema con la registracion...");
		}
		System.out.println("*************************************");

		do {
			mostrarOpciones();
			opcionSeleccionada = teclado.nextInt();
			teclado.nextLine();
			seleccionOpcion(opcionSeleccionada);
		} while (opcionSeleccionada != 9);

	}

}
