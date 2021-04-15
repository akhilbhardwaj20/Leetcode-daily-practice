//problem link -------->     https://leetcode.com/problems/search-a-2d-matrix/submissions/
//  TC - O(log2(NxM))
// SC - O(1) since we are using imaginary index to find the corresponding row and column
public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n * m) -1;
        while(low <= high) {
            int mid = (low + (high - low) / 2);
            if(matrix[mid/m][mid%m] == target) {
                return true;
            } else if(matrix[mid/m][mid%m] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
