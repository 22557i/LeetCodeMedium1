package lcwu;

public class Solution64 {
	public int minPathSum(int[][] grid){
		if(grid==null)return 0;
		int column = grid[0].length;
		int row = grid.length;

		for (int i = 0; i <row ; i++) {
			for (int j = 0; j <column ; j++) {
				if(i==0&&j==0)continue;
				else if(i==0)grid[i][j]+=grid[i][j-1];
				else if(j==0)grid[i][j]+=grid[i-1][j];
				else grid[i][j]+=Math.min(grid[i][j-1],grid[i-1][j]);
			}
			
		}
		return grid[row-1][column-1];
	}
}
