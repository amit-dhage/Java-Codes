package com.abc.invmgmt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnlineStore {

	public static void main(String[] args) {

		// input from a file
		String fileLocation = "input/sampleInput";

		try {

			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(fileLocation));
			String str;

			List<String> lines = new ArrayList<String>();
			while ((str = in.readLine()) != null) {
				lines.add(str);
			}
			for (String rawInput : lines) {
				System.out.println(rawInput);
				String[] splitedValues = rawInput.split(":");
				InventorySystem inventorySystem = new InventorySystem();
				inventorySystem.replenishInventory();
				inventorySystem.parseAndAssignValues(splitedValues);
				System.out.println(inventorySystem.getMinimizedSalePrice());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Filename with Path  " + fileLocation
					+ "is NOT found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
