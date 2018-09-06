package matura_18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Matura2 {

	public static void main(String[] args) {
		int currentHighest = 0;
		String currentWordWithBiggestNumber = "";
		try {
			Scanner in = new Scanner(new FileReader("sygnaly.txt"));

			while (in.hasNext()) {
				String currentLine = in.nextLine();
				int currentDifferent = countUniqueCharacters(currentLine);
					if(currentDifferent >currentHighest) {
						currentHighest = currentDifferent;
						currentWordWithBiggestNumber = currentLine;
					}
					
				
				
			}
			in.close();
			System.out.println(currentHighest);
			System.out.println(currentWordWithBiggestNumber);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int countUniqueCharacters(String currentLine) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i<currentLine.length(); i++) {
			set.add(currentLine.charAt(i));
		
		}
		return set.size();
		
	}

}
