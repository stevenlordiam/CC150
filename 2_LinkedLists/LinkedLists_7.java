/** 
 * Chapter 2-Linked Lists
 * Question 2-7
 * Implement a function to check if a linked list is a palindrome.
 */

public class LinkedLists_7{
	public boolean isPalindrome(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;

		Stack<Integer> stack = new Stack<Integer>(); 		// use stack can store data in reverse order

		while(fast!=null && fast.next!=null){
			stack.push(slow.data); 		// push elements from first half of linked list onto stack
			slow = slow.next;			// when fast reaches the end, slow is in the middle
			fast = fast.next;
		}

		if(fast!=null){ 				// odd number of element, skip the middle element
			slow = slow.next;
		}

		while(slow!=null){
			int top = stack.pop().intValue(); 	// unboxing, intValue() is a instance method of the Integer class that returns a primitive int
												// because stack is Integer type, so we need to unbox to integer type for the linked list data
			if(top!=slow.data){ 		// if !=, not palindrome 
				return false;
			}
			slow = slow.next;			// if ==, continue to go through slow 
		}
		return true;
	}
}

/*

  key: 
  * When palindrome, use "Reverse and Compare" approach -- only need to compare the first half
  * Solution 1: reverse and compare
  * Solution 2: iterative approach:
  	- Use a stack to store the node data so they can be in reverse order
  	- use fast/slow runner approach to get the middle of the linked list
  * Solution 3:  recursive approach:
  	- compare node i to node n-i to check if the linked list is a palindrome
*/