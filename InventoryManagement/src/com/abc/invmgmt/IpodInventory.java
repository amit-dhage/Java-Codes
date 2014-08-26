package com.abc.invmgmt;

public class IpodInventory {
	int temp1 = 0;
	int temp2 = 0;

	static int cuurentCheapIpodPrice = Integer.MAX_VALUE;

	public static int brazilIpod, argentinaIpod, brazilIphone, argentinaIphone;

	public Integer getChepIpod(InventorySystem inventorySystem, Ipod ipod,
			int fromBrazil, int fromArgentina) {

		temp1 = (int) (ipod.getPriceOfIpod().get("BRAZIL") * fromBrazil);
		try {
			if (ipod.getPurchaseCountryName().equals("ARGENTINA")) {
				if (ipod.getPurchaseCountryName().equals(
						ipod.getPassportOfCountry())
						|| ipod.getPassportOfCountry() == null) {
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

		temp2 = (int) (ipod.getPriceOfIpod().get("ARGENTINA") * fromArgentina);

		try {
			if (ipod.getPurchaseCountryName().equals("BRAZIL")) {
				if (ipod.getPurchaseCountryName().equals(
						ipod.getPassportOfCountry())
						|| ipod.getPassportOfCountry() == null) {
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
		if ((temp1 + temp2) < cuurentCheapIpodPrice) {
			cuurentCheapIpodPrice = (temp1 + temp2);
			brazilIpod = fromBrazil;
			argentinaIpod = fromArgentina;
		}

		return temp1 + temp2;
	}

}
