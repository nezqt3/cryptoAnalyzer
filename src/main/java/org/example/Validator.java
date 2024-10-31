package org.example;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

	Cipher cipher = new Cipher();
	public char[] alphabet = cipher.getAlphabet();

	// Проверка ключа
	public boolean isValidKey(int key) {
		if (key > alphabet.length || key < 0) {
			return false;
		} else {
			return true;
		}
	}

	// Проверка наличия файла в системе
	public boolean isFileExists(String filePath) {
		if (Files.exists(Path.of(filePath))) {
			return true;
		}
		return false;
	}

}
