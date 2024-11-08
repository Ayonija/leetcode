class Solution {
    private char[][] board;
    private String word;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS from each cell
                if (dfs(i, j, 0)) {
                    return true; // Word found
                }
            }
        }
        return false; // Word not found
    }

    private boolean dfs(int x, int y, int index) {
        // Check if we have found the word
        if (index == word.length()) {
            return true;
        }
        
        // Check boundaries and if the current cell matches the current character of the word
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        visited[x][y] = true;

        // Explore all four possible directions: up, down, left, right
        boolean found = dfs(x + 1, y, index + 1) ||
                        dfs(x - 1, y, index + 1) ||
                        dfs(x, y + 1, index + 1) ||
                        dfs(x, y - 1, index + 1);

        // Unmark the cell as visited for backtracking
        visited[x][y] = false;

        return found;
    }
}