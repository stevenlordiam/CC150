## Chapter 01 Arrays and Strings

###Forked from: [Original](https://github.com/xun-gong/CrackingCodeInterview150)

? hash + binary search tree O(nlogn)  
? dynamic resizing array  
? stringbuffer in jave or in C

### Interview Questions
-------------------------
* **1.1 Implement an algorithm to determine if a string has all unique charters. What if you cannot use additional data structure?**  
  
  - ***ASCII***  
  > 0~127, 128 characters(a-z, A-Z, 0-9, space, punctuation, control characters)  
  0~31 are unprintable, 32~127 are printable  
  7-bit to express

  - ***Extended ASCII***
  > adding more character definitions form 128  
  128~255 are extensions to the 7-bit ASCII  
  8-bit to express 0~255, 256 characters  
  
  - ***Unicode***  
  > computing industry standard for consistent encoding  
  handling of text expressed in most of the world's writing system  
  UTF-8: 8-bit encoding, same code value as ASCII
  UTF-16: 16-bit encoding  
    
    If no additional data structure allowed, we can use bit manipulation (Chapter5) to achieve a even efficient algorithm.  
  
  **Interview Tips:**  
  1. Ask what kind of character in giving string(ASCII/Unicode/'a~z')  
  2. Ask if you can use additional data structure(array vs. bit manipulation)  
  3. Which encoding system works better in the algorithm you give out? (related to 1.) 
  4. For the same running time complexity, can space complexity has room to improve? (related to 1.) 
      
       
 * **1.2 Implement function void reverse(char* str) in C or C++ which reverses a null-terminated string.**  
 
   approach: calculate length and reversely assign to a new char[] with '\0' as terminal - awkward, original doesn't change
   approach: utilize pointer in C++ to swap within original char[], original changes
   
   ?XOR swap algorithm (swap(a, a) exception?)
   
   strlen(char* s) can return the length including '\0'
   
   tail pointer can be found without knowing the total length  
   
* **1.3 Given two strings, write a method to decide if one is a permutation of the other.**   

  ? what kind of char in the strings
  
  The key is the counter, for str1 ++counter, for str2 --counter. Make it like an indicator. There's no need to initialize two different counters and then compare each slot's value.
  
 
* **1.4 Write a method to replace all the space in a string to %20, you may assume the given space is sufficient. Example: given "Mr John Troy(_extra_space_)", replace to "Mr%20John%20Troy."**  

  The **most** tricky part is think backward when you manipulate within the char array.  
  
  Step 1: Calculate space number, we need to replace them all later.  
  
  Step 2: Determine the new length ~ `new_length = strlen(str) + 2 * space_num`. Allocate space for later use ~ `str[new_length] = '\0'` can do this for us, however this operation will overwrite other useful space:  
   
  Step 3: Iterate original string backward, replace space into %20. If you want to do this forward, you should take care the overwrite problem, this is the biggest trick in this question. Learn to think bidirectionally!  
  
  Another approach is very similar to this one, instead of replacing within space, it returns a new replaced array.  
  
 * **1.5 Write a method to perform basic string compression using the counts of repeated characters. Example: "aabcccccaaa" => "a2b1c5a3". If "compressed" string would not become smaller than the original string ("abc" => "a1b1c1"), your method should return the original string. Assume the string has only upper and lower case letters (a~z)**  

   Pure char array implementation:
   - count appearance number of consecutive character
   - if compress < old. new a char array and assign values to each slot, support single digit and double digit. return new
   - if >= old, return old  
   
   Utilize string object:
   - append the first char, start to iterate char in string
   - if same char, counter++
   - if not same, append counter number and a new char
   - if new < old, return new; else return old  
   
   > This question taught me a lot, it made me more clear on the details of C-string(ending with '\0') and C++ string object.  
  
   ***Tips:*** For all the interview questions, if you can use string object, use it, because C-string and char array is easy to make mistake and less convenient.  
   
   [Reference1](https://www.prismnet.com/~mcmahon/Notes/strings.html)  
   [Reference2](http://www.cs.fsu.edu/~myers/c++/notes/stringobj.html)  
   
   I will re-evaluate my code on 1.1~1.5, see if I can make it more elegant.  
  
* **1.6 **  
  
  Nature of 90 degree rotation: small example to see   
  extract iterate fact: layered rotation, not regular iteration all element  
  passing 2-d array into function in c++   
  
  Two approach:  
   1. Rotate by in place swap
   2. Rotate by symmetric flip  
   
   How to pass a matrix to function in C++:
   
   ```
   void rotate2(int matrix[][N])
   {
   }  
   
   int main(int argc, char const *argv[])
   {
       int matrix [N][N] = {{1, 2}, {3, 4}};
       rotate2(matrix);
   }
   ```  
   
* **1.7 **  

* **1.8 **  

  Learn to transform original problem into new problem which you can utilize exist method to solve it.  
  
  It's trick to solve 1.8 in this way, because it's not clear to see why we need to use isSubstring() for only once.  
  
  First in first, we need to clarify what does "rotation" mean?  
  	 - rotation cut point  
  	 - rotation pattern  
  	 - the relationship between rotation and substring   
  	 
  About the isSubstring algorithm:  
  check wiki: http://en.wikipedia.org/wiki/String_searching_algorithm  
    To Do: learn famous string search algorithm  
    
####*Java Tips*
* In Java, string type is passed by value, when you modify the string you pass into in a sub function without return new string out, in main function, your string remain the same. Can't simply use swap(a,b)
* **string.charAt(i)** returns the char in the string index; for str="abc", str.charAt(0) returns "a";
* **string.toCharArray()** makes a string to char[];
* **string.valueOf(char[])** makes char[] to string;
* **""+int** makes int to string  	    
* **s1.indexOf(s2)** returns the s2 index(start from 0) in s1, return -1 if s2 not in s1
* **str.indexOf(substr) != -1**  check if substr is substring of str 
* s1+s1 contains all substring of rotaion string of s1
  

 
   
  
  
  
  