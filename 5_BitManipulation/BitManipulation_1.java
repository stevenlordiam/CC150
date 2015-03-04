/** 
 * Chapter 5-Bit Manipulation
 * Question 5-1
 * You aregiven two 32-bit numbers, Nand M, andtwo bit positions, land j.
 * Write a method to insert M into Nsuch that M starts at bit j and ends at bit i. 
 * You can assume that the bits j through i have enough space to fit all of M. 
 * That is, if M = 10011, you canassumethat there areat least 5 bits between j and i. 
 * You would not,forexample, have j = 3 and i = 2,because M could notfully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N=10000000000,M=10011,i=2,j=6 
 * Output:N = 10001001100
 */

public class BitManipulation_1 {
	public int updateBits(int n, int m, int i, int j){
		// create a mask to clear bits i through j in n
		// EXAMPLE: i=2, j=4. Result should be 11100011
		int allOnes = ~0;	// will equal sequence of all 1s (not just 1, it's 11111111 !!!)
		
		// 1s before position j, then 0s. left = 11100000
		int left = allOnes<<(j+1); 	// remember to PLUS ONE 	
		int right = ((1<<i)-1); 	// 1's after position i. right = 00000011

		int mask = left|right; 		// all 1s, except for 0s between i and j. mask = 11100011

		int n_cleared = n&mask; 	// clear bits j through i
		int m_shifted = m<<i;		// move M into correct position

		return n_cleared|m_shifted; // OR them
	}
}

/*

  key: 
  * Clear the bits j through i in N
  * Shift M so that it lines up with bits j through i (left shift i position 10011 -> 1001100)
  * Merge M and N

*/