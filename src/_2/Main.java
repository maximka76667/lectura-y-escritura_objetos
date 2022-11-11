package _2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String path = "src\\_1\\temperaturas.bin";
		ArrayList<Integer> temperaturas = new ArrayList<Integer>();

		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
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

			temperaturas.sort((Integer a, Integer b) -> a - b);

			System.out.println(temperaturas);
			System.out.println("Temperatura minima: " + temperaturas.get(0));
			System.out.println("Temperatura maxima: " + temperaturas.get(temperaturas.size() - 1));

			objectInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
