package com.capgemini.projectEuler.part1;

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
	
	/*@Test
	public void shouldReturn9009WhenGiven2(){
		Assertions.assertThat(mult.largestPalindrome(2)).isEqualTo(9009);
	}*/
	
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
}