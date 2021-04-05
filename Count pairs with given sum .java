//problem link---->    https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#

// tc- O(n^2) sc - O(1)

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// optimised solution using hashmap
//tc -O(n)  sc- O(1)

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(k-arr[i])) {
                count += map.get(k-arr[i]);
            } 
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        }
        return count;
    }
}
