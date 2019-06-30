package lcwu;

public class Solution994 {
	public int orangesRotting(int[][] grid) {
		int row = grid.length;
		if (row == 0)return 0;
		int column = grid[0].length;
		int res = 0;
		while(true){
			boolean flag = false;
			int[][] used = new int[row][column];//记录是否已经遍历过某个单元格
			for (int i = 0; i < row;++i){
				for (int j = 0; j < column;++j){
					if (used[i][j] == 0 && grid[i][j] == 2){
						flag = help(grid,i,j,used) || flag;
					}
				}
			}
			res++;
			if (!flag){//当某次没有修改某个单元格的状态，则说明不能再腐败了
				break;
			}
		}
		for (int i = 0; i < row;++i){
			for (int j = 0; j < column;++j){
				if (grid[i][j] == 1){
					return -1;
				}
			}
		}
		return res-1;
	}
	private boolean help(int[][] grid,int x, int y,int[][] used){
		if(grid[x][y] != 2 || used[x][y] == 1)return false;
		boolean flag = false;
		if(x-1>= 0 && grid[x-1][y] == 1){
			grid[x-1][y] = 2;
			flag = true;
			used[x-1][y] = 1;
		}
		if(x+1 < grid.length && grid[x+1][y] == 1){
			grid[x+1][y] = 2;
			flag = true;
			used[x+1][y] = 1;
		}
		if (y-1 >= 0 && grid[x][y-1] == 1){
			grid[x][y-1] = 2;
			flag = true;
			used[x][y-1] = 1;
		}
		if (y+1 < grid[0].length && grid[x][y+1] == 1){
			grid[x][y+1] = 2;
			flag = true;
			used[x][y+1] = 1;
		}
		return flag;
	}
}
