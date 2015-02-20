/** 
 * Chapter 1-Arrays and Strings
 * Question 1-4
 * Write a method to replace all spaces in a string with '%20'. You may assume that 
 * the string has sufficient space at the end of the string to hold the additional characters, 
 * and that you are given the "true" length of the string.(Note:if implementing in Java, 
 * please use a character array so that you can perform this operation in place.)
 * Example:
 * Input: "Mr John Smith", 13
 * Output: :"Mr%20John%20Smith"
 */

//import java.util.Scanner;

public class ArraysAndStrings_4{
	
	public static String replace(String string){		//length here is actual length of string
		char[] tmp = string.toCharArray();
		int length=string.length();
		int spaceCount = 0;
		for(int i=0; i<length; i++){
			if(tmp[i]==' '){
				spaceCount++;
			}
		}
		int newLength = length + 2*spaceCount;
		char[] newTmp=new char[newLength];
		for(int i=length-1; i>=0; i--){				//start from the end and work backwards
			if(tmp[i]==' '){						//copy to a new char array
				newTmp[newLength-3]='%';
				newTmp[newLength-2]='2';
				newTmp[newLength-1]='0';
				newLength=newLength-3;
			}
			else{
				newTmp[newLength-1]=tmp[i];
				newLength=newLength-1;
			}
		}
		return string.valueOf(newTmp);
	}

	public static void main(String[] args) {
		String str = args[0];
		//Scanner sc = new Scanner(args[1]);
		//int len = sc.nextInt();
		System.out.println(replace(str));
	}
}

/*
 
  key: 
  * edit the string starting from the end and work backwards, useful when we have extra buffer at the end
  * if start from the beginning, may be ArrayOutOfBoundException

*/