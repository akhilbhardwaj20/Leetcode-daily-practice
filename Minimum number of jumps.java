// problem link ------>   https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#

// recursion --> tc= O(n2) sc- O(1) since we are not considering stack space
class Solution{
    static int minJumps(int[] arr){
        int n = arr.length;
        return decideJump(arr, n, 0);    
    }
    
    private static int decideJump(int[] nums, int n, int currPos) {
        if(currPos >= n-1) {   // already at the end of the array
            return 0;    
        }
        int minJump = Integer.MAX_VALUE;
        int maxSteps = nums[currPos];
        while(maxSteps > 0) {
            minJump = Math.min(minJump+1, decideJump(nums,n,currPos + maxSteps));
            maxSteps -= 1;
        }
        return minJump;   
    }   
}

// greedy approach 
// tc - O(n) since we only used a single traversal
// sc - O(1) since we have not used any extra space

class Solution{
    static int minJumps(int[] arr){
        int max_reach = arr[0], steps_left = arr[0];
        int jumps = 1;
    
        if(arr.length <= 1) {
            return 0;
        }
        if(arr[0] == 0) {
                return -1;
            }
        
       
        for(int i = 1; i < arr.length; i++) {
            if(i == arr.length - 1) {
            return jumps;
        }
        
            max_reach = Math.max(max_reach, i + arr[i]);
            steps_left -= 1;
            if(steps_left == 0) {
                jumps += 1;
                
                if(i - max_reach >= 0) {
                return -1;
            }
              steps_left = max_reach - i;
          }
            
        }
        return -1;
    }
}
