/** 
 * Chapter 1-Arrays and Strings
 * Question 1-6
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class ArraysAndStrings_6{

	public static int[][] rotate(int[][] matrix){		//assume it's clockwise
		int n=matrix.length;
        for(int i=0; i<n; i++){                         //first time, swap elements symmetrical to the diagonal
            for(int j=i+1; j<n; j++){
                int tmp1=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp1;
            }
        }
       for(int i=0; i<n; i++){                          //second time, swap column[i](vertical) and column[n-1-i]
            for(int j=0; j<n/2; j++){                   //note it's j<n/2, if it's anticlockwise then it's i<n/2
                int tmp2=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=tmp2;
            }
        }
        return matrix;
	}

/*
    public static void swap(int a, int b){              //NOTE: Java is call by value, can't simply use a temp to swap!
        int tmp=a;
        a=b;
        b=tmp;
    }
*/

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		System.out.println("The original matrix is: ");
		for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
            	System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        int[][] rotatedMatrix = rotate(matrix);
		System.out.println("After rotation, the matrix is: ");
		for(int i=0;i<rotatedMatrix.length;i++){
        	for(int j=0;j<rotatedMatrix[0].length;j++){
            	System.out.print(rotatedMatrix[i][j]+"  ");
            }
            System.out.println();
        }
	}
}

/*  Similar to Rotate Image - https://oj.leetcode.com/problems/rotate-image/
    
    The original matrix is: 
    1  2  3  4  
    5  6  7  8  
    9  10  11  12  
    13  14  15  16

    After first rotation, the matrix is: (swap elements symmetrical to the diagonal)
    1  5  9  13  
    2  6  10  14  
    3  7  11  15  
    4  8  12  16  

    After second rotation, the matrix is: (swap column[i](vertical) and column[n-1-i])
    13  9  5  1  
    14  10  6  2  
    15  11  7  3  
    16  12  8  4 
 
  key: 
  * Java is call by value, can't simply use swap(a,b)
  * Note the index i, j, which one is <n/2 in the for loop
  * 90 degrees rotation -> swap twice
  
*/