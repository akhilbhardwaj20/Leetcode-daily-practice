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

// Optimal solution 
// TC - O(R log C) 
// SC - O(1)
// * Median for an Odd Numbered matrix = 1+(rows)*columns/2 th smallest number
//          * so to find out median we need to search all elements which are either 
//          * smaller or equal till 1+r*c/2th position
//          * 
//          * */
         public class Solution {
    public int findMedian(int[][] A) {
        
        /**
         * One simple solution would be to search in overall matrix after flattening it
         * 2D arr -> 1D arr -> total element n*m =>find n*m/2 th element
         * but that's definitely not in place
         * and also it's time complexity would be O(n*m) <==to flatten the 2D array we need
         * to traverse all the elements
         * 
         * Optimized technique
         * 
         * Median for an Odd Numbered matrix = 1+(rows)*columns/2 th smallest number
         * so to find out median we need to search all elements which are either 
         * smaller or equal till 1+r*c/2th position
         * 
         * */
         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
         
         for(int i=0;i<A.length;i++){
             max = Math.max(max,A[i][A[i].length-1]);
             min = Math.min(min,A[i][0]);
         }
         
         
         int median = (1+A.length*A[0].length)/2;
         while(min<max){
             int total_count = 0;//keep count of all the elements smaller or equals till mid
              int mid = min + (max -min)/2;
              for(int i=0;i<A.length;i++){
              int index = Arrays.binarySearch(A[i],mid);
              /**
               * Arrays.binarySearch gives -(insertionPoint)-1 for any search
               * So incase element is not present 
               * {1,2,3,4,5,6,7} ==>search for 0 will return -1
               * search for 8 will return -7-1 i.e 8
               * else for any other element present, index of the same will be returned
               * */
               if(index<0){//element not present
                   index = Math.abs(index)-1;
               }else{
                   //but hey!! there could be more than one occurance of same number
                   while(index<A[i].length && A[i][index]==mid){
                       index++;//going till last element
                   }
               }
               total_count += index;//add element seen which are lesser or equal to mid
              }
             //now how shoudl us divide our serach space 
         //first intutuion comes that if total_count==mid yey!! we found our median
         //but here is the catch! mid might not be present in the array
         //so we can not direclty do an equal comparison
         //we need to miniise our search space till 1 element i.e min==max
         if(total_count<median){
             min = mid + 1; //Here we are ingnoring first half of matrix
         }else{
             max = mid; //here we are keeping the second half + mid 
         }
             
         }
         return min;//or return max, it's the same thing
    }
}
