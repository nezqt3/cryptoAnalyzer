package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

	public String readFile(String filePath) throws IOException {
		Path path = Path.of(filePath);
		List<String> lines = Files.readAllLines(path);
		String result = "";
		for (var line : lines) {
			result += line + " ";
		}
		return result;
	}

	public void writeFile(String content, String filePath){
		try (FileWriter fileWriter = new FileWriter(filePath)) {
			fileWriter.write(content);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
