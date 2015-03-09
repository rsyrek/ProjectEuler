package com.capgemini.projectEuler.ex1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



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
			file = new FileInputStream(projectEuler.class.getClassLoader().getResource("input.txt").getPath());
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

	public long largestProductInGrid(int limit) throws IOException {
		long product = 0;
		long tempProduct;
		int index;
		String[] numbersString;
		List<int[]> listOfNumber = new ArrayList<int[]>();
		try(BufferedReader br = new BufferedReader(new FileReader(projectEuler.class.getClassLoader().getResource("problem11.txt").getFile()))) {
			String line = br.readLine();
			while(line !=null) {
				int[] numbers = new int[20];
				numbersString = line.split(" ");
				index = 0;
				for(String s : numbersString){
					numbers[index++] = Integer.parseInt(s);
				}
				listOfNumber.add(listOfNumber.size(), numbers);
				line = br.readLine();
			}
		}
		for(int j = 0; j < listOfNumber.size(); j++){
			for(int i = 0; i < 20 - limit + 1; i++){
				tempProduct = 1;
				for(int k = 0; k < limit; k++){
					tempProduct *= listOfNumber.get(j)[i + k];
				}
				if(tempProduct > product) product = tempProduct;
			}
		}
		for(int j = 0; j < 20; j++){
			for(int i = 0; i < listOfNumber.size() - limit + 1; i++){
				tempProduct = 1;
				for(int k = 0; k < limit; k++){
					tempProduct *= listOfNumber.get(i + k)[j];
				}
				if(tempProduct > product) product = tempProduct;
			}
		}
		for(int i = 0; i < listOfNumber.size() - limit; i++){
			for(int j = 0; j < 20 - limit; j++){
				tempProduct = 1;
				for(int k = 0; k < limit; k++){
					tempProduct = tempProduct * listOfNumber.get(i + k)[j + k];
				}
				if(tempProduct > product) {
					product = tempProduct;
				}
				
			}
		}
		for(int j = 0; j < 20 - limit; j++){
			for(int i = limit - 1; i < listOfNumber.size(); i++){
				tempProduct = 1;
				for(int k = 0; k < limit; k++){
					tempProduct *= listOfNumber.get(i - k)[j + k];
				}
				if(tempProduct > product) product = tempProduct;
			}
		}
		return product;
	}
	
	public long triangleToHaveMoreDivThan(long limit) {
		long triangle = 1;
		long index = 2;
		long size = 0;
		while(size < limit){
			triangle = triangle + index++;
			size = findFactorsOf(triangle);
		}
		return triangle;
	}

	private long findFactorsOf(long number) {
		List<Long> list = new ArrayList<Long>();
		long befor = 1, actual = 1, index = 2;
		list.add(actual);
		while(true){
			actual = number % index;
			if(actual == 0){
				if(number / index == befor) break;
				befor = index;
				list.add(index);
				if ((number / index) == index) break;
				else list.add(number / index);
			}
			index++;
		}
		return list.size();
	}

	public char[] sumOf100BigNumbers(long digits) throws IOException {
		BigDecimal tempResult = new BigDecimal(0);
		int index = 0;
		String allDigits;
		char[] firstDigits = new char[(int) digits];
		BigDecimal[] numbers = new BigDecimal[100];
		try(BufferedReader br = new BufferedReader(new FileReader(projectEuler.class.getClassLoader().getResource("problem13.txt").getFile()))) {
			String line = br.readLine();
			while(line !=null) {
				numbers[index++] = new BigDecimal(line);
				line = br.readLine();
			}
			for(BigDecimal n : numbers){
				tempResult = tempResult.add(n);
			}
			allDigits = String.valueOf(tempResult);
			for(int i = 0; i < digits; i++){
				firstDigits[i] = allDigits.charAt(i);
			}
		}
		return firstDigits;
	}

	public int startingOfLongestChainUnder(int limit) {
		int result = 0, longestChain = 0;
		int index;
		long actual;
		for(int number = 2; number < 1000000; number++){
			index = 0;
			actual = number;
			while(actual != 1){
				if(actual % 2 == 0) actual /= 2;
				else actual = 3 * actual + 1;
				index++;
			}
			if(index > longestChain){
				longestChain = index;
				result = number;
			}
		}
		return result;
	}

	public long numberOfWays(int grid, int posX, int posY) {
		long ways = 0;
		BigDecimal n = new BigDecimal(1);
		long k = 1;
		for(int i = 1; i <= 2 * grid; i++){
			n = n.multiply(new BigDecimal(i));
		}
		for(int i = 1; i <= grid; i++){
			k *= i;
		}
		n = n.divide(new BigDecimal(k));
		n = n.divide(new BigDecimal(k));
		ways = Long.parseLong(n.toString());
		/*if(posX == grid && posY == grid) ways++;
		if(posX < grid) ways = numberOfWays(grid, posX + 1, posY);
		if(posY < grid) ways = numberOfWays(grid, posX, posY + 1);*/
		return ways;
	}

	public int powerDigitSum(int power) {
		BigDecimal powResult = new BigDecimal(2);
		int sum = 0;
		String result;
		powResult = powResult.pow(power);
		result = powResult.toString();
		for(char c : result.toCharArray()){
			sum += Integer.parseInt(c + "");
		}
		return sum;
	}

	public long lettersInNumbers(int limit) {
		int result = 0;
		WordNumber wordNumber = new WordNumber();
		for(int i = 1; i <= limit; i++){
			result += wordNumber.numberToWord(i);
		}
		if(limit == 1000) {
			result += wordNumber.numberToWord(1) + wordNumber.thousand;
			}
		return result;
	}

	public int maxPathSum(String fileName) throws FileNotFoundException, IOException {
		int sum = 0, index, size = 1;
		String[] numbersString;
		List<int[]> listOfNumber = new ArrayList<int[]>();
		try(BufferedReader br = new BufferedReader(new FileReader(projectEuler.class.getClassLoader().getResource(fileName).getFile()))) {
			String line = br.readLine();
			while(line !=null) {
				index = 0;
				int[] numbers = new int[size++];
				numbersString = line.split(" ");
				for(String s : numbersString){
					numbers[index++] = Integer.parseInt(s);
				}
				listOfNumber.add(listOfNumber.size(), numbers);
				line = br.readLine();
			}
			for(int i = listOfNumber.size() - 2; i >= 0; i--){
				index = 0;
				for(int j = 0; j < listOfNumber.get(i).length; j++){
					listOfNumber.get(i)[j] += Math.max(listOfNumber.get(i + 1)[j], listOfNumber.get(i + 1)[j + 1]);
				}
			}
			sum = listOfNumber.get(0)[0];
		}
		return sum;
	}
	
	public int countingSundays(){
		int firstSundays = 0, index = 0, year = 1901, firstDay = 1, daysIn1900 = 0;
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int d : months){
			daysIn1900 += d;
		}
		daysIn1900++;
		firstDay += (daysIn1900 % 7);
		while(year < 2001){
			if(index == 2 && year % 4 == 0 && !(year % 400 == 0)) firstDay += (months[index++] + 1) % 7;
			else firstDay += months[index++] % 7;
			if(firstDay > 7) firstDay -= 7;
			if(firstDay == 7) firstSundays ++;
			if(index == 12) {
				year++;
				index = 0;
			}
		}
		return firstSundays;
	}

	public int factorialDigitSum(int limit) {
		BigDecimal result = new BigDecimal(1);
		int answer = 0;
		char[] numbers;
		while(limit > 0){
			result = result.multiply(new BigDecimal(limit--));
		}
		numbers = result.toString().toCharArray();
		for(char n : numbers){
			answer += Integer.parseInt("" + n);
		}
		return answer;
	}

	public long sumOfAmicableNumbersBelow(int limit){
		long sum = 0;
		List<Integer> unchecked = new ArrayList<Integer>(3);
		long factors = 0;
		for(int i = 4; i <= limit; i++){
			unchecked.add(i);
		}
		for(Integer n : unchecked){
			factors=sumFactorsOf(n);
			if(factors != n && factors != 1 && sumFactorsOf(factors) == n){
				sum += (factors + n);
			}
		}
		return sum / 2;
	}
	
	private long sumFactorsOf(long number){
		
		List<Long> list = new ArrayList<Long>();
		long befor = 1, actual = 1, index = 2, sum = 0;
		list.add(actual);
		while(true){
			actual = number % index;
			if(actual == 0){
				if(number / index == befor) break;
				befor = index;
				list.add(index);
				if ((number / index) == index) break;
				else list.add(number / index);
			}
			index++;
		}
		for( long n : list){
			sum += n;
		}
		return sum;
	}

	public long namesScore(String fileName) throws FileNotFoundException, IOException {
		long sum = 0;
		int index = 1;
		int score = 0;
		String[] namesArray;
		List<String> listOfNames = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(projectEuler.class.getClassLoader().getResource(fileName).getFile()))) {
			String line = br.readLine();
			namesArray = line.split("\",");
			for(String s : namesArray){
				listOfNames.add(s);
			}
			Collections.sort(listOfNames);
			for(String s : listOfNames){
				score = 0;
				for(char c : s.toCharArray()){
					if(c != '\"')
					score += (Character.getNumericValue(c) - 9);
				}
				score *= index++;
				sum += score;
			}
		}
		return sum;
	}
	
	public int fibonacciBig(int n) {
    	BigDecimal a = new BigDecimal(0);
    	BigDecimal b = new BigDecimal(1);
    	int index = 1;
    	while(b.toString().length() < 1000){
    		index++;
    		b = b.add(a);
    		a = b.add(a.negate());
    	}
    	return index;
    }

	
	public long nonAbundantSums(int limit) {
		long sum = 0;
		List<Integer> abundants = new ArrayList<Integer>();
		for(int i = 12; i <= limit; i++){
			if(sumFactorsOf(i) > i){
				abundants.add(i);
			}
		}
		boolean[] array = new boolean[limit];
		for(int n : abundants){
			for(int m : abundants){
				if(n + m < limit){
					array[n + m] = true;
				}
			}
		}
		for(int i = 0; i < array.length; i++){
			if(!array[i]) sum += (i);
		}
		return sum;
	}

	public long lexicographicPerm(long count) {
		long perm = 0;
		List<Integer> haveLeft = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) haveLeft.add(i);
		int[] arrayPerm = new int[10];
		long result = 0;
		int index = 9;
		int digit = 0;
		while(index >= 0){
			result = 0;
			digit = 0;
			while(result < count){
				result = digit * factorial(index);
				digit++;
			}
			digit -= 2;
			count -= digit * factorial(index);
			arrayPerm[9 - index] = haveLeft.remove(digit);
			index--;
		}
		for(int i = 0; i < 10; i++){
			perm += (arrayPerm[i] * Math.pow(10, 9 - i));
		}
		return perm;
	}

	private long factorial(int limit) {
		long result = 1;
		while(limit > 0) result *= limit--;
		return result;
	}

	public long spiralDiagonals(int dim) {
		long sum = 1;
		long limit = dim * dim;
		long index = 0, step = 2, befor = 1;
		
		while(befor < limit){
			sum += befor + step;
			befor += step;
			index++;
			if(index % 4 == 0) step += 2;
		}
		return sum;
	}

	public int distinctPowers(int limit) {
		Set<BigDecimal> distincts = new HashSet<BigDecimal>();
		BigDecimal bD = new BigDecimal(1);
		BigDecimal lim = new BigDecimal(limit);
		BigDecimal a = new BigDecimal(2);
		while(!a.equals(lim.add(bD))){	
			for(int b = 2; b <= limit; b++){
				distincts.add(a.pow(b));
			}
			a = a.add(bD);
		}
		return distincts.size();
	}

	public int digitPowers(int power) {
		int sum = 0;
		int digits = 0, sumOfPowers, number, digit;
		Integer boarder = (int) Math.pow(9,power);
		digits = boarder.toString().toCharArray().length;
		boarder *= digits;
		digits = boarder.toString().toCharArray().length;
		boarder *= digits;
		for(int i = 2; i <= boarder; i++){
			sumOfPowers = 0;
			number = i;
			while(number > 0){
				digit = number % 10;
				sumOfPowers += speedPowerForInts(power, digit);
				number /= 10;
			}
			if(sumOfPowers == i) sum += i;
		}
		return sum;
	}

	public int speedPowerForInts(int power, int digit) {
		int powerDigit;
		powerDigit = digit;
		for(int j = 2; j <= power; j++){
			powerDigit *= digit;
		}
		return powerDigit;
	}
	
	public int coinSum(int amount){
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int m = coins.length;
		int solutions = 0;
		solutions = giveMeChange(coins, m, amount);
		return solutions;
	}

	private int giveMeChange(int[] coins, int m, int amount) {
		if(amount == 0) return 1;
		if(amount < 0) return 0;
		if(amount > 0 && m <= 0) return 0;
		return giveMeChange(coins, m - 1, amount) + giveMeChange(coins, m, amount - coins[m - 1]);
	}
	
}