package LeetCodeTasks;
import java.util.Arrays;

/**
 * 
 * @TaskName Find the Position of the target element in rotated sorted array
 * @TaskDetails There is an integer array nums sorted in ascending order (with
 *              distinct values). Prior to being passed to your function, nums
 *              is possibly rotated at an unknown pivot index k (1 <= k <
 *              nums.length) such that the resulting array is [nums[k],
 *              nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 *              (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at
 *              pivot index 3 and become [4,5,6,7,0,1,2]. Given the array nums
 *              after the possible rotation and an integer target, return the
 *              index of target if it is in nums, or -1 if it is not in nums.
 *              You must write an algorithm with O(log n) runtime complexity.
 * @Source https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 */

public class Task02_FindElementInRotetedSortedArray {
	static int[][] testNums;
	static String[] testDescriptions;

	public static void run() {
		System.out.println("Start Task02_FindElementInRotetedSortedArray\nTarget element is 4\n=====================");
		// Target =4;
		testNums = new int[][] { {}, // Empty array
				{ 4 }, // Correct array of 1 element
				{ 8 }, // Correct array of 1 incorrect element
				{ 8, 8, 9 }, // Incorrect array of 2 equals elements
				{ 9, 8, 7 }, // Incorrect array of decreasing elements
				{ 5, 6, 7, 8, 7, 0, 4 }, // Incorrect array with incorrect gap 1
				{ 5, 6, 7, 8, 9, 7, 8 }, // Incorrect array with incorrect gap 2
				{ 4, 5, 6, 0, 1, 2, 3 }, // Correct Array with even number of elements and target at 0 index
				{ 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 }, // Correct Array with even number of elements and target at last index
				{ 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 }, // Correct Array with even number of elements and target in a middle
				{ 8, 9, 10, 0, 1, 2, 3, 5, 6, 7 }, // Correct Array with even number of elements and have no target
				{ 4, 5, 6, 7, 8, 0, 1, 2, 3 }, // Correct Array with odd number of elements and target at 0 index
				{ 5, 6, 7, 8, 0, 1, 2, 3, 4 }, // Correct Array with odd number of elements and target at last index
				{ 8, 9, 1, 2, 3, 4, 5, 6, 7 }, // Correct Array with odd number of elements and target in a middle
				{ 5, 6, 7, 8, 9, 0, 1, 2, 3 }, // Correct Array with odd number of elements and have no target
		};

		testDescriptions = new String[] { " Empty array", " Correct array of 1 element",
				" Correct array of 1 incorrect element", " Incorrect array of 2 equals elements",
				" Incorrect array of decreasing elements", " Incorrect array with incorrect gap 1",
				" Incorrect array with incorrect gap 2",
				" Correct Array with even number of elements and target at 0 index",
				" Correct Array with even  number of elements and target at last index",
				" Correct Array with even number of elements and target in a middle",
				" Correct Array with even number of elements and have no target",
				" Correct Array with odd number of elements and target at 0 index",
				" Correct Array with odd number of elements and target at last index",
				" Correct Array with odd number of elements and target in a middle",
				" Correct Array with odd number of elements and have no target" };

		initTest();
	}

	private static void initTest() {
		for (int i = 0; i < testNums.length; i++) {
			System.out.println(
					"Test ¹" + (i + 1) + testDescriptions[i] + ";\nTest array: " + Arrays.toString(testNums[i]));
			// System.out.println("Array is valid: " + isArrayValid(testNums[i]));
			int foundIndex = search(testNums[i], 4);
			System.out.println("Answer is: " + foundIndex);
			System.out.println("====================================");
		}
	}

	public static int search(int[] nums, int target) {
		int answer = -1;
		if (isArrayValid(nums)) {
			answer = findValueIndex(nums, target);
		}
		return answer;
	}

	private static boolean isArrayValid(int[] nums) {
		boolean answer = false;
		boolean isSwitchPossible = true;
		// check array
		if (nums == null || nums.length == 0) {
			return false;
		} else if (nums.length == 1) {
			return true;
		}
		// check elements
		int previous = nums[0];
		for (int current = 1; current < nums.length; current++) {
			if (isSwitchPossible) {
				if (nums[current] > previous) {
					answer = true;
					previous = nums[current];
				} else if (nums[current] < nums[0]) {
					isSwitchPossible = false;
					answer = true;
					previous = nums[current];
				} else {
					return false;
				}
			} else if (nums[current] > previous && nums[current] < nums[0]) {
				answer = true;
				previous = nums[current];
			} else {
				return false;
			}
		}

		return answer;
	}

	private static int findValueIndex(int[] nums, int target) {
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int i = 0;
		int answer = -1;

		while (startIndex <= endIndex) {
			i = (startIndex + endIndex) >>> 1;

			if (nums[i] == target) {
				return i;
			}
			if ((target < nums[0] && nums[i] < nums[0]) || (target >= nums[0] && nums[i] >= nums[0])) {
				if (target < nums[i]) {
					endIndex = i - 1;
				} else {
					startIndex = i + 1;
				}
			} else if (target >= nums[0] && nums[i] <= nums[0]) {
				endIndex = i - 1;
			} else {
				startIndex = i + 1;
			}
		}
		return answer;
	}
}
