package matura_18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Matura {

	public static void main(String[] args) {
		Scanner in;
		int counter = 1;
		try {
			in = new Scanner(new FileReader("sygnaly.txt"));

			StringBuilder sb = new StringBuilder();
			while (in.hasNext()) {
				if(counter%40==0) {
					sb.append(in.findInLine("\\w{10}").substring(9, 10));
				}
				counter++;
				in.nextLine();
			}
			in.close();
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
