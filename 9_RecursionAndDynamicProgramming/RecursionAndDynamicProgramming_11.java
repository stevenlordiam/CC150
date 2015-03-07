/** 
 * Chapter 9-Recursion and Dynamic Programming
 * Question 9-11
 * Given a boolean expression consisting of the symbols 0,1, &, |, and ^, and a desired boolean result value result
 * Implement a function to count the number of ways of parenthesizing the expression such that it evaluates to result
 */

public class RecursionAndDynamicProgramming_11 {
	public int f(String exp, boolean result, int s, int e, HashMap<String, Integer> q){
		String key = "" + result + s + e;
		if(q.containsKey(key)){
			return q.get(key);
		}
		if(s==e){
			if(exp.charAt(s)=='1' && result==true){
				return 1;
			} else if(exp.charAt(s)=='0' && result==false){
				return 1;
			}
			return 0;
		}
		int c = 0;
		if(result){
			for(int i=s+1; i<=e; i+=2){ 	// 2???
				char op = exp.charAt(i);
				if(op=='&'){
					c += f(exp, true, s, i-1, q) * f(exp, true, i+1, e, q);
				} else if(op=='|'){
					c += f(exp, true, s, i-1, q) * f(exp, false, i+1, e, q);
					c += f(exp, false, s, i-1, q) * f(exp, true, i+1, e, q);
					c += f(exp, true, s, i-1, q) * f(exp, true, i+1, e, q);
				} else if(op=='^'){
					c += f(exp, true, s, i-1, q) * f(exp, false, i+1, e, q);
					c += f(exp, false, s, i-1, q) * f(exp, true, i+1, e, q);
				}
			}
		} else {
			for(int i=s+1; i<=e; i+=2){ 	// 2???
				char op = exp.charAt(i);
				if(op=='&'){
					c += f(exp, false, s, i-1, q) * f(exp, true, i+1, e, q);
					c += f(exp, true, s, i-1, q) * f(exp, false, i+1, e, q);
					c += f(exp, false, s, i-1, q) * f(exp, false, i+1, e, q);
				} else if(op=='|'){
					c += f(exp, false, s, i-1, q) * f(exp, false, i+1, e, q);
				} else if(op=='^'){
					c += f(exp, true, s, i-1, q) * f(exp, true, i+1, e, q);
					c += f(exp, false, s, i-1, q) * f(exp, false, i+1, e, q);
				}
			}
		}
		q.put(key, c);
		return c;
	}
} 

/*

  key: 
  * DP solution, see the detail in the book

*/