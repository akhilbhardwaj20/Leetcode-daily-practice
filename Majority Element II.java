// Brute force - Count frequency of every element in the array. IF it is > (n/3) then it is the majority el. 
// TC- O(n2) //SC - O(1)
// Second approach - Use HashMap 
// TC - O(n)  SC- O(n)
// Constant extra space soln - Using Moore algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int num1 = -1;
        int num2 = -1;
        int c1 = 0, c2 = 0;
        for(int el : nums) {
            if(el == num1) {
                c1++;
            } else if(el == num2) {
                c2++;
            } else if(c1 == 0) {
                num1 = el;
                c1 = 1;
            } else if(c2 == 0) {
                num2 = el;
                c2 = 1;
            } else {
                c1--;  c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int el : nums) {
            if(el == num1) {
                c1++;
            } else if(el == num2) {
                c2++;
            }
        }
        if(c1 > (n/3)) {
                res.add(num1);
            }
            if(c2 > (n/3)) {
                res.add(num2);
            }
        return res;
    }
}
