// TC - O(N2)
// SC - O(N2)

static int findMaxValue(int N,int mat[][])
    {
        //stores maximum value
        int maxValue = Integer.MIN_VALUE;
      
        // maxArr[i][j] stores max of elements in matrix
        // from (i, j) to (N-1, N-1)
        int maxArr[][] = new int[N][N];
      
        // last element of maxArr will be same's as of
        // the input matrix
        maxArr[N-1][N-1] = mat[N-1][N-1];
      
        // preprocess last row
        int maxv = mat[N-1][N-1];  // Initialize max
        for (int j = N - 2; j >= 0; j--)
        {
            if (mat[N-1][j] > maxv)
                maxv = mat[N - 1][j];
            maxArr[N-1][j] = maxv;
        }
      
        // preprocess last column
        maxv = mat[N - 1][N - 1];  // Initialize max
        for (int i = N - 2; i >= 0; i--)
        {
            if (mat[i][N - 1] > maxv)
                maxv = mat[i][N - 1];
            maxArr[i][N - 1] = maxv;
        }
      
        // preprocess rest of the matrix from bottom
        for (int i = N-2; i >= 0; i--)
        {
            for (int j = N-2; j >= 0; j--)
            {
                // Update maxValue
                if (maxArr[i+1][j+1] - mat[i][j] > maxValue)
                    maxValue = maxArr[i + 1][j + 1] - mat[i][j];
      
                // set maxArr (i, j)
                maxArr[i][j] = Math.max(mat[i][j],
                                   Math.max(maxArr[i][j + 1],
                                       maxArr[i + 1][j]) );
            }
        }
      
        return maxValue;
    }
