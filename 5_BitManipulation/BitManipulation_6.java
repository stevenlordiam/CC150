/** 
 * Chapter 5-Bit Manipulation
 * Question 5-6
 * Write a program to swap odd and even bits in an integer with as few instructions as possible 
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on)
 */

public class BitManipulation_6 {
	public int swapOddEvenBits(int x){
		return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) ); //32 bit integer -> 8 hexadecimal(16-based) numbers
	}	// REMEMBER TO USE 'OR'
}

/*

  key: 
  * mask all odd bits with 10101010 in binary(which is 0xaa), then shift them right by 1 to put them in the even spots
  * mask all even bits with 01010101 in binary(which is 0x55), then shift them left by 1 to put them in the odd spots

*/