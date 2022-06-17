/**
 * @TaskName Container with most water
 * @TaskDetails You are given an integer array height of length n. There are n
 *              vertical lines drawn such that the two endpoints of the ith line
 *              are (i, 0) and (i, height[i]). Find two lines that together with
 *              the x-axis form a container, such that the container contains
 *              the most water. Return the maximum amount of water a container
 *              can store. Notice that you may not slant the container.
 * @Source https://leetcode.com/problems/container-with-most-water/
 */

public class Task10_ContainerWithMostWater {
	/**
	 * Because the width (righrIndex - leftIndex) will reducing during iteration,
	 * MaxArea can rise only if minimal high will rise relatively previous value.
	 */
	public static void run() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println("Max area = " + maxArea(height));
	}

	public static int maxArea(int[] height) {
		int maxArea = 0;
		int right = height.length - 1;
		int left = 0;

		while (left <= right) {
			if ((right - left) * Math.min(height[left], height[right]) > maxArea) {
				maxArea = (right - left) * Math.min(height[left], height[right]);
			}
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}
}
