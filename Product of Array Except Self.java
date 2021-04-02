class Solution {
  // two pass soln
  // tc - O(n) sc-O(1)
    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = p;
            p = p * nums[i];
        }
        p = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            ans[i] = ans[i] * p;
            p = p * nums[i];
        }
        return ans;
    }
}

// single pass soln
//tc - O(n) since we have used a single for loop
// Arrays.fill takes O(n) 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        int p1 = nums[0]; 
        int p2 = nums[n-1];
        
        for(int i = 1, j = n-2; i < n; i++, j--) {
            ans[i] *= p1;
            ans[j] *= p2;
            p1 *= nums[i];
            p2 *= nums[j];
            
        }
        
        return ans;
    }
}
