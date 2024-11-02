/**
 * Author:  Waquar Shamsi
 * Date:    November 02, 2024
 * Link:    https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1
 * Performance:
 * Comments: I solved it using O(n); why didn't i think through of possible optimizations?
 *             It can be solved using binary search in log(n) time.
 * Difficulty: Easy
 */

package Arrays;
import java.util.*;
import java.io.*;

class SolutionBitonicPoint {
    int findMaximum(int[] arr, int n) {
        int bitonic = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (bitonic < arr[i]) {
                bitonic = arr[i];
            } else {
                break;
            }
        }
        return bitonic;
    }
}

public class BitonicPoint {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new SolutionBitonicPoint().findMaximum(arr, n);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}