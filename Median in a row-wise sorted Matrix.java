// Problem link -------->     https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1#
// TC - O(n*m)
// SC - O(n)
class Solution {
    int median(int matrix[][], int r, int c) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                list.add(matrix[i][j]);
            }
        }
        int median = 0;
        Collections.sort(list);
        int s = list.size();
        
        for(int i = 0; i < s; i++) {
            if(s%2==0) {
                // for even elements median if the avg of two middle elements
                median = (list.get(s/2) + list.get(s/2 + 1))/2; 
            } else {
                median = list.get(s/2);
            }
        }
        return median;
    }
}
