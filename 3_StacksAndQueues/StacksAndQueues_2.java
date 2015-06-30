/** 
 * Chapter 3-Stacks and Queues
 * Question 3-2
 * How would you design a stack which, in addition to push and pop, also has a function min 
 * which returns the minimum element? Push, pop and min should all operate in O(1) time.
 */

public class StacksAndQueues_2 extends Stack<Integer> { 	// keep a second stack to keep track of the mins
	// a better solution is leetcode solution as follow
	stack<Integer> s2;
	public StacksAndQueues_2(){
		s2 = new Stack<Integer>();
	}

	public void push(int value){
		if(value<=min()){
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop(){
		int value = super.pop();
		if(value==min()){
			s2.pop();
		}
		return value;
	}

	public int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return s2.peek();
		}
	}
}

/*

  key: 
  * Same question in Leetcode OJ Min Stack - https://oj.leetcode.com/problems/min-stack/
	------------------------------------------------------------------------
	public class MinStack {
    	private Stack<Integer> stack = new Stack<>();
    	private Stack<Integer> minStack = new Stack<>();
    	public void push(int x) {
      		stack.push(x);
      		if (minStack.isEmpty() || x <= minStack.peek()) {
         		minStack.push(x);
      		}
    	}
    	public void pop() {
      		if (stack.pop().equals(minStack.peek())){
          		minStack.pop();
      		}
    	}
    	public int top() {
      		return stack.peek();
    	}
    	public int getMin() {
      		return minStack.peek();
    	}
	}
	------------------------------------------------------------------------
*/