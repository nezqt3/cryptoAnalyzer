package org.example;


import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {

	public Status status = Status.NOTHING;
	public Cipher cipher = new Cipher();
	public FileManager fileManager = new FileManager();
	public Validator validator = new Validator();
	public BruteForce bruteForce = new BruteForce();
	public Scanner scan = new Scanner(System.in);
	public StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();

	public void encryption() throws IOException {
		System.out.println("Введите путь от файла с которого прочитать текст:");
		String path = scan.nextLine();
		if (validator.isFileExists(path)) {
			String contentWriteFile = fileManager.readFile(path);
			System.out.println("Введите ключ для шифрования:");
			int key = scan.nextInt();
			if (validator.isValidKey(key)) {
				String phifr = cipher.encrypt(contentWriteFile, key);
				System.out.println("Введите путь к файлу в который записать шифр: ");
				fileManager.writeFile(phifr, scan.nextLine());
			} else {
				System.out.println("Вы ввели недопустимый ключ");
			}
		} else {
			System.out.println("Вы ввели несуществующий путь");
		}
	}

		public void decoding() throws IOException {
			System.out.println("Введите путь от файла с которого прочитать текст:");
			String path = scan.nextLine();
			if (validator.isFileExists(path)) {
				String contentWriteFile = fileManager.readFile(path);
				System.out.println("Введите ключ для расшифрования:");
				int key = scan.nextInt();
				if (validator.isValidKey(key)) {
					String dePhifr = cipher.decrypt(contentWriteFile, key);
					System.out.println("Введите путь к файлу в который записать шифр: ");
					fileManager.writeFile(dePhifr, scan.nextLine());
				} else {
					System.out.println("Вы ввели недопустимый ключ");
				}
			} else {
				System.out.println("Вы ввели несуществующий путь");
			}

		}

		public void bruteForce() throws IOException {
			System.out.println("Выберите режим взлома: вывод всех возможных вариантов или вывод наиболее подходящего варианта");
			String stringAnswer = scan.nextLine();
			if (stringAnswer.equalsIgnoreCase("вывод всех возможных вариантов")) {
				System.out.println("Введите путь до файла для взлома способом бруте-форс: ");
				String pathToFile = scan.nextLine();
				if (!validator.isFileExists(pathToFile)) {
					System.out.println("Такого пути не существует");
					return;
				}
				String stringBrute = fileManager.readFile(pathToFile);
				System.out.println(bruteForce.decryptByBruteForce(stringBrute.toLowerCase()));
			} else if (stringAnswer.equalsIgnoreCase("вывод наиболее подходящего варианта")) {
				System.out.println("Введите путь до файла для взлома способом бруте-форс: ");
				String pathToFile = scan.nextLine();
				if (!validator.isFileExists(pathToFile)) {
					System.out.println("Такого пути не существует");
					return;
				}
				String stringBrute = fileManager.readFile(pathToFile);
				System.out.println("Введите путь до файла приблизительного содержания с изначальным текстом: ");
				String pathToFileAnother = scan.nextLine();
				if (!validator.isFileExists(pathToFileAnother)) {
					System.out.println("Такого пути не существует");
					return;
				}
				String stringOther = fileManager.readFile(pathToFile);
				System.out.println(bruteForce.findOutTheNearestDecryption(stringBrute.toLowerCase(), stringOther.toLowerCase()));
			}
		}

}
