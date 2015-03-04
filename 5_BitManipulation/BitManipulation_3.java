/** 
 * Chapter 5-Bit Manipulation
 * Question 5-3
 * Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their binary representation.
 */

public class BitManipulation_3 {
	public int getNext(int n){
		int c = n; 			// compute c0 and c1
		int c0 = 0;
		int c1 = 1;
		while( ((c&1)==0) && (c!=0)){
			c0++;
			c>>=1;
		}
		while((c&1)==1){
			c1++;
			c>>=1;
		}

		if(c0+c1==31 || c0+c1==0){ 		// error: if n==11..1100..00, then there is no bigger number with the same number of 1s
			return -1;
		}

		int p = c0 + c1; 				// position of rightmost non-trailing zero

		n |= (1<<p); 					// flip rightmost non-trailing zero
		n &= ~((1<<p)-1); 				// clear all bits to the right of p
		n |= (1<<(c1-1))-1; 			// insert (c1-1) ones on the right
		return n;
	}

	public int getPrev(int n){
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while(temp&1==1){
			c1++;
			temp>>=1;
		}

		if(temp==0){
			return -1;
		}

		while(((temp&1)==0)&&(temp!=0)){
			c0++;
			temp>>=1;		
		}

		int p = c0 + c1; 				// position of rightmost non-trailing one
		n &= ((~0)<<(p+1)); 			// clear from bit p onwards

		int mask = (1<<(c1+1))-1;   	// sequence of (c1+1) ones
		n |= mask<<(c0-1);
		return n;
	}

}

/*

  key: 
  * The solution is smart! see the detail in the book 

*/