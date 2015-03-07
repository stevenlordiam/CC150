/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-7
 * Implement the "paint fill" function that one might see on many image editing programs. 
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 */

public class RecursionAndDynamicProgramming_7 {
	enum Color{
		Black, White, Red, Yellow, Green
	}
	boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(x<0 || x>=screen[0].length || y<0 || y>=screen.length){ 		// x is column, y is row
			return false;
		}
		if(screen[y][x]==ocolor){
			screen[y][x] = ncolor;		// remember it's screen[y][x]
			paintFill(screen, x-1, y, ocolor, ncolor); 		// left
			paintFill(screen, x+1, y, ocolor, ncolor);		// right
			paintFill(screen, x, y-1, ocolor, ncolor);		// down
			paintFill(screen, x, y+1, ocolor, ncolor);		// up
		}
		return true;
	}

	private boolean paintFill(Color[][] screen, int x, int y, Color ncolor){
		if(screen[y][x]==ncolor)	return false;
		return paintFill(screen, x, y, screen[y][x], ncolor);
	}
}

/*

  key: 
  * the ordering of x and y is screen[y][x] because x is the horizontal column and y is the vertical row
  * DFS on a graph - at each pixel, search outwards to each surrounding pixel, but it may overflow relatively quickly

*/