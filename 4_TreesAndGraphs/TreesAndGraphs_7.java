/** 
 * Chapter 4-Trees and Graphs
 * Question 4-7
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */

public class TreesAndGraphs_7 {
	public boolean covers(TreeNode root, TreeNode p){ 	// return true if p is a descendent of root
		if(root == null) return false;
		if(root = p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		if(root == p || root == q) return root;

		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);

		if(is_p_on_left != is_q_on_left) return root; 	// if p and q are on different sides, return root

		TreeNode child_side = is_p_on_left?root.left:root.right; 	// else, they are on the same side. Traverse this side
		return commonAncestorHelper(child_side, p, q);
	}

	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root, p) || !covers(root, q)){ 		// error check
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}
}

/*

  key: 
  * O(N) time
  * See solution 2 in the book

*/