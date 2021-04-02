// problem link :   https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1#
// tc - O(n*log k) as we build a max heap
// sc - O(K) since the priority queue ay any time holds at max k elements.
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
         for(int i = 0; i < k; i++) {
             pq.add(arr[i]);
         }
         for(int i = k; i <= r; i++) {
             if(arr[i] < pq.peek()) {
                 pq.poll();
                 pq.add(arr[i]);
             }
         }
             
         
         return pq.peek();
    } 
}
