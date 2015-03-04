/** 
 * Chapter 5-Bit Manipulation
 * Question 5-5
 * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 * EXAMPLE Input: 29(11101), 15(01111) 
 * Output: 2
 */

public class BitManipulation_5 {
	public int solutionOne(int a, int b){
		int count = 0;
		for(int c=a^b; c!=0; c=c>>1){		// 右移一位，每次check最后一位是不是1
			count += c&1;					// AND 1, 如果最后一位是1则count加一，如果最后一位是0则count加零保持不变
		}
		return count;
	}

	public int solutionTwo(int a, int b){	// 有一个1则flip为0，计算有多少个1
		int count = 0;
		for(int c=a^b; c!=0; c=c&(c-1) ){	// c=c&(c-1) - clear the least significant bit in c
			count++;						
		}
		return count;
	}
}

/*

  key: 
  * determine which bits in two numbers are different - with XOR
  * count the numbers of bits in A^B that are 1

*/