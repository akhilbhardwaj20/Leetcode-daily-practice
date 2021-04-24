class Solution {
    //TC - O(r*c)
    //SC - O(r*c)
    private int[] dr = {-1,1,0,0};
    private int[] dc = {0,0,-1,1};
    private int r,c;
    
    public void solve(char[][] board) {
        
         if(board == null || board.length==0) return;
         r = board.length;
         c = board[0].length;
        
        // first find all the 'o's at the edges 
        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O') {
                bfs(i,0,board);
            }
        }
        for(int i = 0; i < r; i++) {
            if(board[i][c-1] == 'O') {
                bfs(i,c-1,board);
            }
        }
        for(int j = 0; j < c; j++) {
            if(board[0][j] == 'O') {
                bfs(0,j,board);
            }
            
        }
        for(int j = 0; j < c; j++) {
            if(board[r-1][j] == 'O') {
                bfs(r-1,j,board);
            }
        }
        // for '0's at all aplaces except at borders, change them to'X'
        for(int i = 0; i < r; i++) {
            for(int j= 0; j < c; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void bfs(int x, int y, char[][] board) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        board[x][y] = 'A';
        
        while(!queue.isEmpty()) {
            Pair node = queue.remove();
            for(int i = 0; i < 4; i++) {
                int rr = node.x + dr[i];
                int cc = node.y + dc[i];
                // out of bounds check
                if(rr >= 0 && rr < r  && cc >= 0 && cc < c && board[rr][cc] == 'O') {
                    queue.add(new Pair(rr,cc));
                    board[rr][cc] = 'A';
                } 
                
            }
        }
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
