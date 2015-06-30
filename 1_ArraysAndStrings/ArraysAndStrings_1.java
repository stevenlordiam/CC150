/** 
 * Chapter 1-Arrays and Strings
 * Question 1-1
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */

public class ArraysAndStrings_1{
	
	public static boolean isUnique(String string){
		boolean isUnique=false;
		int len=string.length();
		//	if(len>256) return false;
		for(int i=0;i<len;i++){	
			for(int j=0;j<i;j++){
				if(string.charAt(j)==string.charAt(i)){			
					isUnique=true;
				}
			}	
		}
		return isUnique;
	}

	public static void main(String[] args) {
		String[] string={"abcdefg", "abcdefga"};
		for(String s:string){
			if(isUnique(s)){
				System.out.println("The String "+s+" contains unique character.");
			}
			else{
				System.out.println("The String "+s+" doesn't contain unique character.");
			}
		}		
	}
}

/*Assume that the character is 256 ASCII character
  string.charAt(i) returns the char in the string index; for str="abc", str.charAt(0) returns "a";

  key: 
  * ask if the string is ASCII or Unicode?
  * if > 256, isUnique() returns false

方法二：char array
方法三：bit vector
*/