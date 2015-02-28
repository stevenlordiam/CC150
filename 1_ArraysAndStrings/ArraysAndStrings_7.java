/** 
 * Chapter 1-Arrays and Strings
 * Question 1-7
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
 */

public class ArraysAndStrings_7{
	
	public static int[][] setZero(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];		

		for(int i=0;i<matrix.length;i++){					//flag zero
        	for(int j=0;j<matrix[0].length;j++){
            	if(matrix[i][j]==0){
            		row[i] = true;
            		column[j] = true;
            	}
            }
        }

        for(int i=0;i<matrix.length;i++){					//set zero
        	for(int j=0;j<matrix[0].length;j++){
            	if(row[i] || column[j]){
            		matrix[i][j]=0;
            	}
            }
        }

		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,0,1,1}};
		System.out.println("The original matrix is: ");
		for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
            	System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        int[][] setZeroMatrix = setZero(matrix);
		System.out.println("After set zero, the matrix is: ");
		for(int i=0;i<setZeroMatrix.length;i++){
        	for(int j=0;j<setZeroMatrix[0].length;j++){
            	System.out.print(setZeroMatrix[i][j]+"  ");
            }
            System.out.println();
        }
	}
}

/* Similar to Set Matrix Zeroes - https://oj.leetcode.com/problems/set-matrix-zeroes/
 
  key: 
  * two dimension array and nested loops
  * create a second matrix to flag the zero position
  * to be more space efficient, we could use a bit vector instead of a boolean array

*/