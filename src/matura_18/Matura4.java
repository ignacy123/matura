package matura_18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Matura4 {

	public static void main(String[] args) {
		Map<Integer, Integer> years = new HashMap<>();
		try {
			Scanner in = new Scanner(new FileReader("woda.txt"));

			while (in.hasNext()) {
				String currentLine = in.nextLine();
					addValues(in.findInLine("\\d{4}"), in.findInLine("\\t\\d+"), years);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer currentMax = 0;
		Integer maxYear = 0;
		for(Map.Entry<Integer, Integer> entry:years.entrySet()) {
				if(currentMax<entry.getValue()) {
					maxYear = entry.getKey();
					currentMax = entry.getValue();
				}
		}

		System.out.println(maxYear);
	}



	private static void addValues(String yearInString, String valueInString, Map<Integer, Integer> years) {
		// TODO Auto-generated method stub
		Integer year = Integer.valueOf(yearInString);
		Integer value = Integer.parseInt(valueInString.trim());
		
		Integer currValue = years.getOrDefault(year, 0);
		
		years.put(year, value+currValue);
	}
}
