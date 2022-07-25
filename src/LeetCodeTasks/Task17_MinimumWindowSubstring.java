package LeetCodeTasks;

import java.util.HashMap;

/**
 * @TaskName Minimum Window Substring
 * @TaskDetails Given two strings s and t of lengths m and n respectively,
 *              return the minimum window substring of s such that every
 *              character in t (including duplicates) is included in the window.
 *              If there is no such substring, return the empty string "". The
 *              testcases will be generated such that the answer is unique. A
 *              substring is a contiguous sequence of characters within the
 *              string. Example 1: Input: s = "ADOBECODEBANC", t = "ABC" Output:
 *              "BANC" Explanation: The minimum window substring "BANC" includes
 *              'A', 'B', and 'C' from string t.
 * @Source https://leetcode.com/problems/minimum-window-substring/
 */

public abstract class Task17_MinimumWindowSubstring {
	public static void run() {
		String[] s = {
				"ADOBECODEBANC",
				"A",
				"A",
				"acbbaca",
				"BBA"
				};
		String[] t = {
				"ABC",
				"A",
				"B", 
				"aba",
				"BA"
				};
		
		for(int i=0; i<s.length; i++) {
		System.out.println("String = " + s[i] + "; t = " + t[i] + "\nWindow = " + minWindow(s[i], t[i])
		+"\n===================================");
		}
	}

	public static String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() <t.length() ) {
			return "";
		}
		// set t into the map
		HashMap<Character, Integer> source = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			if (source.containsKey(c)) {
				source.put(c, source.get(c) + 1);
			} else {
				source.put(c, 1);
			}
		}
		// Start search
		int left = 0;
		int right = 0;
		int count = t.length();
		int minLen = s.length()+1;
		int minLeft = 0;

		for (right = 0; right < s.length(); right++) {
				char rightChar = s.charAt(right);
				if (source.containsKey(rightChar) ) {
					source.put(rightChar, source.get(rightChar) - 1);
					if (source.get(rightChar) >= 0) {
					count--;
		 		}
			}
			while (count == 0 ) {
				if (minLen >= right - left+1) {
					minLen = right - left+1;
					minLeft = left;
				}
				
				char leftChar = s.charAt(left);
				if (source.containsKey(leftChar)) {
					source.put(leftChar, source.get(leftChar) + 1);
					  if(source.get(leftChar) > 0){
					count++;
					  }
				}
				left++;
			}
		}
		return minLen==s.length()+1? "": s.substring(minLeft, minLeft + minLen);
	}

	public static String minWindowLeetCode(String s, String t) {
	    if(s == null || s.length() < t.length() || s.length() == 0){
	        return "";
	    }
	    HashMap<Character,Integer> source = new HashMap<Character,Integer>();
	    for(char c : t.toCharArray()){
	        if(source.containsKey(c)){
	            source.put(c,source.get(c)+1);
	        }else{
	            source.put(c,1);
	        }
	    }
	    int left = 0;
	    int minLeft = 0;
	    int minLen = s.length()+1;
	    int count = 0;
	    for(int right = 0; right < s.length(); right++){
	    	char rightChar = s.charAt(right);
	        if(source.containsKey(rightChar)){
	            source.put(rightChar,source.get(rightChar)-1);
	            if(source.get(rightChar) >= 0){
	                count ++;
	            }
	            while(count == t.length()){
	                if(right-left+1 < minLen){
	                	minLen = right-left+1;
	                    minLeft = left;
	                }
	                
	                char leftChar = s.charAt(left);
	                if(source.containsKey(leftChar)){
	                    source.put(leftChar,source.get(leftChar)+1);
	                    if(source.get(leftChar) > 0){
	                        count --;
	                    }
	                }
	                left ++ ;
	            }
	        }
	    }
	    if(minLen>s.length())  
	    {  
	        return "";  
	    }  
	    
	    return s.substring(minLeft,minLeft+minLen);
	}
	
}
