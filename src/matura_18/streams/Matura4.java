package matura_18.streams;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Matura4 {

	private static final Pattern PATTERN = Pattern.compile("^(\\d{4})-\\d{2}-\\d{2}\t(\\d+)$");

	public static void main(String[] args) throws IOException {
		final String result = Files.lines(Paths.get("woda.txt"))
				.map(line -> {
					final Matcher matcher = PATTERN.matcher(line);
					matcher.matches();
					final String year = matcher.group(1);
					final Integer volume = Integer.valueOf(matcher.group(2));
					return new Pair<>(year, volume);
				})
				.collect(groupingBy(Pair::getKey, summingInt(Pair::getValue)))
				// na tym etapie mamy mape, ktorej wszystkie Entry znowu przeksztalcamy do streama
				.entrySet()
				.stream()
				.max((o1, o2) -> o1.getValue() - o2.getValue())
				.get()
				.getKey();

		System.out.println(result);
	}
}
