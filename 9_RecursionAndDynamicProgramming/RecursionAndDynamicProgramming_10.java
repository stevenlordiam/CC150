/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-10
 * You have a stack of n boxes, with widths wi, heights hi and depths di. The boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth. 
 * Implement a method to build the tallest stack possible, where the height of a stack is the sum of the heights of each box.
 */

public class RecursionAndDynamicProgramming_10 {
	public ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stack_map){
		if(bottom!=null&&stack_map.containsKey(bottom)){
			return stack_map.get(bottom);
		}

		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for(int i=0; i<boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], stack_map);
				int new_height = stackHeight(new_stack);
				if(new_height>max_height){
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		if(max_stack==null)		max_stack = new ArrayList<Box>();
		if(bottom!=null) 	max_stack.add(0, bottom);
		stack_map.put(bottom, max_stack);
		return (ArrayList<Box>)max_stack.clone(); 	// cast 
	} 	// Object.clone() - create and return a copy of this object
} 

/*

  key: 
  * String.length(), array.length
  * DP - store the the previous result

*/