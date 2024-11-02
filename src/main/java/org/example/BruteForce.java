package org.example;

import java.util.*;

public class BruteForce {

	private static Cipher cipher = new Cipher();
	private final String ALPHABET = cipher.getALPHABET();
	private static final char[] alphabet = cipher.getAlphabet();

	// вывод всех возможных вариантов дешифрования
	public String decryptByBruteForce(String encryptedText) {

		String resultAll = "";

		for (int i = 0; i < alphabet.length; i++) {
			String result = "";
			for (int j = 0; j < encryptedText.length(); j++) {
				int index = ALPHABET.indexOf(encryptedText.charAt(j));
				int indexOfAlphabet = index - i;
				if (indexOfAlphabet < 0) {
					indexOfAlphabet = alphabet.length + indexOfAlphabet;
				}
				result += alphabet[indexOfAlphabet];
			}
			resultAll += String.format("%s (ключ смещения). %s\n", i, result);
		}

		return resultAll;
	}

	// Вывод наиболее подходящего варианта дешифрования
	public String findOutTheNearestDecryption(String encryptedText, String textForExample) {

		List<String> stringList = List.of(textForExample.split(" "));

		Map<String, Integer> mapCounter = new HashMap<>();

		for (int i = 0; i < alphabet.length; i++) {
			String result = "";
			for (int j = 0; j < encryptedText.length(); j++) {
				int index = ALPHABET.indexOf(encryptedText.charAt(j));
				int indexOfAlphabet = index - i;
				if (indexOfAlphabet < 0) {
					indexOfAlphabet = alphabet.length + indexOfAlphabet;
				}
				result += alphabet[indexOfAlphabet];
			}
			List<String> resultList = List.of(result.split(" "));

			int count = 0;
			for (var elem : stringList) {
				for (var el : resultList) {
					if (elem.equals(el)) {
						count++;
					}
				}
			}
			if (count > 0) {
				mapCounter.put(result, count);
			}
		}

		int mx = 0;

		for (var value : mapCounter.entrySet()) {
			mx = Math.max(value.getValue(), mx);
		}
		for (var value : mapCounter.entrySet()) {
			if (value.getValue() == mx && mx != 0) {
				return value.getKey();
			}
		}
		return "Наиболее подходящего не нашлось";
	}

}
