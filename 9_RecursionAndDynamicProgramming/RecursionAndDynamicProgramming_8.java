/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-8
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent)
 * Write code to calculate the number of ways of representing n cents
 */

public class RecursionAndDynamicProgramming_8 {
	public int makeChange(int n){
		int[] denoms = {25, 10, 5, 1};
		int[][] map = new int[n+1][denoms.length];		// precomputed values
		return makeChange(n, denoms, 0, map);
	}
	private int makeChange(int amount, int[] denoms, int index, int[][] map){
		if(map[amount][index]>0){		// retrieve value
			return map[amount][index];
		}
		if(index>=denoms.length-1)	return 1;	// one denom remaining
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i=0; i*denomAmount<=amount; i++){	// go to next denom, assuming i coins of denomAmount
			int amountRemaining = amount - i*denomAmount;
			ways += makeChange(amountRemaining, denoms, index+1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
} 

/*

  key: 
  * DP solution, see the detail in the book

*/