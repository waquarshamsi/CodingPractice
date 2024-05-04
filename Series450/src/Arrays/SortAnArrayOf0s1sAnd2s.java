/**
 * Author:  Waquar Shamsi
 * Date:    May 04, 2024
 * Link:    https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 * Performance:
 * Comments:
 */

package Arrays;

import java.io.*;
import java.util.*;

class Solution
{
    public static void sort012(int a[], int n)
    {
        int countZeros = 0;
        int countOnes = 0;
        int countTwos = 0;
        for (int element : a) {
            if (element == 0) {
                countZeros++;
            } else if (element == 1) {
                countOnes++;
            } else {
                countTwos++;
            }
        }
        int index = 0;
        for (int iter = 0; iter < countZeros; iter++) {
            a[index++] = 0;
        }
        for (int iter = 0; iter < countOnes; iter++) {
            a[index++] = 1;
        }
        for (int iter = 0; iter < countTwos; iter++) {
            a[index++] = 2;
        }
    }
}

//{ Driver Code Starts.

public class SortAnArrayOf0s1sAnd2s {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends