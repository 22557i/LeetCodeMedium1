package lcwu;

public class Solution240 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row==0)return false;
		int column = matrix[0].length;
		for (int i = 0; i <row ; i++) {
			for (int j = 0; j <column ; j++) {
				if(target>matrix[i][column-1])break;
				else {
					if(target==matrix[i][j])return true;
				}
			}
		}
		return false;
	}
}
