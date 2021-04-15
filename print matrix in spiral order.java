  // problem link ------>  https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1#
       // TC- O(r*c)
       // SC - O(r*c)
static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
          ArrayList<Integer>list = new ArrayList<>();
       
         if(r==0) {
            return list;
        }
       
        
       
        int left = 0, right = c-1, top = 0, bottom = r-1;
        int d = 0;
        while(left<=right && top<=bottom) {
            if(d == 0) {
                for(int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                d = 1;  top++;
            } else if(d == 1) {
                for(int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                 d = 2;  right--;
            } else if(d == 2) {
                for(int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                d = 3;  bottom--;
            } else if(d == 3) {
                for(int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                d = 0;  left++;
            }
        }
        return list;
    }
