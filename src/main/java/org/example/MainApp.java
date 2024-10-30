package org.example;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class MainApp extends CaesarCipher {

	public static void main(String[] args) throws IOException {

		CaesarCipher caesarCipher = new CaesarCipher();
		Scanner scan = new Scanner(System.in);
		Date date = new Date();

		System.out.println(date);
		System.out.println("Какой режим вы выберете: шифровка/расшифровка или брута-форс");
		String mode = scan.nextLine();
		if (mode.equalsIgnoreCase("шифровка") || mode.equalsIgnoreCase("расшифровка")) {
			caesarCipher.status = Status.CIPHER;
			if (mode.equalsIgnoreCase("шифровка")) {
				caesarCipher.encryption();
				caesarCipher.status = Status.NOTHING;
			} else {
				caesarCipher.decoding();
				caesarCipher.status = Status.NOTHING;
			}
		} else if (mode.equalsIgnoreCase("брута-форс")) {
			caesarCipher.status = Status.BRUTEFORCE;
			if (caesarCipher.status == Status.BRUTEFORCE) {
				caesarCipher.bruteForce();
			}
			caesarCipher.status = Status.CIPHER;
		}

	}

}
