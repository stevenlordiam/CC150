/** 
 * Chapter 4-Trees and Graphs
 * Question 4-3
 * Given a sorted (increasing order) array with unique integer elements, write an algo- rithm to create a binary search tree with minimal height.
 */

public class TreesAndGraphs_3 {

	public TreeNode createMinimalBST(int arr[]){
		return createMinimalBST(array, 0, array.length-1);
	}

	private TreeNode createMinimalBST(int arr[], int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);			// let the root be the middle of the array
		n.left = createMinimalBST(arr, start, mid-1);
		n.right = createMinimalBST(arr, mid+1, end);
		return n;
	}

}

/*

  key: 
  * To create a tree of minimal height, match left subtree's node number to right subtree
  * Let he root to be the middle of the array, and recursively let the middle of each subsection of the array becomes the root of the node
  * Binary search, recursive solution
  * The algorithm is as follows:
	- Insert into the tree the middle element of the array
	- Insert (into the left subtree) the left subarray elements
	- Insert (into the right subtree) the right subarray elements
	- Recurse

*/