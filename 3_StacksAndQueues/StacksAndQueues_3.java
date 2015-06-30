/** 
 * Chapter 3-Stacks and Queues
 * Question 3-3
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds somethreshold. 
 * Implement a data structureSetOf Stacks that mimics this. SetOf Stacks should be composed of several stacks 
 * and should create a new stack once the previous one exceeds capacity. SetOf Stacks. push() and SetOf Stacks. 
 * pop() should behave identically to a single stack (that is,popO should return the same values as it would 
 * if there were just a single stack).
 * FOLLOW UP
 * Implement afunction popAt(int index) which performs a pop operation on a specific sub-stack.
 */

public class StacksAndQueues_3 {
	public void push(int v){
		Stack last = getLastStack();
		if(last!=null && !last.isFull()){ 	// stack.isFull() - return true if stack is full
			last.push(v);
		}else{ 								// create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack); 				// stack.add() - almost the same as push(): http://stackoverflow.com/questions/15989309/java-stack-push-vs-add
		}
	}

	public int pop(){
		Stack last = getLastStack();
		int v = last.pop();
		if(last.size==0){ 					// if the last stack is empty after popping, remove the stack from the list of stacks
			stack.remove(stack.size()-1); 	// remove the empty last stack after popping
		}
		return v;
	}
}

/*

  key: 
  * be careful if the last stack is at capacity, we need to create a new stack
  * see the implement of popAt(int index) in the book
*/