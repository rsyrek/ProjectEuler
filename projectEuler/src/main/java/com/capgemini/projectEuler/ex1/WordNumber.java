package com.capgemini.projectEuler.ex1;

public class WordNumber {
	private final static int one = 3;
	private final static int two = 3;
	private final static int three = 5;
	private final static int four = 4;
	private final static int five = 4;
	private final static int six = 3;
	private final static int seven = 5;
	private final static int eight = 5;
	private final static int nine = 4;
	private final static int ten = 3;
	private final static int eleven = 6;
	private final static int twelve = 6;
	private final static int thirteen = 8;
	private final static int _teen = 4;
	private final static int fifteen = 7;
	private final static int eighteen = 8;
	private final static int twenty = 6;
	private final static int thirty = 6;
	private final static int forty = 5;
	private final static int fifty = 5;
	private final static int _ty = 2;
	private final static int eighty = 6;
	private final static int hundred = 7;
	private final static int and = 3;
	
	public final int thousand = 8;
	
	public int numberToWord(int number) {
		int result = 0;
		
		int ones = number % 10;
		int tens = (number % 100) - ones;
		int hundreds = (number % 1000) - tens - ones;
		if(tens > 9) tens /= 10;
		if(hundreds > 9) hundreds /= 100;
		
		result += digitLetters(hundreds);
		if(hundreds == 1) result += hundred;
		else if(hundreds != 0) result += hundred;
		if(hundreds != 0 && (ones != 0 || tens != 0)) result += and;
		if(tens != 1){
			if(tens == 2) result += twenty;
			else if(tens == 3) result += thirty;
			else if(tens == 4) result += forty;
			else if(tens == 5) result += fifty;
			else if(tens == 8) result += eighty;
			else if(tens != 0) {
				result += (digitLetters(tens) + _ty);
			}
			result += digitLetters(ones);
		}
		else if(tens == 1){
			if(ones == 0) result += ten;
			else{
				if(ones == 1) result += eleven;
				else if(ones == 2) result += twelve;
				else if(ones == 3) result += thirteen;
				else if(ones == 5) result += fifteen;
				else if(ones == 8) result += eighteen;
				else{
					result += digitLetters(ones) + _teen;
				}
			}
		}
		return result;
	}

	private int digitLetters(int digit) {
		int letters = 0;
		switch (digit){
		case 1:
			letters = one;
			break;
		case 2:
			letters = two;
			break;
		case 3:
			letters = three;
			break;
		case 4:
			letters = four;
			break;
		case 5:
			letters = five;
			break;
		case 6:
			letters = six;
			break;
		case 7:
			letters = seven;
			break;
		case 8:
			letters = eight;
			break;
		case 9:
			letters = nine;
			break;
		default:
			letters = 0;
			break;
		}
		return letters;
	}
}
