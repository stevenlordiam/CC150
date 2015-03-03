/** 
 * Chapter 4-Trees and Graphs
 * Question 4-6
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in  a binary search tree. You may assume that each node has a link to its parent.
 */

public class TreesAndGraphs_6 {
	public TreeNode inorderSuccessor(TreeNode n){
		if(n == null){
			return null;
		}
		if(n.right != null){ 	// Found right children -> return leftmost node of right subtree
			return leftmostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.parent;      
			while(x != null && x.left != q){ 	// go up until we're on left instead of right
				q = x;
				x = x.parent;
			}
			return x;
		}
	}

	public TreeNode leftmostChild(TreeNode n){
		if(n == null){
			return null;
		}
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
}

/*

  key: 
  * Inorder traversal, next node is on the right side, and is the leftmost node on the right subtree

*/