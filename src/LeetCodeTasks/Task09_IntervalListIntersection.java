package LeetCodeTasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @TaskName Interval list intersection
 * @TaskDetails ou are given two lists of closed intervals, firstList and
 *              secondList, where firstList[i] = [starti, endi] and
 *              secondList[j] = [startj, endj]. Each list of intervals is
 *              pairwise disjoint and in sorted order. Return the intersection
 *              of these two interval lists. A closed interval [a, b] (with a <=
 *              b) denotes the set of real numbers x with a <= x <= b. The
 *              intersection of two closed intervals is a set of real numbers
 *              that are either empty or represented as a closed interval. For
 *              example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *              Example: Input: firstList = [[0,2],[5,10],[13,23],[24,25]],
 *              secondList = [[1,5],[8,12],[15,24],[25,26]] Output:
 *              [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * @Source https://leetcode.com/problems/interval-list-intersections/
 */

public class Task09_IntervalListIntersection {
	public static void run() {
		int[][] first = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] second = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		System.out.println("My decision       " + Arrays.deepToString(intervalIntersection(first, second)));
		System.out.println("Leetcode decision " + Arrays.deepToString(intervalIntersectionLeetCode(first, second)));
	}

	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		ArrayList<int[]> answer = new ArrayList<>();
		int[] singleIntesection = new int[2];
		for (int i = 0; i < firstList.length; i++) {
			for (int k = 0; k < secondList.length; k++) {
				if (secondList[k][0] > firstList[i][1]) {
					break;
				} else if (secondList[k][1] < firstList[i][0]) {
					continue;
				} else {
					singleIntesection = getSingleIntersection(firstList[i], secondList[k]);
					answer.add(singleIntesection);
					singleIntesection = null;
				}
			}
		}

		// Convert answer to array
		int len = answer.size();
		int[][] a = new int[len][2];
		for (int i = 0; i < len; i++) {
			a[i] = answer.get(i);
		}
		return a;
	}

	private static int[] getSingleIntersection(int[] first, int[] second) {
		int[] aSegment = new int[2];
		int[] bSegment = new int[2];

		if (first[0] <= second[0]) {
			aSegment = first;
			bSegment = second;
		} else {
			aSegment = second;
			bSegment = first;
		}
		int[] answer = new int[2];
		if (aSegment[1] < bSegment[0]) {
			return null;
		} else {
			// Search for end of intersection
			if (aSegment[1] <= bSegment[1]) {
				answer[1] = aSegment[1];
			} else {
				answer[1] = bSegment[1];
			}
			// Set start of interseption
			answer[0] = bSegment[0];
		}
		return answer;
	}

	public static int[][] intervalIntersectionLeetCode(int[][] A, int[][] B) {
		// Used two point algoritm
		if (A == null || A.length == 0 || B == null || B.length == 0)
			return new int[][] {};
		List<int[]> res = new ArrayList<>();

		int i = 0, j = 0;
		int startMax, endMin;
		while (i < A.length && j < B.length) {
			startMax = Math.max(A[i][0], B[j][0]);
			endMin = Math.min(A[i][1], B[j][1]);

			if (endMin >= startMax)
				res.add(new int[] { startMax, endMin });

			if (A[i][1] == endMin)
				i++;
			if (B[j][1] == endMin)
				j++;
		}

		return res.toArray(new int[res.size()][2]);
	}

}
