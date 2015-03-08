/** 
 * Chapter 11-Sorting and Searching
 * Question 11-4
 * Imagine you have a 20 GB file with one string per line. Explain bow you would sort the file
 */

public class SortingAndSearching_4 {

}

/*

  key: 
  * not bring all the data into memory -> only bring part of the data into memory
  * divide the file into chunks which are x megabytes each, where x is the amount of memory we have available
  * each chunk is sorted separately and then saved back to the file system. Once all the chunks are sorted, we then merge the chunks, one by one

*/