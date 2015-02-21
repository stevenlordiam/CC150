/** 
 * Chapter 2-Linked Lists
 * Question 2-5
 * You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digit are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * Example
 * Input: (7->1->6) + (5->9->2). That is, 617+295.
 * Output: 2->1->9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Example
 * Input: (6->1->7) + (2->9->5). That is, 617+295.
 * Output: 9->1->2 . That is, 912.
 */

public class LinkedLists_5{
	public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){ 	// recursion, here input is NODE, not LIST!
		if(l1==null&&l2==null&&carry==0){ 		// we're done if both lists reach the end which is null and the carry is 0
			return null;
		}

		LinkedListNode result = new LinkedListNode();

		int value = carry;
		if(l1!=null){
			value += l1.data;
		}
		if(l2!=null){
			value += l2.data;
		}
		result.data = value%10; 	// mod 10 to omit the carry
		if(l1!=null || l2!=null){
			LinkedListNode more = addLists(l1==null?null:l1.next,
										   l2==null?null:l2.next
										   value>=0?1:0); 			// recursion
			result.setNext(more);
		}
		return result;
	}
}

/*

  key: 
  * When it's questions about linked list, always ask it's singly linked list or doubly linked list
  * See the same in Leetcode: https://oj.leetcode.com/problems/add-two-numbers/
  * handle the condition when one list is longer than another
  * handle the addition carry (9->9)+(1)=(0->0->1)

  * If it's reverse order: 123 = (1->2->3): 
  	compare the lengths of the lists in the beginning and padding the shorter list with zeros.
*/

