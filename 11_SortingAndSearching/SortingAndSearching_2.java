/** 
 * Chapter 11-Sorting and Searching
 * Question 11-2
 * Write a method to sort an array of strings so that all the anagrams are next to each other
 */

public class SortingAndSearching_2 {
	public void sort(String[] array){
		HashTable<String, LinkedList<String>> hash = new HashTable<String, LinkedList<String>>();

		// group words by anagram
		for(String s : array){		
			String key = sortChars(s);
			if(!hash.containsKey(key)){
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);	// LinkedList.push(E e) - push an element onto the stack represented by the list / insert the element at the front of the list
		}

		// convert hash table to array
		int index = 0;	
		for(String key : hash.keySet()){ 	// HashTable.keySet() - return a Set view of the keys contained in the map
			LinkedList<String> list = hash.get(key);
			for(String t : list){
				array[index] = t;
				index++;
			}
		}
	}

	public String sortChars(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}

/*
String.toCharArray() - return a character array of the string
Arrays.sort(char[] c) - sort the character array

  key: 
  * Bucket sort
  * sort the string, two words are anagrams only if they look the same once they're sorted
  * use a hash table which maps from the sorted version of a word to a list of its anagrams

*/