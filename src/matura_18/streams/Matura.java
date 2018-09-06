package matura_18.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matura {

	public static void main(String[] args) throws IOException {
		final List<String> lines = Files.lines(Paths.get("sygnaly.txt"))
				.collect(Collectors.toList());

		// niestety wyciągnięcie co 40-ego nie da się łatwo zrobić streamami
		// więc najpierw powyżej wczytanie wszystkich linii do zwykłej listy
		// a poniżej dodatkowy IntStream żeby móc wyfiltrować co 40-ty
		// mocno "na siłę" ale się da to zrobić tylko z pomocą streamów
		final String result = IntStream.range(0, lines.size())
				.filter(lineNumber -> (lineNumber + 1) % 40 == 0)
				.mapToObj(lines::get)
				.map(line -> line.substring(9, 10))
				.reduce("", String::concat);

		System.out.println(result);
	}
}
