class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // boolean[][] vis = new boolean[image.length][image[0].length];
        if(newColor != image[sr][sc]) {
            dfs(image,sr,sc,newColor,image[sr][sc]);
        }
        
        return image;
    }
    
    private void dfs(int [][] image, int sr, int sc, int newColor, int baseColor) {
        int r1 = image.length;
        int c1 = image[0].length;
        
        if(sr >=  r1 || sc >= c1 || sr < 0 || sc < 0 || image[sr][sc] != baseColor) {
            return;
        }
        
        // mark the node as visited
        // optimisation : we dont need a vis array here
        // vis[sr][sc] = true;
        
        //The operation that I need to perform at every node is to check tell all the nodes that //are adjucent to me to check their if they are the same color as I am and if yes change their //color
         image[sr][sc] = newColor;
        dfs(image,sr,sc-1,newColor,baseColor);
        dfs(image,sr,sc+1,newColor,baseColor);
        dfs(image,sr-1,sc,newColor,baseColor);
        dfs(image,sr+1,sc,newColor,baseColor);
        
        
        
        // TC - O(no of rows * no of cols)
        // SC-  O(no of rows * no of cols)
    }
}
