package com.crimezero.sms;

public class GetChars {

	StringBuffer relatedNameChars = new StringBuffer();

	public String find(char i) {
		switch (i) {
		case '1':
			relatedNameChars.append(NumbersAndChars.Names.N1.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N1.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N1.getThirdChar());
			break;

		case '2':
			relatedNameChars.append(NumbersAndChars.Names.N2.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N2.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N2.getThirdChar());
			break;

		case '3':
			relatedNameChars.append(NumbersAndChars.Names.N3.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N3.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N3.getThirdChar());
			break;

		case '4':
			relatedNameChars.append(NumbersAndChars.Names.N4.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N4.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N4.getThirdChar());
			break;

		case '5':
			relatedNameChars.append(NumbersAndChars.Names.N5.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N5.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N5.getThirdChar());
			break;

		case '6':
			relatedNameChars.append(NumbersAndChars.Names.N6.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N6.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N6.getThirdChar());
			break;

		case '7':
			relatedNameChars.append(NumbersAndChars.Names.N7.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N7.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N7.getThirdChar());
			relatedNameChars.append(NumbersAndChars.Names.N7.getFourthChar());
			break;

		case '8':
			relatedNameChars.append(NumbersAndChars.Names.N8.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N8.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N8.getThirdChar());
			break;

		case '9':
			relatedNameChars.append(NumbersAndChars.Names.N9.getFirstChar());
			relatedNameChars.append(NumbersAndChars.Names.N9.getSecondChar());
			relatedNameChars.append(NumbersAndChars.Names.N9.getThirdChar());
			relatedNameChars.append(NumbersAndChars.Names.N9.getFourthChar());
			break;

		}
		return relatedNameChars.toString();
	}
}
