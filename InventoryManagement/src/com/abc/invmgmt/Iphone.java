package com.abc.invmgmt;

import java.util.Map;

public class Iphone extends Item {

	private int noOfIphonesOrderded;
	private Map<String, Float> priceOfIphone;
	private Map<String, Integer> availableIphones;

	public int getNoOfIphonesOrderded() {
		return noOfIphonesOrderded;
	}

	public void setNoOfIphonesOrderded(int noOfIphonesOrderded) {
		this.noOfIphonesOrderded = noOfIphonesOrderded;
	}

	public Map<String, Float> getPriceOfIphone() {
		return priceOfIphone;
	}

	public void setPriceOfIphone(Map<String, Float> priceOfIphone) {
		this.priceOfIphone = priceOfIphone;
	}

	public Map<String, Integer> getAvailableIphones() {
		return availableIphones;
	}

	public void setAvailableIphones(Map<String, Integer> availableIphones) {
		this.availableIphones = availableIphones;
	}

	@Override
	public String toString() {
		return "Iphone [noOfIphonesOrderded=" + noOfIphonesOrderded
				+ ", priceOfIphone=" + priceOfIphone + ", availableIphones="
				+ availableIphones + ", CountryName=" + getPurchaseCountryName()
				+ ", PassportOfCountry=" + getPassportOfCountry() + "]";
	}

}
