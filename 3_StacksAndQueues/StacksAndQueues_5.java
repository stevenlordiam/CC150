/** 
 * Chapter 3-Stacks and Queues
 * Question 3-5
 * Implement a MyQueue class which implements a queue using two stacks.
 */

public class StacksAndQueues_5<T> { 		// use generics
	Stack<T> stackNewest, stackOldest;

	public StacksAndQueues_5(){
		stackNewest = new Stack<T>;
		stackOldest = new Stack<T>;
	}

	public int size(){
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value){ 		// enqueue
		stackNewest.push(value);
	}

	private void shiftStack(){  	// DO A SHIFT STACK OPERATION
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek(){
		shiftStack();
		return stackOldest.peek();
	}

	public T remove(){				// dequeue
		shiftStack();
		return stackOldest.pop();
	}

}

/*

  key: 
  * For queue, there are methods like: enqueue, dequeue, size
  * Because stack and queue have different order, in order to implement a queue with stacks, we need to
    do a shift stack operation to reverse the order
    
*/