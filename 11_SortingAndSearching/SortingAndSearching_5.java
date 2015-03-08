/** 
 * Chapter 11-Sorting and Searching
 * Question 11-5
 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string
 */

public class SortingAndSearching_5 {
	public int search(String[] strings, String str){
		if(strings==null || str==null || str==""){
			return -1;
		}
		return searchR(strings, str, 0, strings.length-1);
	}

	private int searchR(String[] strings, String str, int first, int last){
		if(first>last)	return -1;
		int mid = (first + last) / 2; 	// move mid to the middle

		if(strings[mid].isEmpty()){ 	// if mid is empty, find closest non-empty strings 	
			int left = mid - 1; 		// string.isEmpty() is faster than string.equals("")
			int right = mid + 1;
			while(true){
				if(left<first && right>last){
					return -1;
				} else if(right<=last && !strings[right].isEmpty()){
					mid = right;
					break;
				} else if(left>=first && !strings[left].isEmpty()){
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}	// 夹逼方法求最近的非零string

		if(str.equals(strings[mid])){	// check for stringm and recurse if necessary
			return mid; 				// found it
		} else if(strings[mid].compareTo(str)<0){	
			return searchR(strings, str, mid+1, last);		// search right
		} else {
			return searchR(strings, str, first, mid-1);		// search left
		}
	}
}

/*

  key: 
  * sorted array -> binary search -> recursion

*/