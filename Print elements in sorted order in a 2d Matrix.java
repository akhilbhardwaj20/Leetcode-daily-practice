problem link ------->  https://practice.geeksforgeeks.org/problems/sorted-matrix2333/1#
class Solution {
    // TC - O(N2)
    // SC- O(1) 
    int[][] sortedMatrix(int N, int Mat[][]) {
        
        int size = N*N;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size-1; j++) {
                if(Mat[j/N][j%N] > Mat[(j+1)/N][(j+1)%N]) {
                    int temp = Mat[j/N][j%N];
                    Mat[j/N][j%N] = Mat[(j+1)/N][(j+1)%N];
                    Mat[(j+1)/N][(j+1)%N] = temp;
                }
            }
        }
        return Mat;
    }
}
