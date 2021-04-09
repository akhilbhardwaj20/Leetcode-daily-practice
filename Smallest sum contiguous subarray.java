public class Main
{
  // TC - O(n)
  // SC- O(n)
    private static int minSumSubarray(int[] arr, int n) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            sum = Math.min(arr[i], arr[i] + sum);
            ans = Math.min(ans,sum);
        }
        return ans;
    }
	public static void main(String[] args) {
	    
		int arr[] = {-4 ,3, -1, -6, 8};
		int n = arr.length;
		System.out.println(minSumSubarray(arr,n));
		
	}
}
