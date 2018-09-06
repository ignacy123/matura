package matura_18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Matura3 {
	public static void main(String[] args) {
		int counter = 0;
		try {
			Scanner in = new Scanner(new FileReader("sygnaly.txt"));

			while (in.hasNext()) {
				String currentLine = in.nextLine();
				if(countWordDifference(currentLine)<=10) System.out.println(currentLine);
					
				
				
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int countWordDifference(String currentLine) {
		char currentSmallest = 'Z';
		char currentBiggest = 'A';
		for(int i = 0; i<currentLine.length(); i++) {
			char currentChar = currentLine.charAt(i);
			if(currentChar-currentSmallest<0) {
				currentSmallest = currentChar;
			}
			if(currentBiggest-currentChar<0) {
				currentBiggest = currentChar;
			}
		}
		return currentBiggest-currentSmallest;
		
		
	}

}
