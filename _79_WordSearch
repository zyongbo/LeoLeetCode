package leo.algorithms;


/**
 * 
 * @author zyongbo
 * @problem Given a 2D board and a word, find if the word exists in the grid.
 * @problem The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * @problem horizontally or vertically neighboring. The same letter may not be used more than once.
 * @example Given board = [["ABCE"], ["SFCS"],["ADEE"]], word = "ABCCED", -> return true; word = "SEE", -> return true; word = "ABCB", -> return false.
 */


public class _79_WordSearch {
	
	public static boolean exist(char[][] board, String word) {
		if(board==null || board.length==0) {
			return false;
		}
		
		if(word==null || word.length()==0) {
			return true;
		}
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				if(isFind(visited, board, word, 0, row, col)) {
					return true;
				}
			}
		}

		return false;
	}
	
	private static boolean isFind(boolean[][] visited, char[][] board, String word, int i, int row, int col) {
		//termination condition
		if(i==word.length()) {
			return true;
		}
		
		//margin condition
		if(row<0 || row>board.length-1 || col<0 || col>board[0].length-1) {
			return false;
		}
		if(visited[row][col]) {
			return false;
		}
		if(board[row][col] != word.charAt(i)) {
			return false;
		}
		
		visited[row][col] = true;
		
		if(isFind(visited, board, word, i+1, row-1, col)) {
			return true;
		}
		
		if(isFind(visited, board, word, i+1, row+1, col)) {
			return true;
		}
		
		if(isFind(visited, board, word, i+1, row, col-1)) {
			return true;
		}
		
		if(isFind(visited, board, word, i+1, row, col+1)) {
			return true;
		}
		
		visited[row][col] = false;
		
		return false;
	}
	
	public static void main(String[] args) {
		
		char[][] board = {{'A','B','C','E'},
						  {'S','F','C','S'},
						  {'A','D','E','E'}};
		
		System.out.print(board.length);
		System.out.println(board[0].length);
		
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
	}
}
