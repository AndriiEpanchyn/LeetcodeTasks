import java.util.Arrays;

/**
 * @TaskName Find any peak in array
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
