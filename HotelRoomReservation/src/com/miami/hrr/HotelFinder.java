package com.miami.hrr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelFinder {

	public static String findCheapHotel(String rawInput) {

		String customerType = rawInput.substring(0, 7);
		String[] rawDates = rawInput.substring(9).split("\\,");

		List<Date> dates = new ArrayList<Date>();
		for (String eachDate : rawDates) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
				dates.add(formatter.parse(eachDate.trim().replaceAll(
						"\\(\\w+\\)", "")));
			} catch (ParseException e) {
				System.out
						.println("Wrong Input Please Enter the correct Input as stated");
			}
		}
		Map<String, Integer> fianlHotelRates = findHotelRateonDates(
				customerType, dates);

		String minKey = null;
		int minValue = Integer.MAX_VALUE;
		for (String key : fianlHotelRates.keySet()) {
			int value = fianlHotelRates.get(key);
			if (value < minValue) {
				minValue = value;
				minKey = key;
			}
		}
		return minKey;
	}

	private static Map<String, Integer> findHotelRateonDates(
			String customerType, List<Date> dates) {
		HotelRates hotelRates = new HotelRates();
		Map<String, Integer> fianlhotelRates = new HashMap<String, Integer>();
		int lakeWoodTotal = 0;
		int bridgeWoodTotal = 0;
		int ridgeWoodTotal = 0;

		switch (customerType) {
		case "Regular":
			for (Date currentDate : dates) {
				if (isWeekEnd(currentDate)) {
					lakeWoodTotal += hotelRates.getLW_WeekEnd_RGL();
					bridgeWoodTotal += hotelRates.getBW_WeekEnd_RGL();
					ridgeWoodTotal += hotelRates.getRW_WeekEnd_RGL();
				} else {
					lakeWoodTotal += hotelRates.getLW_WeekDay_RGL();
					bridgeWoodTotal += hotelRates.getBW_WeekDay_RGL();
					ridgeWoodTotal += hotelRates.getRW_WeekDay_RGL();
				}
			}
			break;

		case "Rewards":
			for (Date currentDate : dates) {
				if (isWeekEnd(currentDate)) {
					lakeWoodTotal += hotelRates.getLW_WeekEnd_RWD();
					bridgeWoodTotal += hotelRates.getBW_WeekEnd_RWD();
					ridgeWoodTotal += hotelRates.getRW_WeekEnd_RWD();
				} else {
					lakeWoodTotal += hotelRates.getLW_WeekDay_RWD();
					bridgeWoodTotal += hotelRates.getBW_WeekDay_RWD();
					ridgeWoodTotal += hotelRates.getRW_WeekDay_RWD();
				}
			}
			break;
		default:
			System.out
					.println("Wrong Input Please input Customer Type as either 'Regular' or 'Rewards'");

			break;
		}

		fianlhotelRates.put("Lakewood", lakeWoodTotal);
		fianlhotelRates.put("Bridgewood", bridgeWoodTotal);
		fianlhotelRates.put("RidgeWood", ridgeWoodTotal);

		return fianlhotelRates;
	}

	private static boolean isWeekEnd(Date currentDate) {

		Calendar startDate = Calendar.getInstance();
		startDate.setTime(currentDate);

		if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			return true;
		} else {

			return false;
		}
	}
}
