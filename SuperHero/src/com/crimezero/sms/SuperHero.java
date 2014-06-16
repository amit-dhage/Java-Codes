package com.crimezero.sms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SuperHero {
	private List<String> superHeroNames = new ArrayList<String>();

	public SuperHero() {
		superHeroNames.add("SUPERMAN");
		superHeroNames.add("THOR");
		superHeroNames.add("ROBIN");
		superHeroNames.add("IRONMAN");
		superHeroNames.add("GHOSTRIDER");
		superHeroNames.add("CAPTAINAMERICA");
		superHeroNames.add("FLASH");
		superHeroNames.add("WOLVERINE");
		superHeroNames.add("BATMAN");
		superHeroNames.add("HULK");
		superHeroNames.add("BLADE");
		superHeroNames.add("PHANTOM");
		superHeroNames.add("BLACKWIDOW");
		superHeroNames.add("HELLBOY");
		superHeroNames.add("PUNISHER");
	}

	public static void main(String[] args) {

		try {
			String fileLocation = "input/sampleInput";
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(fileLocation));
			String str;

			List<String> lines = new ArrayList<String>();
			while ((str = in.readLine()) != null) {
				lines.add(str);
			}

			for (String input : lines) {
				if (input.charAt(0) != '0' && input.charAt(1) != ' ')
					throw (new IllegalArgumentException());
				input = input.substring(2);
				SuperHero superHero = new SuperHero();
				superHero.findSuperHero(input);
			}
		} catch (Exception e) {
			System.out
					.println("Wrong Input Please enter 0<space> and type Super Hero Name");
		}
	}

	public void findSuperHero(String input) {
		List<String> initialresults = new ArrayList<String>();
		List<String> fianlresults = new ArrayList<String>();
		initialresults.addAll(superHeroNames);

		for (int i = 0; i < input.length(); i++) {
			String temp = null;

			temp = (new GetChars()).find(input.charAt(i));
			for (String superHeroName : initialresults) {
				if (temp.length() == 4) {
					if (superHeroName.charAt(i) == temp.charAt(0)
							|| superHeroName.charAt(i) == temp.charAt(1)
							|| superHeroName.charAt(i) == temp.charAt(2)
							|| superHeroName.charAt(i) == temp.charAt(3)) {
						fianlresults.add(superHeroName);
					}
				} else {
					if (superHeroName.charAt(i) == temp.charAt(0)
							|| superHeroName.charAt(i) == temp.charAt(1)
							|| superHeroName.charAt(i) == temp.charAt(2)) {
						fianlresults.add(superHeroName);
					}
				}
			}
			initialresults.clear();
			initialresults.addAll(fianlresults);
			fianlresults.clear();
		}
		if (!initialresults.isEmpty())
			System.out.println(initialresults.get(0));
		else
			System.out
					.println("Result does not Matched Please enter 0<space> and type Super Hero Name");
	}
}