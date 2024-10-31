package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cipher {

	private final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
	private final char[] alphabet = ALPHABET.toCharArray();

	public String getALPHABET() {
		return ALPHABET;
	}

	public char[] getAlphabet() {
		return alphabet;
	}

	// шифрование заданного текста по ключу
	public String encrypt(String inputText, int key) {
		String result = "";
		inputText = inputText.toLowerCase();
		for (int i = 0; i < inputText.length(); i++) {
			int index = ALPHABET.indexOf(inputText.charAt(i));
			int indexOfAlphabet = index + key;
			if (indexOfAlphabet >= alphabet.length) {
				indexOfAlphabet = indexOfAlphabet - alphabet.length;
			}
			result += alphabet[indexOfAlphabet];
		}
		return result;
	}

	// дешифрование заданного ключа по ключу
	public String decrypt(String inputText, int key) {
		String result = "";
		inputText = inputText.toLowerCase();
		for (int i = 0; i < inputText.length(); i++) {
			int index = ALPHABET.indexOf(inputText.charAt(i));
			int indexOfAlphabet = index - key;
			if (indexOfAlphabet < 0) {
				indexOfAlphabet = alphabet.length + indexOfAlphabet;
			}
			result += alphabet[indexOfAlphabet];
		}
		return result;
	}

}
