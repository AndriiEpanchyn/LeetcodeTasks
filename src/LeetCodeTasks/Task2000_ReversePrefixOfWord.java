package LeetCodeTasks;
/**
 * @TaskName Reverse Prefix of Word
 * @TaskDetails Given a 0-indexed string word and a character ch, reverse the
 *              segment of word that starts at index 0 and ends at the index of
 *              the first occurrence of ch (inclusive). If the character ch does
 *              not exist in word, do nothing. For example, if word = "abcdefd"
 *              and ch = "d", then you should reverse the segment that starts at
 *              0 and ends at 3 (inclusive). The resulting string will be
 *              "dcbaefd".
 * @Source https://leetcode.com/problems/reverse-prefix-of-word/
 */
public class Task2000_ReversePrefixOfWord {
	public static void run() {
		String word = "abcdefghrd";
		char c = 'd';
		
		System.out.println("Word is: " + word + "; char is: "+ c + "; rotated: " + reversePrefix(word,c));

	}

	public static String reversePrefix(String word, char ch) {		
		if(word.contains(String.valueOf(ch) )) {
			int charIndex = word.indexOf(ch)+1;
			char[] subStringArray = word.substring(0, charIndex ).toCharArray();		
			StringBuilder answer = new StringBuilder();
			for (int i = charIndex-1; i>=0; i--) {
				answer.append(subStringArray[i]);
			}
			answer.append(word.substring(charIndex));
			return answer.toString();
		} else return word;
	}
}
