// problem link ---->   
// tc - O(n^2) , sc - O(1) 
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
            } else {
                ans = num;
            }
        }
        return ans;
        
    // tc - O(n) - since we iterated the array only once
    // sc - O(1) 
    //     int ans = 0;
    //     for(int i = 0; i < nums.length; i++) {
    //         for(int j = i + 1; j < nums.length; j++) {
    //             if(nums[i] == nums[j]) {
    //                 ans = nums[i];
    //             }
    //         }
    //     }
    //     return ans;
    // }
    }
}
