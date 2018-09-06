package matura_17_18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Matura {
	public static void main(String[] args) {
		Map<String, Double> cennik = new HashMap<>();
		cennik.put("2005", 2.00);
		cennik.put("2006", 2.05);
		cennik.put("2007", 2.09);
		cennik.put("2008", 2.15);
		cennik.put("2009", 2.13);
		cennik.put("2010", 2.10);
		cennik.put("2011", 2.20);
		cennik.put("2012", 2.25);
		cennik.put("2013", 2.22);
		cennik.put("2014", 2.23);
			Map<String, Double> cukierMapa = new HashMap<>();
			readFile(cukierMapa, cennik);
			znajdzNajwieksze(cukierMapa);
			znajdzNajwieksze(cukierMapa);
			znajdzNajwieksze(cukierMapa);
	}

	private static void znajdzNajwieksze(Map<String, Double> cukierMapa) {
		String najwiekszyNip = "";
		double najwiecejCukru = 0;
		for(Map.Entry<String, Double> wejscie :cukierMapa.entrySet()) {
			if(wejscie.getValue()>najwiecejCukru) {
				najwiecejCukru = wejscie.getValue();
				najwiekszyNip = wejscie.getKey();
			}
		}
		cukierMapa.remove(najwiekszyNip);
		System.out.println(najwiekszyNip);
		System.out.println(najwiecejCukru);
	}

	public static void readFile(Map<String, Double> cukierMapa, Map<String, Double> cennik) {
		try {
			Scanner in = new Scanner(new FileReader("cukier.txt"));
			StringBuilder sb = new StringBuilder();
			Double przychod = 0.0;
			while (in.hasNext()) {
				przychod += addTransaction(in.findInLine("\\d{4}"), in.findInLine("\\d{3}-\\d{2}-\\d{2}-\\d{3}"), Double.valueOf(in.findInLine("(?<=-\\d{3}	)\\d*")), cukierMapa, cennik);
				in.nextLine();
			}
			in.close();
			System.out.println(przychod);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	private static Double addTransaction(String rok, String nip, Double cukier, Map<String, Double> cukierMapa, Map<String, Double> cennik) {
		if(cukierMapa.containsKey(nip)) {
			cukierMapa.replace(nip, cukierMapa.get(nip)+cukier);
		}else {
			cukierMapa.put(nip, cukier);
		}
		return cukier*cennik.get(rok);
		
		
	}
}
