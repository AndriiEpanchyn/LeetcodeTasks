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
		{  1,  3, 5, 7, 9 }, 
		{ 10, 12, 14, 16, 20 }, 
		{ 21, 23, 27, 29, 30 }, 
		{ 32, 34, 36, 38, 40 }, 
		{ 41, 43, 45, 47, 49 }, 
		{ 50, 52, 54, 56, 58 }, 
		{ 63, 67, 75, 81, 95 } };
	private static int target1 = 40;

	public static void run() {
		boolean b1 = searchMatrix(testMatrix1, target1);
	}

	private static boolean searchMatrix(int[][] source, int target) {
		System.out.println("Start proceed matrix. target = " + target );//+ "; Matrix is: " + Arrays.deepToString(source));
		System.out.println("===========================================");
		int found;

		int[] zeroColumn = new int[source.length];
		for (int i = 0; i < source.length; i++) {
			zeroColumn[i] = source[i][0];
		}

		int targetRow = findRow(zeroColumn, target);
		if (targetRow == -1) {
			found = -1;
		} else {
			found = Arrays.binarySearch(source[targetRow], target);
		}
		System.out.println("return " + (found >= 0));
		return found >= 0;
	}

	private static int findRow(int[] zeroColumn, int target) {
		System.out.println(Arrays.toString(zeroColumn));
		int startIndex = 0;
		int endIndex = zeroColumn.length - 1;
		int i = 0;
		int answer = -1;
		if (target < zeroColumn[0]) {
			return answer;
		} else if (target > zeroColumn[endIndex]) {
			return endIndex;
		} else {
			while(startIndex<=endIndex) {
				i = (startIndex + endIndex) >>> 1;
				if(startIndex==i) {
					break;
				}else if(target >= zeroColumn[i]) {
					startIndex = i+1;
				} else {
					endIndex = i - 1;
					}
				}
		answer=startIndex;		
		System.out.println("search in row "+answer);
		return answer;
			}
	}
}
