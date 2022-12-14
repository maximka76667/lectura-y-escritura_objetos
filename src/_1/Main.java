package _1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final Scanner input = new Scanner(System.in);
		final ArrayList<Integer> temperaturas = new ArrayList<Integer>();
		final String path = "src\\_1\\temperaturas.bin";

		do {
			System.out.print("Temperatura: ");
			int temperatura = input.nextInt();
			if (temperatura == -100) {
				break;
			}
			temperaturas.add(temperatura);
		} while (true);

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path, false);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			for (int temperatura : temperaturas) {
				objectOutputStream.writeObject(temperatura);
			}

			objectOutputStream.close();

			System.out.println("Listo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		input.close();
	}

}
