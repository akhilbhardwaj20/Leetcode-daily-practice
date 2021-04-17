class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        if(heights.length == 1){
            return heights[0];
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);    // add the first element
        for(int i=1; i<heights.length; i++){
            int curr = heights[i];
            if(curr >= heights[stack.peek()]){
                //if the curr element is greater than or equal to the index at top of stack, 
                //we add that to stack;
                stack.add(i);
            } else {
                while(!stack.isEmpty() && curr < heights[stack.peek()]){
                    //pop out the elements from stack
                    int temp = heights[stack.pop()];
                    if(stack.isEmpty()){
                        max = Math.max(max, temp*i);  //eg => if we are at index 1 and the 
                        //last popped element is index 0 , so we multiply our current index 
                        //with the height of previous element 
                    } else {
                        max = Math.max(max, temp*(i-stack.peek() - 1));
                    }
                }
                stack.add(i);
            }
        }
        //if we have like lengths = 5,6,7,8,9,etc. we need to update the max each time
        if(!stack.isEmpty()){
            int i = heights.length;
            while(!stack.isEmpty()){
                    //pop out the elements from stack
                    int temp = heights[stack.pop()];
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
