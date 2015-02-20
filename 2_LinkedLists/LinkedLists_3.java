/** 
 * Chapter 2-Linked Lists
 * Question 2-3
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the code c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */

public class LinkedLists_3{
	public static boolean deleteNode(LinkedListNode n){
		if(n==null||n.next==null){
			return false;
		}
		LinkedListNode next = n.next;
		n.data=next.data; 			// copy node data to the next node
		n.next=next.next; 			// copy node reference to the next node, which is deleting the current node
		return true;
	}

}

/*

  key: 
  * POINT OUT that the problem cannot be solved if the node to be deleted is the last node

*/