// link ---- https://leetcode.com/problems/move-zeroes/  
// tc - O(n)
//sc = O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                snowBallSize++;
            } else if(snowBallSize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = temp;
            }
        }
    }
}
