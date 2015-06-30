/** 
 * Chapter 2-Linked Lists
 * Question 2-4
 * Write code to partition a linked list around a value x, such that all nodes less than x come 
 * before all nodes greater than or equal to x.
 */

public class LinkedLists_4{
	public LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;

		while(node!=null){ 			// partiton list
			LinkedListNode next = node.next; // store the next node in temp so we remember which node should be next in our iteration
			if(node.data<x){ 		// insert node into start of before list
				node.next=beforeStart; // (REMEMBER THIS TWO STEPS!!!)
				beforeStart=node;
			} else { 				// insert node into front of after list
				node.next=afterStart; 
				afterStart=node;
			}
			node=next;
		}
		if(beforeStart == null){ 	//  in case all elements are greater than x
			return afterStart;
		}
		LinkedListNode head = beforeStart;
		while(beforeStart.next!=null){ 	// traverse the list to get the e d of before list and merge the lists
			beforeStart=beforeStart.next; 
		}
		beforeStart.next=afterStart;
		return head;
	}
}

/*
  Similar to Leetcode Partition List - https://oj.leetcode.com/problems/partition-list/
  key: 
  * remember node operation and check for null

*/