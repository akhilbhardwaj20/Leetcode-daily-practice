class Solution
{   
    // TC - O(n)
    // SC - O(n) as the set needs extra space 
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   Set<Integer> set = new HashSet<>();
	   int res = 0;
	   for(int i = 0; i < N; i++) {
	       set.add(arr[i]);
	   }
	   for(int i = 0; i < N; i++) {
	       if(!set.contains(arr[i] - 1)) {
	           int j = arr[i] + 1;
	           while(set.contains(j)) {
	               j++;
	           }
	           res = Math.max(res, j - arr[i]);
	       }
	   }
	   return res;
	}
}
