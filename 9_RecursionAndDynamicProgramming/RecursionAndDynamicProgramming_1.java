/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-1
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. 
 * Implement a method to count how many possible ways the child can run up the stairs.
 */

public class RecursionAndDynamicProgramming_1 {
	public int recursionCountWays(int n){ 		// recursion solution, O(3^N)
		if(n<0){
			return 0;
		} else if(n==0){
			return 1;
		} else {
			return recursionCountWays(n-1) + recursionCountWays(n-2) + recursionCountWays(n-3);
		}
	}

	public int dpCountWays(int n, int[] map){ 	// DP solution, cache the every-step result using map[n], faster
		if(n<0){
			return 0;
		} else if(n==0){
			return 1;
		} else {
			map[n] = dpCountWays(n-1, map) + dpCountWays(n-2, map) + dpCountWays(n-3, map);
			return map[n];
		}
	}

}

/*
  Similar to Leetcode OJ Climbing Stairs - https://oj.leetcode.com/problems/climbing-stairs/

  key: 
  * Dynamic Programming
  * Like Fibonacci problem, there are recursion solution and DP solution
  * note that the number will flow, use long instead of int

*/