package matura_18.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Matura3 {

	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("sygnaly.txt"))
				.filter(line -> countWordDifference(line) <= 10)
				.forEach(System.out::println);
	}

	private static int countWordDifference(String currentLine) {
		final int min = currentLine.chars()
				.min()
				.getAsInt();

		final int max = currentLine.chars()
				.max()
				.getAsInt();

		return max - min;

	}

}
