class Solution {
    // TC - O(n+m) 
    // SC - O(1)
    int rowWithMax1s(int arr[][], int n, int m) {
        
        int j = m-1;
        int row = 0;
       
        for(int i = 0; i < n; i++) {
            while(j >= 0) {
                if(arr[i][j] == 1) {
                    j--;
                    row = i;
                }
                
                else {
                    break;
                }
                
            }
        }
        return row;
    }
}
