package matura_18.streams;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Matura2 {

	public static void main(String[] args) throws IOException {
		final Pair<String, Integer> result = Files.lines(Paths.get("sygnaly.txt"))
				.map(line -> new Pair<>(line, countUniqueCharacters(line)))
				.max((o1, o2) -> o1.getValue() - o2.getValue())
				.get();

		System.out.println(result.getKey() + " " + result.getValue());
	}

	private static int countUniqueCharacters(String currentLine) {
		return (int) currentLine.chars()
				.distinct()
				.count();
	}

}
