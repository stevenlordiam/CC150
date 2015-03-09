/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-5
 * Write a method to compute all permutations of a string
 */

public class RecursionAndDynamicProgramming_5 {
	public ArrayList<String> getPerms(String str){
		if(str == null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0){ 			// base case
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0); 	// get the first character, [0]
		String remainder = str.substring(1); 	// remove the 1st character, [1, end)
		ArrayList<String> words = getPerms(remainder); 		// recursion
		for(String word : words){
			for(int j=0; j<=word.lenghth(); j++){
				String s = insertCharAt(word, first, j);	// insert at every spot
				permutations.add(s);
			}
		}
		return permutations;
	}

	private String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i); 	// [0, i)
		String end = word.substring(i);	 		// [i, end)	
		return start + c + end;				
	}

}

/*
Similar to Leetcode OJ Permutations - https://leetcode.com/problems/permutations/

Base case and build approach, similar to CC150 (9-4) subsets

str.substring(i) - return the substring using i as beginning index

  key: 
  * Base Case and Build approach - think, how can we get n using n-1 ?
  * find the rule: solve for f(n-1) and push a[n] into every spot in each of these strings
  * O(n!) time, since there are n! permutations

*/