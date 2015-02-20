/** 
 * Chapter 1-Arrays and Strings
 * Question 1-3
 * Given two strings, write a method to decide if one is a permutation of the other
 */

import java.util.Arrays;

public class ArraysAndStrings_3{
	
	public static boolean isPermutation1(String s1, String s2){			//Solution 1: sort the string then compare
		if(s1.length()!=s2.length()){
			return false;
		}
		if(!sort(s1).equals(sort(s2))){
			return false;
		}
		return true;
	}

	public static String sort(String string){
		char[] str = string.toCharArray();			//string to char[]
		Arrays.sort(str);							//sort char array
		return string.valueOf(str);					//char[] to string
	}


	public static boolean isPermutation2(String s1, String s2){			//Solution 2: check if they have identical character counts
		if(s1.length()!=s2.length()){
			return false;
		}
		
		int[] count = new int[256];		//ASCII
		char[] s1_array=s1.toCharArray();
		for(char c : s1_array){			//count number of each character in s1
			count[c]++;
		}

		for(int i=0; i<s2.length(); i++){
			int n = (int)s2.charAt(i);		//ASCII number of each character in s2
			if(--count[n]<0){				//if identical,number-1=0; otherwise, number-1<0
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] string={"abc", "cba", "acb ", "Abc"};
		System.out.println(isPermutation1(string[0],string[1])?"It is permutation":"It isn't permutation ");
		System.out.println(isPermutation1(string[0],string[2])?"It is permutation":"It isn't permutation ");		//whitespace test;
		System.out.println(isPermutation1(string[0],string[3])?"It is permutation":"It isn't permutation ");		//case-sentitive test;

		System.out.println(isPermutation2(string[0],string[1])?"It is permutation":"It isn't permutation ");
		System.out.println(isPermutation2(string[0],string[2])?"It is permutation":"It isn't permutation ");		
		System.out.println(isPermutation2(string[0],string[3])?"It is permutation":"It isn't permutation ");	
	}
}

/*
  key: 
  * is it case-sentitive? is whitespace significant?
  * if the length is not the same, it's not permutation
  * Solution 1: sort the string then compare
  * Solution 2: check if they have identical character counts(ask if ASCII or Unicode)
*/