/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-9
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same row, column or diagonal. 
 * In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 */

public class RecursionAndDynamicProgramming_9 {
	public int GRID_SIZE = 8;
	public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
		if(row==GRID_SIZE){			// found valid placement
			results.add(columns.clone()); 		// Object.clone() - create and return a copy of this object
		} else {
			for(int col=0; col<GRID_SIZE; col++){
				if(checkValid(columns, row, col)){
					columns[row] = col; 		// place queen
					placeQueens(row+1, columns, results);
				}
			}
		}
	}

	// check if (rowl, columnl) is a valid spot for a queen by checking if there is a queen in the same column or diagonal 
	// We don't need to check it for queens in the same row because the calling placeQueen only attempts to place one queen at a time 
	// We know this row is empty
	public boolean checkValid(Integer[] columns, int row1, int column1){
		for(int row2=0; row2<row1; row2++){
			int column2 = columns[row2]; 	// check if (row2, column2) invalidates (row1, column1) as a queen spot
			 
			// check if rows have a queen in the same column
			if(column1==column2){
				return false;
			}

			// check diagonals: if the distance between the columns equals the distance between the rows
			// then they're in the same diagonal
			int columnDistance = Math.abs(column2-column1);

			// row1>row2, so no need for abs
			int rowDistance = row1-row2;
			if(columnDistance==rowDistance){ 		// check diagonal
				return false;
			}
		}
		return true;
	}

} 

/*

  key: 
  * each row and column and diagonal must be used exactly once
  * DP solution, see the detail in the book

*/