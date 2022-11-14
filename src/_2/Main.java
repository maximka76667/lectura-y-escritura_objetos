package _2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String path = "src\\_1\\temperaturas.bin";
		ArrayList<Integer> temperaturas = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));

			while (true) {
				try {
					int temperatura = (int) objectInputStream.readObject();
					System.out.println(temperatura);
					temperaturas.add(temperatura);
				} catch (EOFException e) {
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			temperaturas.sort((a, b) -> a - b);

			System.out.println(temperaturas);
			System.out.println("Temperatura minima: " + temperaturas.get(0));
			System.out.println("Temperatura maxima: " + temperaturas.get(temperaturas.size() - 1));

			objectInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.print("Temperatura buscar: ");
		System.out.println(temperaturas.contains(input.nextInt()) ? "Está en la lista" : "No está en la lista");
		input.close();
	}
}
