/** 
 * Chapter 11-Sorting and Searching
 * Question 11-3
 * Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array
 * You may assume that the array was originally sorted in increasing order
 */

public class SortingAndSearching_3 {
	public int search(int[] a, int left, int right, int x){
		int mid = (left + right) / 2;
		if(x==a[mid]){ 									// found element
			return mid;
		}
		if(right<left){
			return -1;
		}

		// either the left or right half must be normally ordered
		// find out which side is normally ordered, and then use the normally ordered half to figure out which side to search to find x
		if(a[left]<a[mid]){								// left is normally ordered
			if(x>=a[left] && x<=a[mid]){
				return search(a, left, mid-1, x); 		// search left
			} else {
				return search(a, mid+1, right, x); 		// search right
			}
		} else if(a[mid]<a[left]){						// right is normaly ordered
			if(x>=a[mid] && x<=a[right]){
				return search(a, mid+1, right, x); 		// search right
			} else {
				return search(a, left, mid-1, x); 		// search left
			}
		} else if(a[left]=a[mid]){						// left half is all repeats
			if(a[mid]!=a[right]){						// if right is diff, search it; already compared x and a[mid], since left is all repeats, no need to search left
				return search(a, mid+1, right, x); 		// search right
			} else {
				int result = search(a, left, mid-1, x);	// search left
				if(result==-1){
					return search(a, mid+1, right, x);  // search right
				} else {
					return result;
				}
			}
		}
		return -1;
	}
}

/*
Similar to:
Find Minimum in Rotated Sorted Array - https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Find Minimum in Rotated Sorted Array II - https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
Search in Rotated Sorted Array - https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
Search in Rotated Sorted Array II - https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/

  key: 
  * a modification of binary search, see detail in the book

*/