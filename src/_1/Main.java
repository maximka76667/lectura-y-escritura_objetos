package _1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
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

			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			for (int i = 0; i < temperaturas.size(); i++) {
				int temperatura = (int) objectInputStream.readObject();
				System.out.println(temperatura);
			}

			objectInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		input.close();
	}

}
