/** 
 * Chapter 4-Trees and Graphs
 * Question 4-8
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */

public class TreesAndGraphs_8 {
	public boolean containsTree(TreeNode t1, TreeNode t2){
		if(t2 == null){ 		// The empty tree is always a subtree (REMEMBER THIS!!!)
			return true;
		}
		return subTree(t1, t2);
	}

	public boolean subTree(TreeNode r1, TreeNode r2){
		if(r1 == null){
			return false; 
		}
		if(r1.data == r2.data){	 		// found a node in T1 matching the root of T2
			if(matchTree(r1, r2)) 	return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}

	public boolean matchTree(TreeNode r1, TreeNode r2){ 		// check if two trees are identical
		if(r2 == null && r1 == null){
			return true;
		}
		if(r1 == null || r2 == null){
			return false;
		}
		if(r1.data != r2.data){
			return false;
		}
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
	}
}

/*
  
  key: 
  * At first glance, if the tree is small, we can create a string representing the in-order and pre-order traversals. This solution has O(N+M) time, O(N+M) space
  * But it's not BST, so we have to insert a special character into string to indicate NULL
  * If tree is large, we can search the large tree, each time we found a node matching the root of T2, we compare the two subtrees to see if they are identical. This solution has O(NM) time, O(logN+logM) space

*/