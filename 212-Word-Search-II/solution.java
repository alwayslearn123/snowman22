public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
                List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean[][] visited = new boolean[board.length][board[0].length];
		        for( String word : words ) {
					dfs(board, visited, res, word, 0, i, j);
				}
			}
		}
        return res;
    }
    
        private void dfs(char[][] board, boolean[][] visited, List<String> res, String word, int start, int row, int col)
    {
    	if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
    	
    	visited[row][col] = true;
    	if (board[row][col] == word.charAt(start))
    	{
    		if (start == word.length() - 1)
    		{
    			//System.out.println("word: " + word + " row: " + row + ", col: " + col);
        		res.add(word);
        		return;
    		}
    		
    		dfs(board, visited, res, word, start + 1, row+1, col);
    		dfs(board, visited, res, word, start + 1, row-1, col);
    		dfs(board, visited, res, word, start + 1, row, col+1);
    		dfs(board, visited, res, word, start + 1, row, col-1);
    	}
    	visited[row][col] = false;
    }
}