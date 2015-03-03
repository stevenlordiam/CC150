/** 
 * Chapter 4-Trees and Graphs
 * Question 4-5
 * Implement a function to check if a binary tree is a binary search tree.
 */

public class TreesAndGraphs_5 {		// Min/Max solution
	public boolean checkBST(TreeNode n){
		return checkBST(n, null, null);
	}

	public boolean checkBST(TreeNode n, Integer min, Integer max){
		if(n == null){
			return true;
		}
		if((min!=null && n.data<=min) || (max!=null && n.data>max)){
			return false;
		}
		if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)){
			return false;
		}
		return true;
	}
}

/*
  Similar to Leetcode OJ Validate Binary Search Tree - https://oj.leetcode.com/problems/validate-binary-search-tree/
	
  BST: left <= root < right

  key: 
  * Solution 1: in order traversal
  - do in order traversal, copy the elements to an array, and check if it's sorted
  - but it cannot handle duplicate values
  - imporve: array is not necessary, just track the last element and compare it on the go

  * Solution 2: Min/Max solution
  - ALL left nodes <= root < ALL right nodes
  - pass down the min and max value
  - time O(N), space O(logN)

*/


// in order traversal
public static Integer last_printed = null;
public static boolean checkBST(TreeNode n){
	if(n == null)	return true;
	if(!checkBST(n.left))	return false;		// check / recurse left
	if(last_printed != null && n.data <= last_printed)	return false; 		// check current
	last_printed = n.data;
	if(!checkBST(n.right))	return false;		// check / recurse right
	return true;
}