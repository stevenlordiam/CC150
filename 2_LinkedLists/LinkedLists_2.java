/** 
 * Chapter 2-Linked Lists
 * Question 2-2
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class LinkedLists_2{
	public static int nthToLast(LinkedListNode head, int k){
		if(head == null){
			return 0;
		}
		int i = nthToLast(head.next,k)+1;		// recursive
		if(i==k){
			System.out.println(head.data);
		}
		return i;
	}

}

/*

  key: 
  * Always remember two pointer when it comes to Linked List
  * There are recursive way as shown, and iterative way using two pointer -- equal speed with distance of k(see leetcode OJ)
  * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

