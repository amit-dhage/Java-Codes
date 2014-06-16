package com.crimezero.sms;

public class NumbersAndChars {

	public enum Names {
		N1('@', '.', '?', ' '), N2('A', 'B', 'C', ' '), N3('D', 'E', 'F', ' '), N4(
				'G', 'H', 'I', ' '), N5('J', 'K', 'L', ' '), N6('M', 'N', 'O',
				' '), N7('P', 'Q', 'R', 'S'), N8('T', 'U', 'V', ' '), N9('W',
				'X', 'Y', 'Z');
		private char firstChar;
		private char secondChar;
		private char thirdChar;
		private char fourthChar;

		private Names(char firstChar, char secondChar, char thirdChar,
				char fourthChar) {
			this.firstChar = firstChar;
			this.secondChar = secondChar;
			this.thirdChar = thirdChar;
			this.fourthChar = fourthChar;
		}

		public char getFirstChar() {
			return firstChar;
		}

		public void setFirstChar(char firstChar) {
			this.firstChar = firstChar;
		}

		public char getSecondChar() {
			return secondChar;
		}

		public void setSecondChar(char secondChar) {
			this.secondChar = secondChar;
		}

		public char getThirdChar() {
			return thirdChar;
		}

		public void setThirdChar(char thirdChar) {
			this.thirdChar = thirdChar;
		}

		public char getFourthChar() {
			return fourthChar;
		}

		public void setFourthChar(char fourthChar) {
			this.fourthChar = fourthChar;
		}

	};// Names

}
