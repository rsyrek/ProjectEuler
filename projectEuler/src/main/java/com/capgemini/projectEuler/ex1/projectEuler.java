package com.capgemini.projectEuler.ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class projectEuler {

	public int sumMultiplesOf3And5Below(int limit) {
		int sum = 0;
		for(int i = 0; i < limit; i++){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		return sum;
	}
	
	public long fibonacci(int limit) {
    	long a = 0, b = 1;
    	long sum = 0;
    	while(b < limit){
    		b=b+a;
    		a=b-a;
    		if(b % 2 == 0){
    			sum += b;
    		}
    	}    	
		return sum;
    }

	public long largestPrimeFactor(long number) {
		long largestFactor = 0;
		
		for (long i = (long) Math.sqrt(number); i > 0; i--){
			if(isPrime(i)){
				if(number % i == 0){
					return i;
				}
			}
		}
		return largestFactor;
	}
	
	public boolean isPrime(long number){
		if(number % 2 == 0){
			return false;
		}
		for(int i = 3; i <= Math.sqrt(number); i += 2){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

	public int diffBetweenSquares(int limit) {
		int diff = 0;
		int first = 0, second = 0;
		for(int i = 1; i <= limit; i++){
			first += Math.pow(i, 2);
		}
		for(int i = 1; i <= limit; i++){
			second += i;
		}
		diff = (int) (Math.pow(second,2) - first);
		return diff;
	}

	public int primeNumber(int position) {
		int prime = 0;
		int index = 1;
		int actual = 3;
		while(index < position){
			if(isPrime(actual++))
				index++;
		}
		return --actual;
	}

	public long greatestProductOfAdjacent(int numbers) {
		long product = 0, temp = 1; 
		int i = 0;
		List<Integer> list = new ArrayList<Integer>();
		InputStream file = null;
		try {
			file = new FileInputStream("C:/Users/rsyrek/Documents/GitHub/ProjectEuler/projectEuler/input.txt");
			while(i < 1000){
				list.add(Integer.parseInt("" + ((char)file.read())));
				i++;
			}
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int j = 0; j < numbers; j++){
			temp *= list.get(j);
			if(product < temp) product = temp;
		}
		for(int j = 0; j < list.size() - numbers; j++){
			temp = 1;
			for(int k = 0; k < numbers; k++){
				temp *= list.get(j + k);
				if(product < temp) product = temp;
			}
			if(product < temp) {
				product = temp;
			}
		}
		return product;
	}

	public long primesSumBelow(long limit) {
		long sum = 2;
		for(int i = 3; i < limit; i++){
			if(isPrime(i)){
				sum += i;
			}
		}
		return sum;
	}

	public long triangleToHaveMoreDivThan(long limit) {
		long triangle = 1;
		long index = 2;
		List<Long> list = new ArrayList<Long>();
		while(list.size() < limit){
			triangle = triangle + index++;
			list = findFactorsOf(triangle);
		}
		return triangle;
	}

	private List<Long> findFactorsOf(long number) {
		List<Long> list = new ArrayList<Long>();
		long befor = 0, actual = 1, index = 2;
		list.add(actual);
		while(index < 5){
			actual = number % index;
			if(actual == 0){
				if(number / index == befor) break;
				befor = index;
				list.add(index);
				list.add(number / index);
			}
			index++;
		}
		return list;
	}

	public int largestPalindrome(int digits) {
		int palindrome = 0;
		String temp = new String();
		int downLimit;
		int upperLimit;
		int part1;
		temp = "1";
		for(int j = 0; j < digits - 1; j++){
			temp += "0";
		}
		downLimit = Integer.parseInt(temp);
		temp += "0";
		upperLimit = downLimit * 10;
		temp = "";
		for(int j = 0; j < digits; j++){
			temp += "9";
		}
		part1 = Integer.parseInt(temp);
		int whole;
		String number = new String();
		boolean done = false;
		while(!done){
			number = Integer.toString(part1) + new StringBuilder(Integer.toString(part1)).reverse().toString();
			whole = Integer.parseInt(number);
			for(int i = downLimit; i < upperLimit; i++){
				if(whole % i == 0 && whole / i < upperLimit){
					done = true;
					palindrome = whole;
					break;
				}
			}
			part1--;
		}
		return palindrome;
	}

	public long smallestNumberDividedBy1To(int to) {
		long number = 0;
		boolean done = true;
		while(true){
			done = true;
			for(int i = to; i > (to / 2); i--){
				if(number == 0 || !(number % i == 0)){
					done = false;
					break;
				}
			}
			if(done){
				break;
			}
			number += to * (to - 1);
		}
		return number;
	}
}