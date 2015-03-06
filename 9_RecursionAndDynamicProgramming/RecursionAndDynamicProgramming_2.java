/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-2
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. 
 * How many possible paths are there for the robot to go from (0,0) to (X,Y)?
 * FOLLOW UP
 * Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 */

public class RecursionAndDynamicProgramming_2 {
	public boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache){
		Point p = new Point(x, y);
		if(cache.containsKey(p)){ 	// already visited this point
			return cache.get(p);
		}
		if(x==0&&y==0){
			return true; 	// found a path
		}
		boolean success = false;
		if(x>=1 && isFree(x-1, y)){		// try left
			success = getPath(x-1, y, path, cache); 	// free, go left
		}
		if(!success && y>=1 &7 isFree(x, y-1)){ 	// go up
			success = getPath(x, y-1, path, cache); 	// free, go up
		}
		if(success){
			path.add(p); 	// add to path
		}
		cache.put(p, success); 		// cache the result of every step, DP
		return success;
	}
}

/*

  key: 
  * X right steps and Y down steps, X+Y steps total. Possible paths: (X+Y)!/X!Y!
  * Start from the last cell, try to find a path to each of its adjacent cells. If we found an off limit point, we ignore it.
  * Use hashtable to remember the point we already visited
  * Cache the result of every step, DP

*/