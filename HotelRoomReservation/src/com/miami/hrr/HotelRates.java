package com.miami.hrr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HotelRates {

	@SuppressWarnings("unused")
	private int LW_WeekDay_RGL;
	@SuppressWarnings("unused")
	private int LW_WeekEnd_RGL;
	@SuppressWarnings("unused")
	private int LW_WeekDay_RWD;
	@SuppressWarnings("unused")
	private int LW_WeekEnd_RWD;
	@SuppressWarnings("unused")
	private int BW_WeekDay_RGL;
	@SuppressWarnings("unused")
	private int BW_WeekEnd_RGL;
	@SuppressWarnings("unused")
	private int BW_WeekDay_RWD;
	@SuppressWarnings("unused")
	private int BW_WeekEnd_RWD;
	@SuppressWarnings("unused")
	private int RW_WeekDay_RGL;
	@SuppressWarnings("unused")
	private int RW_WeekEnd_RGL;
	@SuppressWarnings("unused")
	private int RW_WeekDay_RWD;
	@SuppressWarnings("unused")
	private int RW_WeekEnd_RWD;

	Properties props = null;

	public HotelRates() {
		props = new Properties();
		String filePath = "input/hotelRates.properties";
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

	public int getLW_WeekDay_RGL() {
		return Integer.parseInt(props.getProperty("LW_WeekDay_RGL"));

	}

	public int getLW_WeekEnd_RGL() {
		return Integer.parseInt(props.getProperty("LW_WeekEnd_RGL"));
	}

	public int getLW_WeekDay_RWD() {
		return Integer.parseInt(props.getProperty("LW_WeekDay_RWD"));
	}

	public int getLW_WeekEnd_RWD() {
		return Integer.parseInt(props.getProperty("LW_WeekEnd_RWD"));
	}

	public int getBW_WeekDay_RGL() {
		return Integer.parseInt(props.getProperty("BW_WeekDay_RGL"));
	}

	public int getBW_WeekEnd_RGL() {
		return Integer.parseInt(props.getProperty("BW_WeekEnd_RGL"));
	}

	public int getBW_WeekDay_RWD() {
		return Integer.parseInt(props.getProperty("BW_WeekDay_RWD"));
	}

	public int getBW_WeekEnd_RWD() {
		return Integer.parseInt(props.getProperty("BW_WeekEnd_RWD"));
	}

	public int getRW_WeekDay_RGL() {
		return Integer.parseInt(props.getProperty("RW_WeekDay_RGL"));
	}

	public int getRW_WeekEnd_RGL() {
		return Integer.parseInt(props.getProperty("RW_WeekEnd_RGL"));
	}

	public int getRW_WeekDay_RWD() {
		return Integer.parseInt(props.getProperty("RW_WeekDay_RWD"));
	}

	public int getRW_WeekEnd_RWD() {
		return Integer.parseInt(props.getProperty("RW_WeekEnd_RWD"));
	}

}
