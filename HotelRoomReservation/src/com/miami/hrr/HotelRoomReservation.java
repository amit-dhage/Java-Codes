package com.miami.hrr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HotelRoomReservation {
	public static void main(String[] args) {
		String cheapHotel = null;
		String filePath = "input/hotelRates.properties";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("Filename with Path  " + filePath
					+ "is NOT found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String fileLocation = "input/sampleInput";
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(fileLocation));
			String str;

			List<String> lines = new ArrayList<String>();
			while ((str = in.readLine()) != null) {
				lines.add(str);
			}
			for (String rawInput : lines) {
				cheapHotel = HotelFinder.findCheapHotel(rawInput);
				System.out.println(cheapHotel);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Filename with Path  " + filePath
					+ "is NOT found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
