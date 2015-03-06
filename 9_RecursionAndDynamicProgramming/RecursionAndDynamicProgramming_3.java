/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-3
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]= i. 
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */

public class RecursionAndDynamicProgramming_3 {
	private int magicfast(int[] array, int start, int end){ 		// binary search solution
		if(end<start || start<0 || end>=array.length){	// start, end is the array index, not actual integer
			return -1;
		}
		int mid = (start + end) / 2; 		// TEMPLATE OF BINARY SEARCH
		if(array[mid]==mid){
			return mid;
		} else if (array[mid]>mid){ 	// go left half
			return magicfast(array, start, mid-1);
		} else {						// go right half
			return magicfast(array, mid+1, end);
		}
	}
	public int magicFast(int[] array){
		return magicfast(array, 0, array.length-1); 	// use a private helper function to input more arguments
	}







	private int magicFastDup(int[] array, int start, int end){ 	// with duplicate element
		if(end<start || start<0 || end>=array.length){	
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if(midValue == midIndex){
			return midIndex;
		}

		// search left
		int leftIndex = Math.min(midIndex-1, midValue);		// THIS SOLUTION IS IMPORTANT!!!
		int left = magicFastDup(array, start, leftIndex);	// see the detail in the book
		if(left>=0){
			return left;
		}

		// search right
		int rightIndex = Math.max(midIndex+1, midValue); 	// THIS SOLUTION IS IMPORTANT!!!
		int right = magicFastDup(array, rightIndex, end);	// see the detail in the book

		return right;
	}

	public int magicFastDup(int[] array){
		return magicFastDup(int[] array, 0, array.length-1);
	}
}

/*

  key: 
  * First, brute force solution. if(array[i]==i) return i;
  * Second, binary search solution
  * If there are dups, we compare midIndex and midValue first, if not equal, then search left and right recursively

*/