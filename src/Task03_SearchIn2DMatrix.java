import java.util.Arrays;

/**
 * 
 * @TaskName Search in 2D Matrix
 * @TaskDetails Write an efficient algorithm that searches for a value target in
 *              an m x n integer matrix matrix. This matrix has the following
 *              properties: Integers in each row are sorted from left to right.
 *              The first integer of each row is greater than the last integer
 *              of the previous row.
 * @Source https://leetcode.com/problems/search-a-2d-matrix/
 * 
 */
public class Task03_SearchIn2DMatrix {
	private static int[][] testMatrix1 = new int[][] { 
		{ 1, 3, 5, 7, 9 }, 
		{ 10, 12, 14, 16, 20 },
		{ 21, 23, 27, 29, 30 }, 
		{ 32, 34, 36, 38, 40 }, 
		{ 41, 43, 45, 47, 49 }, 
		{ 50, 52, 54, 56, 58 },
		{ 63, 67, 75, 81, 95 } };
	private static int target1 = 5;

	public static void run() {
		boolean b1 = searchMatrix(testMatrix1, target1);
	}

	private static boolean searchMatrix(int[][] source, int target) {
		int found=-1;
		int targetRow = findRow(source, target);
		if (targetRow != -1) {
			found = Arrays.binarySearch(source[targetRow], target);
		}
		System.out.println("return " + (found >= 0));
		return found >= 0;
	}

	private static int findRow(int[][] source, int target) {
		int[] zeroColumn = new int[source.length];
		int[] lastColumn = new int[source.length];
		for (int i = 0; i < source.length; i++) {
			zeroColumn[i] = source[i][0];
			lastColumn[i] = source[i][source[0].length - 1];
		}

		int startIndex = 0;
		int endIndex = zeroColumn.length - 1;
		int i = 0;
		int answer = -1;
		if (target < zeroColumn[0]) {
			return answer;
		} else if (target > zeroColumn[endIndex]) {
			return endIndex;
		} else {
			while (startIndex <= endIndex) {
				i = (startIndex + endIndex) >>> 1;
				if (target >= zeroColumn[i] && target <= lastColumn[i]) {
					answer = i;
					break;
				} else if (target > lastColumn[i]) {
					startIndex = i + 1;
				} else {
					endIndex = i - 1;
				}
			}
			return answer;
		}
	}
	
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		//Answer from leetcode
		int n = matrix[0].length, start = 0, end = matrix.length*n-1, mid;
		while(start<=end) {
			mid = (start + end)/2;
			if(matrix[mid/n][mid%n]==target) return true;
			if(target > matrix[mid/n][mid%n]) start = mid + 1;
			else end = mid - 1;
		}
		return false;
	}
}
