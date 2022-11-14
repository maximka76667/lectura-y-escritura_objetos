package _3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	final static Scanner input = new Scanner(System.in);

	public static String askString(String message) {
		System.out.print(message);
		return input.nextLine();
	}

	public static void main(String[] args) {

		final ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		final String path = "src\\_3\\contactos.bin";

		do {
			System.out.println("*Nuevo contacto*");
			String dni = askString("DNI: ");

			if (dni.equals("*")) {
				break;
			}

			String nombre = askString("Nombre: ");
			String apellidos = askString("Apellidos: ");
			String telefono = askString("Telefono: ");

			contactos.add(new Contacto(dni, nombre, apellidos, telefono));
		} while (true);

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path, false);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			for (Contacto contacto : contactos) {
				objectOutputStream.writeObject(contacto);
			}

			objectOutputStream.reset();
			objectOutputStream.close();

			System.out.println("Listo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		input.close();
	}

}
