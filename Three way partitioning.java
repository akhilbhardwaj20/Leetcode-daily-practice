class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
  // Brute force - Just sort the array
  // tc - O(nlogn) , SC - O(n) as we are using sorting space
  //optimisation - using dutch national flag algo using two pointers
  // TC - O(n)
  // SC - O(1) as we are not using any extra space
    public void threeWayPartition(int array[], int a, int b)
    {
        int n = array.length;
        int start = 0, end = n-1;
        for(int i = 0; i <= end;) {
            if(array[i] < a) {
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
                start++; 
                i++;
            } else if(array[i] > a) {
                int temp = array[end];
                array[end] = array[i];
                array[i] = temp;
                end--; 
                
            } else {
                i++;
            }
        }
    }
}
