package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Cipher {

	public final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
	public final char[] alphabet = ALPHABET.toCharArray();

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