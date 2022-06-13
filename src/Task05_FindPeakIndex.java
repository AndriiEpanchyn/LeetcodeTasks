import java.util.Arrays;

/**
 * @TaskName Find any peak in array
 * @TaskDetails A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. 
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 * @Source https://leetcode.com/problems/find-peak-element/
 */
public class Task05_FindPeakIndex {
	public static void run() {
		int[] nums1 = { 1, 2, 1, 3, 1, 2, 1, 4, 5, 6 };
		System.out.println("Array = " + Arrays.toString(nums1));
		System.out.println("Peak = " + findPeak(nums1));

	}

	public static int findPeak(int[] nums) {
		int N = nums.length;
		if (N == 1) {
			return 0;
		}
		int left = 0, right = N - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
	}
}
