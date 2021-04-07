// problem link ----->   https://practice.geeksforgeeks.org/problems/common-elements1132/1#  
// TC - O(n1+n2+n3)
// SC - O(n)
class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> result =  new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;
        while(i<A.length && j<B.length && k<C.length) {
            while(i>0 && i<n1 && A[i-1] == A[i]) {
                i++;
            }
            while(j>0 && j<n2 && B[j-1] == B[j]) {
                j++;
            }
            while(k>0 && k<n3 && C[k-1] == C[k]) {
                k++;
            }
            if(i<n1 && j<n2 && k<n3) {
                 if(A[i] == B[j] && B[j] == C[k]) {
                result.add(A[i]);
                i++;  
                j++;
                k++;
            } else if(A[i] < B[j]) {
                    i++;
                } else if(B[j] < C[k]) {
                    j++;
                } else {
                    k++;
                }
              }
        }
        
        return result;
    }
}
