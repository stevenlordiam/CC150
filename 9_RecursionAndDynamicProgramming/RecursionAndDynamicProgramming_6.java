/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-6
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n-pairs of parentheses.
 */

public class RecursionAndDynamicProgramming_6 {
	public void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem<0 || rightRem<leftRem)	return; 	// invalid state
		if(leftRem==0&&rightRem==0){		// no more parens left
			String s = String.copyValueof(str); // return a String that represents the character sequence in the array specified
			list.add(s);
		} else {
			if(leftRem>0){ 		// add left paren, if there are any left parens remaining
				str[count] = '(';
				addParen(list, leftRem-1, rightRem, str, count+1);
			}
			if(rightRem>leftRem){	// add right paren, if expression os valid
				str[count] = ')';
				addParen(list, leftRem, rightRem-1, str, count+1);
			}
		}
	}

	private ArrayList<String> generateParens(int count){
		char[] str = new char[count*2]; 	// left+right should be twice
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);	// start counting from zero
		return list;
	}

}

/*
Similar to Leetcode OJ valid parentheses - https://oj.leetcode.com/problems/valid-parentheses/
					generate parentheses - https://oj.leetcode.com/problems/generate-parentheses/

String.copyValueOf(char[] data) - return a string that represents the character sequence in the array

  key: 
  * Solution 1:
  	- insert a pair of parentheses inside every existing pair of parentheses as well as one at the beginning - remember to check for dups
  * Solution 2:
  	- build the string from scratch to avoid dups. As long as there's left paren, we insert it. Keep the number of right paren the same as left paren
  * DP, store the result of a[n-1] and use it to build a[n]
  * hashmap主要用于key和value比较重要的时候, hashset用在存object检查重复的时候, 都可以用map实现

*/