class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = -1, n = seats.length, maxDist = 0;
        for(int i=0; i < seats.length; i++) {
            if(seats[i] == 1) {
                if(l == -1) 
                    maxDist = i;
                 else 
                    maxDist = Math.max(maxDist, (i-l)/2); // if there are 2 people 
                    l = i;
                
            }
        }
        // last case: if last seat is empty => dist = n-1-l
        if(seats[n-1] == 0) {
            maxDist = Math.max(maxDist, n-1-l);
        }
        return maxDist;
    }
}
