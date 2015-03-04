/** 
 * Chapter 4-Trees and Graphs
 * Question 4-9
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given value. The path does not need to start or end at the root or a leaf.
 */

public class TreesAndGraphs_9 {
	public void findSum(TreeNode node, int sum, int[] path, int level){
		if(node == null){
			return;
		}

		path[level] = node.data; 			// insert current node into path

		int t = 0;
		for(int i=level; i>=0; i--){ 		// look for paths with a sum that ends at this node
			t += path[i];
			if(t == sum){
				print(path, i, level);
			}
		}

		findSum(node.left, sum, path, level+1);
		findSum(node.right, sum, path, level+1);

		path[level] = Integer.MIN_VALUE; 	// remove current node from path

	}

	public void findSum(TreeNode node, int sum){
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}

	public void print(int[] path, int start, int end){
		for(int i=start; i<=end; i++){
			System.out.println(path[i]);
		}
		System.out.println();
	}

	public int depth(TreeNode node){
		if(node == null){
			return 0;
		} else {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}
}

/*
  Similar to Leetcode OJ Path Sum I/II:
  https://oj.leetcode.com/problems/path-sum/
  https://oj.leetcode.com/problems/path-sum-ii/

  key: 
  * node value is not definately positive, if we sum to zero, we still need to traverse this path because negative values may exist
  * look up to see if a path with a sum may ends at this node
  * O(NlogN) time, O(logN) space

*/