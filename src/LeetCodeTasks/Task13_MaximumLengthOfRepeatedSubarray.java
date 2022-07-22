package LeetCodeTasks;

import java.util.Arrays;

/**
 * @TaskName Maximum Length of Repeated Subarray
 * @TaskDetails Given two integer arrays nums1 and nums2, return the maximum
 *              length of a subarray that appears in both arrays.
 * @Source https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */

public class Task13_MaximumLengthOfRepeatedSubarray {
	public static void run() {
		int[] nums1 = { 1, 2, 3, 2, 1, 0};
		int[] nums2 = { 3, 2, 1, 0, 4, 7};

		System.out.println("nums 1 = " + Arrays.toString(nums1));
		System.out.println("nums 2 = " + Arrays.toString(nums2));
		System.out.println("Answer = " + findLength(nums1, nums2));
	}

	public static int findLength(int[] nums1, int[] nums2) {
		int answer = 0;
		int rows = nums1.length;
		int columns = nums2.length;
		int[][] array = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (nums1[i] == nums2[j]) {
					if (i == 0 || j == 0) {
						array[i][j] = 1;
					} else {
						array[i][j] = 1 + array[i - 1][j - 1];
					}
					answer = answer < array[i][j] ? array[i][j] : answer;
				}
			}
		}
		return answer;
	}
}
