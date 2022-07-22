package LeetCodeTasks;

/**
 * @TaskName Minimum Size Subarray Sum
 * @TaskDetails Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] 
 * of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * @Source https://leetcode.com/problems/minimum-size-subarray-sum/
 */

import java.util.Arrays;

public class Task12_MinimumSizeSubarraySum {
	public static void run() {
		int[][] test = { { 0, 3, 1, 0, 4 } };
		int target = 7;
		for (int i = 0; i < test.length; i++) {
			System.out.println("Target = " + target);
			System.out.println("Source: " + Arrays.toString(test[i]));
			System.out.println("Answer = " + minSubArrayLen(target, test[i]));
			System.out.println("Answer 2 = " + minSubArrayLenLeetCode(target, test[i]));
			System.out.println("=======================================");
		}
	}

	public static int minSubArrayLen(int target, int[] nums) {

		int minLen = nums.length + 1;
		int sum = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target && left <= right) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left++];
			}
		}

		return minLen == nums.length + 1 ? 0 : minLen;
	}

	public static int minSubArrayLenLeetCode(int s, int[] nums) {
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			while (sum >= s) {
				ans = Math.min(ans, i + 1 - left);
				sum -= nums[left++];
			}
		}
		return (ans != Integer.MAX_VALUE) ? ans : 0;
	}

}
