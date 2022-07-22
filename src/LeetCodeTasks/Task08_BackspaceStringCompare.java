package LeetCodeTasks;
import java.util.Stack;

/**
 * 
 * @TaskName Backspace String Compare
 * @TaskDetails Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 *  '#' means a backspace character. Note that after backspacing an empty text, the text will continue empty.
 *  Example 1:
 *  Input: s = "ab#c", t = "ad#c"
 *  Output: true
 *  Explanation: Both s and t become "ac".
 *  Example 2:
 *  Input: s = "ab##", t = "c#d#"
 *  Output: true
 *  Explanation: Both s and t become "".
 *  Example 3:
 *  Input: s = "a#c", t = "b"
 *  Output: false
 *  Explanation: s becomes "c" while t becomes "b".
 * @Source https://leetcode.com/problems/backspace-string-compare/
 */


public class Task08_BackspaceStringCompare {
	public static void run() {
		String[] s = {"ab#c", "ab##", "a#c", "##empty"};		
		String[] t = {"ad#c", "c#d#", "b", "empty"};
		int len = s.length; 
		
		for(int i=0; i<len; i++) {
			System.out.println("Test #"+(i+1));
			System.out.println("s = "+s[i] + "; t = "+t[i]);
			System.out.println("After bacspacing: s = "+ reduceBackspaces(s[i]) + "; t = " + reduceBackspaces(t[i]) + " they equal? " + backspaceCompare(s[i], t[i]));
		}		
	}
	
	 public static boolean backspaceCompare(String s, String t) {
		return reduceBackspaces(s).equals(reduceBackspaces(t));       
	    }
	
	private static String reduceBackspaces(String inputString) {
		StringBuilder answer=new StringBuilder();
		int n=inputString.length()-1;
		int removeCounter=0;
		for (int i=n; i>=0; i--) {
			char currentChar=inputString.charAt(i);
			if(currentChar=='#') {
				removeCounter++;
			} else {			
				if(removeCounter>0) {
					removeCounter--;
				} else {					
					answer.insert(0, currentChar);
				}
			}
		}		
		return answer.toString();
	}
	
	
	 private static Stack<Character> reduceBackspacesLeetCode(String S) {
		 //LeetCode solution with Stack usage
	        Stack<Character> stack = new Stack<Character>();
	        for (char c : S.toCharArray()) {
	            if (c != '#') {
	                stack.push(c);
	            } else if (!stack.isEmpty()) {
	                stack.pop();
	            }
	        }
	        return stack;
	    }
}
