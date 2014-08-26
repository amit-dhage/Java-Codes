package com.abc.invmgmt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class InventorySystem {

	Ipod ipod = null;
	Iphone iphone = null;
	Properties props = null;
	Map<String, Float> priceOfIpod = null;
	Map<String, Float> priceOfIphone = null;
	Map<String, Integer> totalIpods = null;
	Map<String, Integer> totalIphones = null;

	public InventorySystem() {
		ipod = new Ipod();
		iphone = new Iphone();
		props = new Properties();
		priceOfIpod = new HashMap<String, Float>();
		priceOfIphone = new HashMap<String, Float>();
		totalIpods = new HashMap<String, Integer>();
		totalIphones = new HashMap<String, Integer>();

		String filePath = "input/itemRatesAndTotal.properties";
		try {
			props.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("Filename with Path  " + filePath
					+ "is NOT found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMinimizedSalePrice() {

		int price = 0;

		int remainingIpodsInBrazil = 0;
		int remainingIpodsInArgentina = 0;
		int remainingIphonesinBrazil = 0;
		int remainingIphonesinArgentina = 0;

		try {

			if (ipod.getNoOfIpodsOrderded() > (ipod.getAvailableIpods().get(
					"BRAZIL") + ipod.getAvailableIpods().get("ARGENTINA"))
					|| iphone.getNoOfIphonesOrderded() > (ipod
							.getAvailableIpods().get("BRAZIL") + iphone
							.getAvailableIphones().get("ARGENTINA"))) {
				return "OUT_OF_STOCK:100:100:100:50";
			}

			else {
				InventorySystem inventorySystem = new InventorySystem();
				IpodInventory ipodInventory = new IpodInventory();
				IphoneInventory iphoneInventory = new IphoneInventory();

				List<Integer> ipodPrices = new ArrayList<Integer>();
				List<Integer> iphonePrices = new ArrayList<Integer>();

				for (int i = 0; i <= ipod.getNoOfIpodsOrderded(); i++) {
					if (i <= ipod.getAvailableIpods().get("BRAZIL")) {
						ipodPrices.add(ipodInventory.getChepIpod(
								inventorySystem, ipod, i,
								(ipod.getNoOfIpodsOrderded() - i)));
					}
				}

				remainingIpodsInBrazil = ipod.getAvailableIpods().get("BRAZIL")
						- IpodInventory.brazilIpod;
				remainingIpodsInArgentina = ipod.getAvailableIpods().get(
						"ARGENTINA")
						- IpodInventory.argentinaIpod;
				IpodInventory.brazilIpod = 0;
				IpodInventory.argentinaIpod = 0;
				IpodInventory.cuurentCheapIpodPrice = Integer.MAX_VALUE;
				totalIpods.put("BRAZIL", remainingIpodsInBrazil);
				totalIpods.put("ARGENTINA", remainingIpodsInArgentina);
				ipod.setAvailableIpods(totalIpods);

				for (int i = 0; i <= iphone.getNoOfIphonesOrderded(); i++) {
					if (i <= iphone.getAvailableIphones().get("BRAZIL")) {
						iphonePrices.add(iphoneInventory.getChepIphone(
								inventorySystem, iphone, i,
								(iphone.getNoOfIphonesOrderded() - i)));
					}
				}

				remainingIphonesinBrazil = iphone.getAvailableIphones().get(
						"BRAZIL")
						- IphoneInventory.brazilIphone;
				remainingIphonesinArgentina = iphone.getAvailableIphones().get(
						"ARGENTINA")
						- IphoneInventory.argentinaIphone;
				IphoneInventory.brazilIphone = 0;
				IphoneInventory.argentinaIphone = 0;
				IphoneInventory.cuurentCheapIphonePrice = Integer.MAX_VALUE;
				totalIphones.put("BRAZIL", remainingIphonesinBrazil);
				totalIphones.put("ARGENTINA", remainingIphonesinArgentina);
				iphone.setAvailableIphones(totalIphones);

				price = Collections.min(ipodPrices)
						+ Collections.min(iphonePrices);

				return price + ":" + ipod.getAvailableIpods().get("BRAZIL")
						+ ":" + ipod.getAvailableIpods().get("ARGENTINA") + ":"
						+ iphone.getAvailableIphones().get("BRAZIL") + ":"
						+ iphone.getAvailableIphones().get("ARGENTINA");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	public void replenishInventory() {
		totalIpods.put("BRAZIL",
				Integer.parseInt(props.getProperty("BRAZIL.IPOD.TOTAL")));
		totalIpods.put("ARGENTINA",
				Integer.parseInt(props.getProperty("ARGENTINA.IPOD.TOTAL")));
		priceOfIpod.put("BRAZIL",
				Float.parseFloat((props.getProperty("BRAZIL.IPOD.PRICE"))));
		priceOfIpod.put("ARGENTINA",
				Float.parseFloat((props.getProperty("ARGENTINA.IPOD.PRICE"))));
		ipod.setAvailableIpods(totalIpods);
		ipod.setPriceOfIpod(priceOfIpod);

		totalIphones.put("BRAZIL",
				Integer.parseInt(props.getProperty("BRAZIL.IPHONE.TOTAL")));
		totalIphones.put("ARGENTINA",
				Integer.parseInt(props.getProperty("ARGENTINA.IPHONE.TOTAL")));
		priceOfIphone.put("BRAZIL",
				Float.parseFloat((props.getProperty("BRAZIL.IPHONE.PRICE"))));
		priceOfIphone
				.put("ARGENTINA", Float.parseFloat((props
						.getProperty("ARGENTINA.IPHONE.PRICE"))));
		iphone.setAvailableIphones(totalIphones);
		iphone.setPriceOfIphone(priceOfIphone);
	}

	public void parseAndAssignValues(String[] inputValues) {

		for (int i = 0; i < inputValues.length; i++) {

			if (inputValues[i].equalsIgnoreCase(("BRAZIL"))) {
				ipod.setPurchaseCountryName(inputValues[i]);
				iphone.setPurchaseCountryName(inputValues[i]);
			} else if (inputValues[i].equalsIgnoreCase("ARGENTINA")) {
				ipod.setPurchaseCountryName(inputValues[i]);
				iphone.setPurchaseCountryName(inputValues[i]);
			}

			if (inputValues[i]
					.matches("^[b|B][0-9]{3}[a-zA-Z]{2}[a-zA-Z0-9]{7}$")) {
				ipod.setPassportOfCountry("BRAZIL");
				iphone.setPassportOfCountry("BRAZIL");
			} else if (inputValues[i]
					.matches("^[a|A][a-zA-Z]{2}[a-zA-Z0-9]{9}$")) {
				ipod.setPassportOfCountry("ARGENTINA");
				iphone.setPassportOfCountry("ARGENTINA");
			} else {
				ipod.setPassportOfCountry(null);
				iphone.setPassportOfCountry(null);
			}
			if (inputValues[i].equalsIgnoreCase(("IPOD"))) {
				ipod.setNoOfIpodsOrderded((Integer.parseInt(inputValues[i + 1])));
			}
			if (inputValues[i].equalsIgnoreCase(("IPHONE"))) {
				iphone.setNoOfIphonesOrderded((Integer
						.parseInt(inputValues[i + 1])));
			}
		}
	}
}