package LeetCodeTasks;
import java.util.Arrays;

/**
 * @TaskName Remove Element
 * @TaskDetails Given an integer array nums and an integer val, remove all
 *              occurrences of val in nums in-place. The relative order of the
 *              elements may be changed. Since it is impossible to change the
 *              length of the array in some languages, you must instead have the
 *              result be placed in the first part of the array nums. More
 *              formally, if there are k elements after removing the duplicates,
 *              then the first k elements of nums should hold the final result.
 *              It does not matter what you leave beyond the first k elements.
 *              Return k after placing the final result in the first k slots of
 *              nums. Do not allocate extra space for another array. You must do
 *              this by modifying the input array in-place with O(1) extra
 *              memory.
 * @Source https://leetcode.com/problems/remove-element/
 */
public class Task14_RemoveElement {
	public static void run() {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2; // answer=5
		int[] nums2 = { 3, 2, 2, 3 };
		int val2 = 3;//answer=2

		System.out.println("Array = " + Arrays.toString(nums) + "\nremoved value = " + val + "\nAnswer = "
				+ removeElement(nums, val) + "\nNew array = " + Arrays.toString(nums));
		System.out.println("========================");
		System.out.println("Array2 = " + Arrays.toString(nums2) + "\nremoved value2 = " + val2 + "\nAnswer2 = "
				+ removeElement(nums2, val2) + "\nNew array2 = " + Arrays.toString(nums2));

	}

	public static int removeElement(int[] nums, int val) {
		int indexToReturn = 0;
		int current = 0;
		int len = nums.length;
		while (current < len) {
			if (nums[current] != val) {
				nums[indexToReturn] = nums[current];
				indexToReturn++;
			}
			current++;
		}
		return indexToReturn;
	}

	public int removeElementLeetCode(int[] A, int elem) {
		int m = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[m] = A[i];
				m++;
			}
		}
		return m;
	}
}
