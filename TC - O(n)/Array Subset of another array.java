// Problem link ------> https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1#
// TC - O(n)
// SC- O(n)
class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        Set<Long>set = new HashSet<>();
        for(long num1 : a1) {
            set.add(num1);
        }
        int size1 = set.size();
        for(long num2 : a2) {
            set.add(num2);
        }
        int size2 = set.size();
        if(size1 == size2) {
            return "Yes";
        } 
        return "No";
    }
}
