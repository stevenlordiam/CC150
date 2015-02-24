/** 
 * Chapter 3-Stacks and Queues
 * Question 3-6
 * Write a program to sort a stack in ascending order (with biggest items on top). 
 * You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (such as an array). 
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */

public class StacksAndQueues_6 {					// insert in stack
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int tmp = s.pop();						// step 1, use tmp to hold temporary variable
			while(!r.isEmpty() && r.peek()>tmp){
				s.push(r.pop());					// step 2, if r.peek()>tmp, pop it to s and push tmp to r
			}
			r.push(tmp);							// step 3, continue to do this until tmp is 'inserted' in the right place
		}
		return r;
	}
}

/*

  key: 
  * use a temporary variable serving as a buffer to implement 'insert' method in stack
  * O(N^2) time, O(N) space
  * ask the interviewer if we can use unlimited stacks or not, if we can, we can implement a modified quicksort or mergesort algorithm
    with two additional stacks per level of recursion
																		
*/