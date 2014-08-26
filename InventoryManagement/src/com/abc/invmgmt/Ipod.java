package com.abc.invmgmt;

import java.util.Map;

public class Ipod extends Item {

	private int noOfIpodsOrderded;
	private Map<String, Float> priceOfIpod;
	private Map<String, Integer> availableIpods;

	public int getNoOfIpodsOrderded() {
		return noOfIpodsOrderded;
	}

	public void setNoOfIpodsOrderded(int noOfIpodsOrderded) {
		this.noOfIpodsOrderded = noOfIpodsOrderded;
	}

	public Map<String, Float> getPriceOfIpod() {
		return priceOfIpod;
	}

	public void setPriceOfIpod(Map<String, Float> priceOfIpod) {
		this.priceOfIpod = priceOfIpod;
	}

	public Map<String, Integer> getAvailableIpods() {
		return availableIpods;
	}

	public void setAvailableIpods(Map<String, Integer> availableIpods) {
		this.availableIpods = availableIpods;
	}

	@Override
	public String toString() {
		return "Ipod [noOfIpodsOrderded=" + noOfIpodsOrderded
				+ ", priceOfIpod=" + priceOfIpod + ", availableIpods="
				+ availableIpods + ", CountryName=" + getPurchaseCountryName()
				+ ", PassportOfCountry=" + getPassportOfCountry() + "]";
	}

}
