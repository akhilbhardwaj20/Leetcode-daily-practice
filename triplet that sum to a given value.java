Problem link ------>     https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1#
// TC - O(n2)
// SC - O(1)
public static boolean find3Numbers(int A[], int n, int X) { 
   
       Arrays.sort(A);
       for(int i =0; i < n; i++) {
           int left = i+1;
           int right = n-1;
           while(left < right)
           if(A[i] + A[left] + A[right] < X) {
               left++;
           } else if(A[i] + A[left] + A[right] == X) {
               return true;
           } else {
               right--;
           }
          
       }
            return false;
    }
