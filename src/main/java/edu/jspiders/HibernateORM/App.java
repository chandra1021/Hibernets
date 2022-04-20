package edu.jspiders.HibernateORM;

import java.util.Collection;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		charaterCount();
		pattern(5);
		prime(293);
		System.out.println(sumOfDigits(9999));
		int code =printCode(9999)+64;
		System.out.println((char)code);


	}

	private static void charaterCount() {
		String name = "Chandra";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < name.length(); i++) {
			if (map.containsKey(name.charAt(i))) {
				map.put(name.charAt(i), map.get(name.charAt(i)) + 1);
			} else {
				map.put(name.charAt(i), 1);
			}
		}

		System.out.println(map);
		System.out.println(map.keySet());
		Collection<Integer> allValues = map.values();

	}

	private static void pattern(int value) {

		for (int i = 0; i <= value; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i <= value; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}

		for (int i = 0; i <= value; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		for (int i = 0; i <= value; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(j + " *");
			}
			System.out.println();
		}

		for (int i = 0; i <= value; i++) {
			for (int j = 0; j < i; j++) {
				if (i % 2 == 0) {
					System.out.print(i);
				} else {
					System.out.print("$");
				}
			}
			System.out.println();
		}

		for (int i = 0; i <= value; i++) {
			for (int j = 0; j < i; j++) {
				if (j % 2 == 0) {
					System.out.print(j);
				} else {
					System.out.print("$");
				}
			}
			System.out.println();
		}

	}

	private static void prime(int value) {

		if (value % 2 == 0 || value % 3 == 0 || value % 5 == 0 || value % 7 == 0) {
			if (value == 1 || value == 2 || value == 3 || value == 5 || value == 7) {
				System.out.println("Value is prime " + value);
			} else {
				System.out.println("Value is not prime " + value);
			}
		} else {
			System.out.println("Value is prime " + value);
		}

	}

	private static int sumOfDigits(int number) {
		int sum = 0;
		while (number != 0) {
			int remainder = number % 10;
			sum = sum + remainder;

			number = number / 10;
		}
		return sum;
	}

	private static int printCode(int number) {
		int Num = sumOfDigits(number);
		while (Num >= 26) {
			if ((Num >= 26)) {
				Num = printCode(Num);
			} 
		}
		return Num;
	}
}
