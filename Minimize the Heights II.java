// problem link ---> https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1#
// #logical problem
// tc- O(n) , sc - O(1)
class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        for(int i = 1; i < n; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[n-1] - k, arr[i-1] + k);
            if(min < 0) continue;          // this check is necessary since the question doesn't allow any height to be < 0.
            ans = Math.min(ans, max-min);
            
        }
        
        return ans;
    }
}
