package com.capgemini.projectEuler.ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
			System.out.println("Wczytuje");
			while(i < 1000){
				//list.add(file.read());
				list.add(Integer.parseInt("" + ((char)file.read())));
				System.out.println(i);
				i++;
			}
			System.out.println("Wczytuje");
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Wczytalem");
		for(int j = 0; j < numbers; j++){
			temp *= list.get(j);
			if(product < temp) product = temp;
		}
		System.out.println("size: " + list.size());
		for(int j = 0; j < list.size() - numbers; j++){
			System.out.println("for: " + j);
			temp = 1;
			for(int k = 0; k < numbers; k++){
				temp *= list.get(j + k);
				if(product < temp) product = temp;
			}
			//temp /= list.get(j);
			//temp *= list.get(j + numbers);
			if(product < temp) {
				product = temp;
			}
		}
		return product;
	}

	/*public int largestPalindrome(int digits) {
		int palindrome = 0, number, multipleOne, multipleTwo;
		String temp = new String("");
		String norm = new String("");
		String reverse = new String("");
		String part1 = new String("");
		String part2 = new String("");
		boolean same = false;
		boolean checked = false;
		for(int i = 0; i < digits; i++){
			temp += "9";
		}
		number = Integer.parseInt(temp);
		number *= number;
		
		norm = Integer.toString(number);
		for(int k = 0; k < norm.length() / 2; k++){
			part1 += norm.charAt(k);
		}
		part2 = new StringBuilder(part1).reverse().toString();
		norm = part1 + part2;
		multipleOne = Integer.parseInt(norm);
		if ()
		while(!same){
			
			norm = Integer.toString(number);
			reverse = new StringBuilder(norm).reverse().toString();
			if(norm.equals(reverse)){
				same = true;
			}
		}
		
		for(int j = 999; j >= 100; j--){
			multipleTwo = number / j;
			if(j * multipleTwo == number){
				checked = true;
				palindrome = number;
				break;
			}
		}

		return palindrome;
	}*/
	
	
}