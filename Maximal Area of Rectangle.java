// Problem link ----->    https://practice.geeksforgeeks.org/problems/max-rectangle/1# 
// Prerequisite ----->   Largest rectangular area in Histogram Leetcode #84 ---->    https://leetcode.com/problems/largest-rectangle-in-histogram/)
// TC- O(N)
// SC- O(N)
class Solution {
    public int maxArea(int M[][], int m, int n) {
        if(M.length == 0){
            return 0;
        }
        int []height = new int[M[0].length];
        int max = 0;
        
        for(int i =0; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                if(M[i][j] == 0){
                    height[j] = 0; // since we are traversing the column.
                } else {
                    height[j] +=1;  // otherwise increment the height by 1 if we see 1
                }
            }
            max = Math.max(max, getMaxArea(height));
        }
        return max;
    }
    
    public int getMaxArea(int h[]){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i =1; i<h.length; i++){
            int curr = h[i];
            if(stack.isEmpty() || curr > h[stack.peek()]){
                stack.add(i);
            } else {
                while(!stack.isEmpty() && curr < h[stack.peek()]){
                    int temp = h[stack.pop()];
                    if(stack.isEmpty()){
                        max = Math.max(max, temp * i);
                    } else {
                        max = Math.max(max, temp*(i - stack.peek() - 1));
                    }
                }
                stack.add(i);
            }
        }
        
    //if we have like lengths = 5,6,7,8,9,etc. we need to update the max each time
        if(!stack.isEmpty()){
            int i = h.length;
            while(!stack.isEmpty()){
                    //pop out the elements from stack
                    int temp = h[stack.pop()];
                    if(stack.isEmpty()){
                        max = Math.max(max, temp*i);  //eg => if we are at index 1 and the 
                        //last popped element is index 0 , so we multiply our current index 
                        //with the height of previous element 
                    } else {
                        max = Math.max(max, temp*(i-stack.peek() - 1));
                    }
            }
        } 
        return max;
    }
}
