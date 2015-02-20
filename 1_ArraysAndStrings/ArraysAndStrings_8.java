/** 
 * Chapter 1-Arrays and Strings
 * Question 1-8
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewar").
 */

public class ArraysAndStrings_8{

	public static boolean isRotation(String s1, String s2){		//check if s2 is rotaion of s1
		if(s1.length()==s2.length() && s1.length()>0){			//if length is not the same or zero, it's surely not rotation string
			String tmp=s1+s1;
			return isSubstring(tmp,s2);
		}
		return false;
	}

	public static boolean isSubstring(String s1, String s2){	//check if s2 is substring of s1
		if(s1.indexOf(s2) != -1){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s1="waterbottle";
		String s2="erbottlewat";
		if(isRotation(s1,s2)){
			System.out.println("String 2: "+s2+" is rotation of string 1: "+s1);
		}
		else{
			System.out.println("String 2: "+s2+" isn't rotation of string 1: "+s1);
		}
	}
	
}

/*If we want to check if string a is substring of string b, then there must b b.length>a.length. So we consider to lengthen s1, that is s1+s2(no,s2 is surely substring of s1+s2) or s1+s1(yes!). 
 *Actually s1+s1 is that every character in s1 is rotated while the original string stays the same. For example, "waterbottle" rotated two character to right is:"terbottlewa".
 *If the original stays the same, we get "waterbottlewa"，and "terbottlewa" is surely substring of "waterbottlewa", so "waterbottlewa" is "terbottlewa"+original. So s1+s1 contains all the rotation string.
 *So if s2 is substring of s1+s1, it's surely rotation string of s1.
 
  key: 
  * s1+s1 contains all substring of rotaion string of s1
  * s1.indexOf(s2) returns the s2 index(start from 0) in s1, return -1 if s2 not in s1
  * str.indexOf(substr) != -1  check if substr is substring of str

*/