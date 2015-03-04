/** 
 * Chapter 5-Bit Manipulation
 * Question 5-2
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. 
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."
 */

public class BitManipulation_2 {
	public String solutionOne(double num){		// multiply two then subtract one if it's greater than one
		if(num>=1 || num<=0){
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num>0){
			if(binary.length()>=32){
				return "ERROR";
			}
			double r = num*2;
			if(r>=1){
				binary.append(1);
				num=r-1;
			} else {
				binary.append(0);
				num=r;
			}
		}
		return binary.toString();
	}

	public String solutionTwo(double num){ 		// divide two then recursion
		if(num>=1 || num<=0){
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while(num>0){
			if(binary.length()>=32){
				return "ERROR";
			}
			if(num>=frac){
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	} 

}

/*

  key: 
  * Solution 1:
    - 每次乘以2，若大于1，就减去1，二进制小数位为'1',否则为'0'
  * Solution 2:
  	- 每次除以2，然后递归

*/