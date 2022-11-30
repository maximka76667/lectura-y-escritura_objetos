package _4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import _3.Contacto;

public class Main {

	public static void showContacts() {
		String path = "src\\_3\\contactos.bin";
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));

			while (true) {
				try {
					Contacto contacto = (Contacto) objectInputStream.readObject();
					System.out.println(contacto);
					contactos.add(contacto);
				} catch (EOFException e) {
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			objectInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		showContacts();
	}

}
