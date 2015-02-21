/** 
 * Chapter 2-Linked Lists
 * Question 2-6
 * Given a circular linked list, implement an algorithm which returns the node at the biginning of the loop.
 * DEFINITION
 * Circular linked list: A(corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A->B->C->D->E->C(the same C as earlier)
 * Output: C
 */

public class LinkedLists_6{
	public LinkedListNode FindBeginning(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while(fast!=null && fast.next!=null){ 	// find meeting point. This will be LOOP_SIZE-k steps into the linked list
			slow = slow.next;
			fast = fast.next.next; 	// two times faster than slow
			if(slow==fast){ 		// collision
				break;
			}
		}

		if(fast==null || fast.next==null){ 		// error check - no loop
			return null;
		}

		slow = head; 				// move slow to head, keep fast at meeting point, each are k steps from the loop start
		while(slow!=fast){			// If they move at the same pace, they will meet at the loop start
			slow = slow.next;
			fast = fast.next;
		}
		return fast; 				// now both nodes are at the start of the loop
	}
}

/*
  THIS QUESTION IS IMPORTANT, SEE THE SOLUTION IN THE BOOK!!!
  
  key: 
  * First, detect if there is a loop or not
  * FastRunner/SlowRunner approach
  * Detailed solution in the book

*/

