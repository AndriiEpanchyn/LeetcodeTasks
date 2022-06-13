import java.util.Arrays;

/**
 * 
 * @TaskName Find First and Last Position of Element in Sorted Array
 * @TaskDetails Given an array of integers nums sorted in non-decreasing order,
 *              find the starting and ending position of a given target value.
 *              If target is not found in the array, return [-1, -1]. You must
 *              write an algorithm with O(log n) runtime complexity.
 * @Source https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 */

public class Task01_FindFirstAndLAstElement {

	public static void run() {
		int[] nums1 = new int[] { 5, 7, 7, 8, 8, 10 };
		searchRange(nums1, 8);
	}

	public static int[] searchRange(int[] nums, int target) {
		System.out.println("Start searching " + target + " in array: ");
		System.out.println(Arrays.toString(nums));
		int[] answer = new int[] { -1, -1 };
		if (isArrayValid(nums)) {
			int foundIndex = binaryEncreasingSearch(nums, target);
			if (foundIndex >= 0) {
				answer = findAllEqualsInContiniousRange(nums, foundIndex);
			}
		}
		System.out.println("Answer is: " + Arrays.toString(answer));
		System.out.println("=================================");
		return answer;
	}

	private static int[] findAllEqualsInContiniousRange(int[] nums, int foundIndex) {
		int[] answer = new int[] { foundIndex, foundIndex };
		int target = nums[foundIndex];
		for (int i = foundIndex; i >= 0; i--) {
			if (target != nums[i]) {
				answer[0] = i + 1;
				break;
			} else {
				answer[0] = i;
			}
		}
		for (int i = foundIndex; i < nums.length; i++) {
			if (target != nums[i]) {
				answer[1] = i - 1;
				break;
			} else {
				answer[1] = i;
			}
		}
		return answer;
	}

	private static int binaryEncreasingSearch(int[] nums, int target) {
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int i = 0;
		int answer = -1;

		while (startIndex <= endIndex) {
			i = (startIndex + endIndex) >>> 1;
			if (nums[i] == target) {
				return i;
			} else if (nums[i] > target) {
				endIndex = i - 1;
			} else {
				startIndex = i + 1;
			}
		}
		return answer;
	}

	private static boolean isArrayValid(int[] nums) {
		boolean answer = false;
		if (nums == null || nums.length == 0) {
			return false;
		}
		if (nums.length == 1) {
			return true;
		} else {
			int start = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] < start) {
					return false;
				} else {
					start = nums[i];
				}
			}
			answer = true;
		}
		return answer;
	}

}
