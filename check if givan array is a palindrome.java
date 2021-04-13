// TC - O(n)
// SC - O(1)
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                  int res = 0;
                  int i =0, j = 0;
                  while(i < j) {
                      if(a[i] < a[j]) {
                          i++;
                          a[i] += a[i-1];
                          res++;
                      } else if(a[i] == a[j]) {
                          i++;
                          j--;
                      } else {
                          j--;
                          a[j] += a[j-1];
                          res++;
                      }
                  }
                  return res;
           }
}
