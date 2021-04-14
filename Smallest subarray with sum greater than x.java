// problem link ----->     https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1#

class Solution {

// Tc - O(n) 
// SC - O(1)
    public static long sb(long a[], long n, long x) {
        int len = Integer.MAX_VALUE;
        long windowSum = 0;
       int start = 0;
       for(int end = 0; end < n; end++){
            windowSum += a[end];
           while(windowSum > x && start <= end) {
               len = Math.min(len, end-start+1);
               windowSum -= a[start];
               start++;
           }
    }
    return len;
}
}
