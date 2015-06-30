/** 
 * Chapter 2-Linked Lists
 * Question 2-1
 * Write code to remove duplicates from an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffers is not allowed?
 */

public class LinkedLists_1{
	
	public static void deleteDups(LinkedListNode n){ 		// iterate with buffer, O(N) time
		Hashtable table = new Hashtable();	
		LinkedListNode previous = null;
		while(n!=null){
			if(table.containsKey(n.data)){
				previous.next=n.next;
			}else{
				table.put(n.data,true);
				previous=n;
			}
			n=n.next;
		}
	}

	public static void deleteDupsWithoutBUffer(LinkedListNode head){ 		// two poniters without buffer, O(1) space, O(N^2) time
		if(head==null){
			return;
		}
		LinkedListNode current = head;
		while(current!=null){
			LinkedListNode runner = current;
			while(runner.next!=null){
				if(runner.next.data==current.data){
					runner.next=runner.next.next;
				}else{
					runner=runner.next;
				}
			}
			current=current.next;
		}
	}

}

/* 
If it is sorted list, we can see the example in leetcode OJ:
https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/

  key: 
  * To track duplicates, we can use hash table
  * To use without buffer, we can use two pointer
  * Iterate through the linked list, add each element to hash table. When found dups, remove it and continue iterating

*/