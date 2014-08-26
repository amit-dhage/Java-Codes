package com.abc.invmgmt;

public class IphoneInventory {
	int temp1 = 0;
	int temp2 = 0;

	static int cuurentCheapIphonePrice = Integer.MAX_VALUE;

	public static int brazilIpod, argentinaIpod, brazilIphone, argentinaIphone;

	public Integer getChepIphone(InventorySystem inventorySystem,
			Iphone iphone, int fromBrazil, int fromArgentina) {

		temp1 = (int) (iphone.getPriceOfIphone().get("BRAZIL") * fromBrazil);
		try {
			if (iphone.getPurchaseCountryName().equals("ARGENTINA")) {
				if (iphone.getPurchaseCountryName().equals(
						iphone.getPassportOfCountry())
						|| iphone.getPassportOfCountry() == null) {
					temp1 += (fromBrazil == 0 || fromBrazil % 10 == 0) ? ((fromBrazil / 10) * 400)
							: ((fromBrazil / 10 + 1) * 400);
				} else {
					temp1 += (fromBrazil == 0 || fromBrazil % 10 == 0) ? ((fromBrazil / 10) * 320)
							: ((fromBrazil / 10 + 1) * 320);
				}
			}
		} catch (Exception e) {
			System.out
					.println("You have entered wrong input, Please Enter it with given Syntax.");
		}

		temp2 = (int) (iphone.getPriceOfIphone().get("ARGENTINA") * fromArgentina);
		try {
			if (iphone.getPurchaseCountryName().equals("BRAZIL")) {
				if (iphone.getPurchaseCountryName().equals(
						iphone.getPassportOfCountry())
						|| iphone.getPassportOfCountry() == null) {
					temp2 += (fromArgentina == 0 || fromArgentina % 10 == 0) ? ((fromArgentina / 10) * 400)
							: ((fromArgentina / 10 + 1) * 400);
				} else {
					temp2 += (fromArgentina == 0 || fromArgentina % 10 == 0) ? ((fromArgentina / 10) * 320)
							: ((fromArgentina / 10 + 1) * 320);
				}
			}
		} catch (Exception e) {
			System.out
					.println("You have entered wrong input, Please Enter it with given Syntax.");
		}
		if ((temp1 + temp2) < cuurentCheapIphonePrice) {
			cuurentCheapIphonePrice = (temp1 + temp2);
			brazilIphone = fromBrazil;
			argentinaIphone = fromArgentina;
		}

		return temp1 + temp2;
	}
}
