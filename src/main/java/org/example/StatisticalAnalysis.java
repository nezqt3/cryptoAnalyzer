package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticalAnalysis {

	public Cipher cipher = new Cipher();
	public char[] cipherAlphabet = cipher.getAlphabet();

	public int findMostLikelyShift(String encryptedText, String representativeText) {

		HashMap<Character, Integer> mapTextForEncryptedText = new HashMap<>();

		for (int j = 0; j < cipherAlphabet.length - 1; j++) {
			int count = 0, index = 0;
			while ((index = encryptedText.indexOf(cipherAlphabet[j], index)) != -1) {
				count++;
				index++;
			}
			if (count > 0) {
				mapTextForEncryptedText.putIfAbsent(cipherAlphabet[j], count);
			}
		}

		List<HashMap<Character, Integer>> listOfHashMap = new ArrayList<>();

		for (int i = 0; i < cipherAlphabet.length; i++) {
			HashMap<Character, Integer> mapTextForInputText = new HashMap<>();
			for (int j = 0; j < cipherAlphabet.length - 1; j++) {
				int count = 0, index = 0;
				int key = j - i;
				if (key < 0) {
					key = cipherAlphabet.length + key;
				}
				while ((index = representativeText.indexOf(cipherAlphabet[key], index)) != -1) {
					count++;
					index++;
				}
				if (count > 0) {
					mapTextForInputText.putIfAbsent(cipherAlphabet[j], count);
				}
			}
			for (var elem : mapTextForInputText.entrySet()) {
				for (var el : mapTextForInputText.entrySet()) {
					if (elem.getValue() == el.getValue()) {
						return el.getValue();
					}
				}
			}
			listOfHashMap.add(mapTextForInputText);
		}
		return -1;
	}

}
