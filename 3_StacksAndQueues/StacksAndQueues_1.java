/** 
 * Chapter 3-Stacks and Queues
 * Question 3-1
 * Describe how you could use a single array to implement three stacks.
 */

public class StacksAndQueues_1 {
	int stackSize = 100; 		// for each is 100, total 300
	int[] buffer = new int[stackSize*3];
	int[] stackPointer = {-1, -1, -1}; 		// pointers to track top elements

	void push(int stackNum, int value) throws Exception {
		if(stcakPointer[stackNum]+1>=stackSize){ 	// check if we have space
			throw new Exception("Out of space.");
		}
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}

	int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum]==-1){
			throw new Exception("Trying to pop an empty satck.");
		}
		int value = buffer[absTopOfStack(stackNum)]; 	// get top
		buffer[absTopOfStack(stackNum)] = 0; 			// clear index
		stcakPointer[stackNum]--;
		return value;
	}

	int peek(int stackNum){
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}

	boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}

	int absTopOfStack(int stackNum){
		return stackNum*stackSize +stackPointer[stackNum]; 	// this returns index of top of stack. For stack 1, [0,n/3). For stack 2, [n/3,2n/3). For stack 3, [2n/3,n)
	}
}

/*

  key: 
  * Fixed division or flexible division? (see the flexible division solution in the book)
  * Check exception for push a full stack and pop an empty stack

*/

