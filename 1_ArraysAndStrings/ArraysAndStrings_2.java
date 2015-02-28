/** 
 * Chapter 1-Arrays and Strings
 * Question 1-2
 * Implement a function void reverse(char*str) in C or C++ which reverses a null-terminated string
 */

// implementation in Java 

public class ArraysAndStrings_2{
	
	public String reverse(String string){
		int len=string.length();
		String tmpString="";
		for(int i=len;i>0;i--){		//reverse, not in place;
			tmpString += string.charAt(i-1);
		}
		
		return tmpString;
	}

	public String reverseInPlace(String string){
		char[] str = string.toCharArray();
		int len=str.length;								//char[] is length, not length() as string;
		for(int i=0; i<len/2; i++){     				//reverse, in place;
			char tmp=str[i];
			str[i]=str[len-i-1];						//note that index is len-i-1;
			str[len-i-1]=tmp;
		}
		String reversedString=String.valueOf(str);		//make char[] to string;
		return reversedString;
	}

	public static void main(String[] args) {
		String str="abcdefg";
		ArraysAndStrings_2 a= new ArraysAndStrings_2();
		System.out.println("The original string is "+str+"\n The reversed string is "+a.reverse(str));
		System.out.println("The original string is "+str+"\n The reversed string is "+a.reverseInPlace(str));
	}
}

/*
  string.toCharArray() makes a string to char[];
  string.valueOf(char[]) makes char[] to string;
  OR
	String reversedString = "";
	for(int i=0; i<str.length; i++) {
		reversedString += str;
	}

  key: 
  * implement in place

*/