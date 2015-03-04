package com.capgemini.projectEuler.part1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.capgemini.projectEuler.ex1.projectEuler;


public class part1Test {
	projectEuler mult = new projectEuler();
	
	@Test
	public void shouldRetur23WhenGiven10(){
		Assertions.assertThat(mult.sumMultiplesOf3And5Below(10)).isEqualTo(23);
	}
	
	@Test
	public void shouldRetur23WhenGiven1000(){
		Assertions.assertThat(mult.sumMultiplesOf3And5Below(1000)).isEqualTo(233168);
	}
	
	@Test
	public void shouldReturnWhenGiven4M(){
		Assertions.assertThat(mult.fibonacci(4000000)).isEqualTo(4613732);
	}
	
	@Test
	public void shouldReturn29WhenGiven13195(){
		Assertions.assertThat(mult.largestPrimeFactor(13195)).isEqualTo(29);
	}
	
	@Test
	public void shouldReturn29WhenGiven600851475143(){
		Assertions.assertThat(mult.largestPrimeFactor(600851475143L)).isEqualTo(6857);
	}
	
	@Test
	public void shouldReturn9009WhenGiven2(){
		Assertions.assertThat(mult.largestPalindrome(2)).isEqualTo(9009);
	}
	
	@Test
	public void shouldReturn906609WhenGiven3(){
		Assertions.assertThat(mult.largestPalindrome(3)).isEqualTo(906609);
	}
	
	@Test
	public void shouldReturn2520WhenGiven1And10(){
		Assertions.assertThat(mult.smallestNumberDividedBy1To(10)).isEqualTo(2520);
	}
	
	@Test
	public void shouldReturn232792560WhenGiven1And20(){
		Assertions.assertThat(mult.smallestNumberDividedBy1To(20)).isEqualTo(232792560);
	}
	
	@Test 
	public void shouldReturn2640WhenGiven10(){
		Assertions.assertThat(mult.diffBetweenSquares(10)).isEqualTo(2640);
	}
	
	@Test 
	public void shouldReturn2640WhenGiven100(){
		Assertions.assertThat(mult.diffBetweenSquares(100)).isEqualTo(25164150);
	}
	
	@Test 
	public void shouldReturn13WhenGiven6(){
		Assertions.assertThat(mult.primeNumber(6)).isEqualTo(13);
	}
	
	@Test 
	public void shouldReturn13WhenGiven10001(){
		Assertions.assertThat(mult.primeNumber(10001)).isEqualTo(104743);
	}
	
	@Test
	public void shouldReturn5832WhenGiven4(){
		Assertions.assertThat(mult.greatestProductOfAdjacent(4)).isEqualTo(5832);
	}
	
	@Test
	public void shouldReturn5832WhenGiven13(){
		Assertions.assertThat(mult.greatestProductOfAdjacent(13)).isEqualTo(23514624000L);
	}
	
	@Test
	public void shouldReturn17WhenGiven10(){
		Assertions.assertThat(mult.primesSumBelow(10)).isEqualTo(17);
	}
	
	@Test
	public void shouldReturn142913828922WhenGiven2M(){
		Assertions.assertThat(mult.primesSumBelow(2000000)).isEqualTo(142913828922L);
	}
	
	@Test
	public void shouldReturn70600674WhenGiven4() throws IOException{
		Assertions.assertThat(mult.largestProductInGrid(4)).isEqualTo(70600674);
	}
	
	@Test
	public void shouldReturn28WhenGiven5(){
		Assertions.assertThat(mult.triangleToHaveMoreDivThan(5)).isEqualTo(28);
	}
	
	@Test
	public void shouldReturn76576500WhenGiven500(){
		Assertions.assertThat(mult.triangleToHaveMoreDivThan(500)).isEqualTo(76576500);
	}
	
	@Test
	public void shouldReturn5537376230WhenGiven10() throws IOException{
		Assertions.assertThat(mult.sumOf100BigNumbers(10)).isEqualTo(new char[]{'5','5','3','7','3','7','6','2','3','0'});
	}
	
	@Test
	public void shouldReturn837799WhenGiven1M(){
		Assertions.assertThat(mult.startingOfLongestChainUnder(1000000)).isEqualTo(837799);
	}
	
	@Test
	public void shouldReturn6WhenGiven2(){
		Assertions.assertThat(mult.numberOfWays(2, 0, 0)).isEqualTo(6);
	}
	
	/*@Test
	public void shouldReturn6WhenGiven20(){
		Assertions.assertThat(mult.numberOfWays(20, 0, 0)).isEqualTo(6);
	}*/
	
	@Test
	public void shouldReturn26whenGiven15(){
		Assertions.assertThat(mult.powerDigitSum(15)).isEqualTo(26);
	}
	
	@Test
	public void shouldReturn19WhenGiven5(){
		Assertions.assertThat(mult.lettersInNumbers(1000)).isEqualTo(21124);
	}
	
	@Test
	public void shouldReturn23WhenGiven4RowTriangle() throws FileNotFoundException, IOException{
		Assertions.assertThat(mult.maxPathSum("triangle1.txt")).isEqualTo(23);
	}
	
	@Test
	public void shouldReturn1074WhenGiven15RowTriangle() throws FileNotFoundException, IOException{
		Assertions.assertThat(mult.maxPathSum("triangle2.txt")).isEqualTo(1074);
	}
	
	@Test
	public void shouldReturn7273WhenGiven100RowTriangle() throws FileNotFoundException, IOException{
		Assertions.assertThat(mult.maxPathSum("p067_triangle.txt")).isEqualTo(7273);
	}
	
	@Test
	public void shouldReturn27WhenGiven10(){
		Assertions.assertThat(mult.factorialDigitSum(10)).isEqualTo(27);
	}
	
	@Test
	public void shouldReturn648WhenGiven100(){
		Assertions.assertThat(mult.factorialDigitSum(100)).isEqualTo(648);
	}
}