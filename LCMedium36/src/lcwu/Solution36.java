package lcwu;

import java.util.*;

public class Solution36 {
	public boolean isValidSudoku(char[][] board) {
		int size = board.length;
		Set set = new HashSet<Character>();
		Set set1 = new HashSet<Character>();
		for (int i = 0; i <size ; i++) {
			for (int j = 0; j <size ; j++) {
				if(board[i][j]>=48&&board[i][j]<=57){
					if(set.contains(board[i][j])){
						return false;
					}else {
						set.add(board[i][j]);
						System.out.print(board[i][j]);
					}
				}

			}
			System.out.println();
			set.clear();
		}
		System.out.println("---------------------------");
		set.clear();
		for (int j = 0; j <9; j++) {
			for (int i = 0; i <9 ; i++) {
				if(board[i][j]>=48&&board[i][j]<=57){
					if(set.contains(board[i][j])){
						return false;
					}else {
						set.add(board[i][j]);
						System.out.print(board[i][j]);
					}
				}
			}
			System.out.println();
			set.clear();
		}
		set.clear();
		System.out.println("-----------------------------");



		for (int i = 0; i <3 ; i++) {
			for (int j = 0; j <3 ; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l <3 ; l++) {
						if(board[k+i*3][l+j*3]>=48&&board[k+i*3][l+j*3]<=57){
							if(set.contains(board[k+i*3][l+j*3])){
								return false;
							}else {
								set.add(board[k+i*3][l+j*3]);
							}
						}
					}
				}
				set.clear();
			}

		}


		return true;
	}
}
