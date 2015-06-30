/** 
 * Chapter 1-Arrays and Strings
 * Question 1-5
 * Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string "aabcccccaaa" would become "a2b1c5a3". 
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 */

public class ArraysAndStrings_5{
	public static String compress(String string){

		String tmpString="";
		char lastChar=string.charAt(0);
		int count = 1;

		for(int i =1; i <string.length();i++){
			if(string.charAt(i)==lastChar){
				count++;
			}else{
				tmpString+=lastChar+""+count;	// ""+int makes char to string		
				lastChar=string.charAt(i);
				count=1;
			}
		}

		String newString=tmpString+lastChar+count;			//for that the last characters are the same, if delete this line the last few same characters are missing, because no adding in line 18;
		if(newString.length()<string.length()){
			return newString;
		}
		else{
			return string;
		}
	}

	public static void main(String[] args) {
		String str1="aabcccccaaa";	//shorter than original
		String str2="abcde";		//longer than original
		System.out.println("The original string is "+str1+" The compressed string is "+compress(str1));
		System.out.println("The original string is "+str2+" The compressed string is "+compress(str2));
	}
}

/*This implement is not efficient. A better solution is StringBuffer. See the code in the book.
 
  key: 
  * ""+int makes char to string	
  
*/