/** 
 * Chapter 11-Sorting and Searching
 * Question 11-1
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. 
 * Write a method to merge B into A in sorted order
 */

public class SortingAndSearching_1 {
	public void merge(int[] a, int[] b, int lastA, int lastB){
		int indexA = lastA - 1; 	// index of last element in a
		int indexB = lastB - 1;		// index of last element in b
		int indexMerged = lastB + lastA - 1; 	// end of merged array

		// merge a and b, starting from the last element in each
		while(indexB>=0){
			if(indexA>=0 && a[indexA]>b[indexB]){ 	// end of a is greater than end of b
				a[indexMerged] = a[indexA];		// copy element
				indexA--;
			} else {
				a[indexMerged] = b[indexB];		// copy element
				indexB--;
			}
			indexMerged--;		// move indices
		}
	}
}

/*
Similar to Leetcode OJ Merge Sorted Array - https://oj.leetcode.com/problems/merge-sorted-array/

  key: 
  * If we insert an element into the front of A, we need to shift the existing elements backwards to make room for it
  * so we insert elements into the back of the array, start from the back of A and B, move the larger one to A

*/