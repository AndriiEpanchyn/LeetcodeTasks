package LeetCodeTasks;

import java.util.Arrays;

/**
 * @TaskName Longest Nice Substring
 * @TaskDetails A string s is nice if, for every letter of the alphabet that s
 *              contains, it appears both in uppercase and lowercase. For
 *              example, "abABB" is nice because 'A' and 'a' appear, and 'B' and
 *              'b' appear. However, "abA" is not because 'b' appears, but 'B'
 *              does not. Given a string s, return the longest substring of s
 *              that is nice. If there are multiple, return the substring of the
 *              earliest occurrence. If there are none, return an empty string.
 * @Source https://leetcode.com/problems/longest-nice-substring/
 */

public class Task1763_LongestNiceSubstringUSOLVED {
	public static void run() {
//		String s = "xLeElzxgHzcWslEdgMGwEOZCXwwDMwcEhgJHLL"; 
		String s = "cAaAaACBbdc"; // Achieved "aAa"
		System.out.println("   String is: " + s + "\nSubstring is: " + longestNiceSubstring(s));
	}

	public static String longestNiceSubstring(String s) {
		int length = s.length();
		if (length <2) {
			return "";
		} else if (isStringNice(s)) {
			return s;
		} else {
			String s1 = longestNiceSubstring(s.substring(1, length));
			String s2 = longestNiceSubstring(s.substring(0, length - 1));
			return s1.length() > s2.length() ? s1 : s2;
		}
	}

	public static boolean isStringNice(String s) {
		boolean[] smallLetters = new boolean[26];
		boolean[] bigLetters = new boolean[26];

		for (char c : s.toCharArray()) {
			int temp = (byte) c;
			if (temp > 96 && temp < 123) {
				smallLetters[temp - 97]=true;
			} else if (temp > 64 && temp < 91) {
				bigLetters[temp - 65]=true;
			}
		}
		boolean answer = true;
		for (int i = 0; i < 26; i++) {
			if (smallLetters[i] != bigLetters[i]) {
				answer = false;
			}
		}
		return answer;
	}
}
