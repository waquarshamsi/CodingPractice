/**
 * Author:  Waquar Shamsi
 * Date:    July 10, 2024
 * Link:    https://www.geeksforgeeks.org/problems/subset-sums2234/1
 * Performance: Not Available
 * Comments: Think things through on a page first.
 */

//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

public class subsetSums {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int index, int sum) {
        if (index >= arr.size()) {
            return new ArrayList<Integer>(Arrays.asList(sum));
        }    
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(subsetSums(arr, index + 1, sum));
        result.addAll(subsetSums(arr, index + 1, sum + arr.get(index)));
        return result;
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        return subsetSums(arr, 0, 0);
    }
}
