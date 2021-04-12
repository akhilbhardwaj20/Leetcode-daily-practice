// problem link ---->    https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1#

class Complete{
    
   // TC - O(n)
   // SC - O(1)
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
       int good = 0 , bad = 0;
      
       for(int i=0; i<n; i++) {
           if(arr[i]<=k) {
               good++;
           }
       }
       for(int i=0; i<good; i++) {
           if(arr[i]>k) {
               bad++;
           }
       }
       int i=0, j=good, res=bad;
       while(j<n) {
           if(arr[i]>k) {
               bad--;
           }
           if(arr[j]>k) {
               bad++;
           }
           res = Math.min(res,bad);
           i++;   j++;
       }
       
       return res;
       
    }
}
