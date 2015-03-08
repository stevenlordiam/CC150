/** 
 * Chapter 11-Sorting and Searching
 * Question 11-6
 * Given an MX N matrix in which each row and each column is sorted in ascending order, write a method to find an element
 */

public class SortingAndSearching_6 {
	public boolean findElement(int[][] matrix, int elem){
		int row = 0;
		int col = matrix[0].length-1;
		while(row<matrix.length && col>=0){
			if(matrix[row][col]==elem){
				return true;
			} else if(matrix[row][col]>elem){
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}

/*
Similar to Leetcode OJ Search a 2D Matrix - https://leetcode.com/problems/search-a-2d-matrix/

  key: 
  * Solution 1:
    - 从右上角matrix[0][c-1]开始，对角线对比
  * Solution 2:
    - partiton the matrix into four quadrants nad recursively search the lower left quadrant and the upper right quadrant
	- since the diagonal is sorted, we can search it using binary search
	- see the detail and code in the book

*/