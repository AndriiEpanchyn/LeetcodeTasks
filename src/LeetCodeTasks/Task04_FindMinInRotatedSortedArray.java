package LeetCodeTasks;
import java.time.Instant;
import java.util.Arrays;

/**
 * 
 * @TaskName Find the Minimum in rotated sorted array
 * @TaskDetails Suppose an array of length n sorted in ascending order is
 *              rotated between 1 and n times. For example, the array nums =
 *              [0,1,2,4,5,6,7] might become: [4,5,6,7,0,1,2] if it was rotated
 *              4 times. [0,1,2,4,5,6,7] if it was rotated 7 times. Notice that
 *              rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 *              in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. Given the
 *              sorted rotated array nums of unique elements, return the minimum
 *              element of this array. You must write an algorithm that runs in
 *              O(log n) time.
 * @Source https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

public class Task04_FindMinInRotatedSortedArray {
	public static void run() {
		int[][] test = new int[][] { { 1 }, { 1, 2 }, { 2, 1 }, { 0, 1, 2, 3, 4, 5, 6 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 19, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, 12, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -5, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -6, -5, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2 }, };

		System.out.println("Start first test");
		Instant startTime = Instant.now();
		for (int i = 0; i < test.length; i++) {
			System.out.println("Test #" + (i + 1) + ". Array: " + Arrays.toString(test[i]));
			System.out.println("minimum = " + findMin(test[i]));
			System.out.println("-------------------------");
		}
		Instant finishTime = Instant.now();

		System.out.println("Start second test");
		Instant startTime2 = Instant.now();
		for (int i = 0; i < test.length; i++) {
			System.out.println("Test #" + (i + 1) + ". Array: " + Arrays.toString(test[i]));
			System.out.println("minimum = " + leetCodefindMin(test[i]));
			System.out.println("-------------------------");
		}
		Instant finishTime2 = Instant.now();

		System.out.println("First test finished. Time spent: " + (finishTime.getNano() - startTime.getNano()) + "ns");
		System.out
				.println("Second test finished. Time spent: " + (finishTime2.getNano() - startTime2.getNano()) + "ns");
		System.out.println("difference between methods is: "
				+ ((finishTime.getNano() - startTime.getNano()) - (finishTime2.getNano() - startTime2.getNano()))
				+ "ns");
	}

	public static int findMin(int[] nums) {
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int min = (nums[0] > nums[endIndex] ? nums[endIndex] : nums[0]);
		if (nums.length == 1 || nums[0] < nums[endIndex]) {
			return nums[0];
		} else {
			while (startIndex <= endIndex) {
				int i = (startIndex + endIndex) / 2;
				if (min == nums[i]) {
					return min;
				}
				if (nums[i] >= nums[0]) {
					startIndex = i + 1;
				} else {
					if (min > nums[i]) {
						min = nums[i];
					}
					endIndex = i - 1;
				}
			}
		}
		return min;
	}

	public static int leetCodefindMin(int[] num) {
		// Solution from leetcode
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		int start = 0, end = num.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (mid > 0 && num[mid] < num[mid - 1]) {
				return num[mid];
			}
			if (num[start] <= num[mid] && num[mid] > num[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return num[start];
	}
}
