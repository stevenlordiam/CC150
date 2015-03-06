/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-4
 * Write a method to return all subsets of a set
 */

public class RecursionAndDynamicProgramming_4 {
	public ArrayList<ArrayList<Integer>> solutionOne(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index) { 	// base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); 	// empty set
		} else {
			allsubsets = solutionOne(set, index+1);
			int item = set.get(index);			// element a[n]
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);		// clone
				newsubset.add(item);			// add a[n] in
				moresubsets.add(newsubset);		// add to result
			}
			allsubsets.addAll(moresubsets;)
		}
		return allsubsets;
	}



	public ArrayList<ArrayList<Integer>> solutionTwo(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1<<set.size(); 	// compute 2^n
		for(int k=0; k<max; k++){
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int k=x; k>0; k>>=1){	// 每次除以2，右移一位
			if((k&1)==1){ 	// (k&1)==1 (???)
				subset.add(set.get(index));	// 某位为1时，表示在subset里，add element into subset
			}
			index++;
		}
		return subset;
	}
}

/*
  Similar to Leetcode OJ subsets:
  https://oj.leetcode.com/problems/subsets/ 
  https://oj.leetcode.com/problems/subsets-ii/

  key: 
  * Solution 1: recursion - base case and build
    - compute n=0, n=1, n=2, n=3, found the rule
    - compute P(n-1), clone the results, and then add a[n] to each of these cloned sets
    - O(2^n) time and space, 2^n subsets

  * Solution 2: combinatorics
    - for each element, there is two state(in a subset or not), so each subset is a sequence of yes/no, it can be represented as a binary string
    - iterate through all numbers from 1 to 2^n and translate the binary representation of the numbers into a set

*/