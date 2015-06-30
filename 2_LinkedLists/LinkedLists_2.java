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

	public static LinkedListNode nthToLast(LinkedListNode head, int k) { 	// two pointer
		if (k <= 0) return null;

		LinkedListNode p1 = head;
		LinkedListNode p2 = head;	
		
		// Move p2 n nodes into the list.  Keep n1 in the same position.
		for (int i = 0; i < k - 1; i++) { 
			if (p2 == null) {
				return null; 
			}
			p2 = p2.next;
		}
		if (p2 == null) { // Another error check.
			return null;
		}
		
		// Move them at the same pace.  When p2 hits the end, p1 will be at the right element.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
	  	}
	  	return p1;
	}
}

/*

  key: 
  * Always remember two pointer when it comes to Linked List
  * There are recursive way as shown, and iterative way using two pointer -- equal speed with distance of k(see leetcode OJ)
  * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
*/