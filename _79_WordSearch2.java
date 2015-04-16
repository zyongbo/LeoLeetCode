package leo.algorithms;

/**
 * 
 * @author zyongbo
 * @problem Given a 2D board and a word, find if the word exists in the grid.
 * @problem The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * @problem horizontally or vertically neighboring. The same letter may not be used more than once.
 * @example Given board = [["ABCE"], ["SFCS"],["ADEE"]], word = "ABCCED", -> return true; word = "SEE", -> return true; word = "ABCB", -> return false.
 * 
 */

public class _79_WordSearch2 {
	static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
    	if(board==null || board.length==0) {
			return false;
		}
    	if (word==null || word.length() == 0)
            return true;
    	
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isFind(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private static boolean isFind(char[][] board, String word, int n, int i, int j) {
        //termination condition
    	if (n == word.length())
            return true;
    	
    	//margin condition
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (visited[i][j])
            return false;
        if (word.charAt(n) != board[i][j])
            return false;
        
        visited[i][j] = true;
        boolean result = isFind(board, word, n + 1, i - 1, j) || isFind(board, word, n + 1, i + 1, j) 
        		|| isFind(board, word, n + 1, i, j - 1) || isFind(board, word, n + 1, i, j + 1);
        	
        visited[i][j] = false;
        return result;
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
