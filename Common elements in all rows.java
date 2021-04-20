// TC - O(m * n) and we are doing only one traversal of the matrix.
 // SC -O(1) as we are not using any extra space
import java.io.*;
import java.util.*;
class myClass {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int[][] mat = new int[m][n];
		    for(int i = 0; i < m; i++) {
		        for(int j = 0; j < n; j++) {
		            mat[i][j] = sc.nextInt();
		        }
		    }
		    Map<Integer, Integer> map = new HashMap<>();
		    for(int j = 0; j < n; j++) {
		        map.put(mat[0][j],1);
		    }
		    for(int i = 1; i < m; i++) {
		        for(int j = 0; j < n; j++) {
		            if(map.get(mat[i][j]) != null && map.get(mat[i][j]) == i) {
		                map.put(mat[i][j],i+1);
		                
		                if(i==m-1)
		                System.out.println(mat[i][j] + " ");
		            }
		        }
		    }
		}
	}
}
