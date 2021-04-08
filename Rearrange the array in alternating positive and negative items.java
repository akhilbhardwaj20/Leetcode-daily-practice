/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
//rearrange the array in alternative positive and negative positions 
// Tc- O(n)
// SC - O(1)
class Ideone
{
	// function to rotate right the array 
	private int rightRotate(int[] arr, int from, int to) {
		int temp = arr[to];
		for(int i = to; i > from; i--) {
			arr[i] = arr[i-1];
			arr[from] = temp;
		}
	}
	void rearrange(int[] arr, int n) {
		int wrongIndex = -1;
		for(int i = 0; i < n; i++) {
			if(wrongIndex >= 0) {
				if(arr[wrongIndex] < 0 && arr[i] >= 0 || arr[wrongIndex] >= 0 && arr[i] < 0) {
					rightRotate(arr, wrongIndex, i);
					if(i-wrongIndex >= 2)
					     wrongIndex += 2;
					else
					    wrongIndex = -1;
					       
				}
			} if(wrongIndex == -1) {
				if(arr[i] < 0 && arr[i]%2 == 1 || arr[i] >= 0 && arr[i]%2 == 0) {
					wrongIndex = i;
				}
			}
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[] = {-5,-2,5,2,4,7,1,8,0,-8};
		int n = arr.length;
		rearrange(arr,n);
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
