/** 
 * Chapter 4-Trees and Graphs
 * Question 4-1
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */

public class TreesAndGraphs_1 {
	public static int checkHeight(TreeNode root){
		if(root == null){
			return 0; 						
		}

		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1){
			return -1; 						// return -1 if not balanced
		}

		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1){
			return -1; 	
		}

		/* Check if current node is balanced */
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1){
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1; 	// return height = left + right + 1 (itself)
		}
	}	

	public static boolean isBalanced(TreeNode root){
		if(checkHeight(root) == -1){
			return false;
		} else {
			return true;
		}
	}

}

/*

  key: 
  * Use recursive solution to check and get height of subtree level by level

*/