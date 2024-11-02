/**
 * Author:  Waquar Shamsi
 * Date:    November 02, 2024
 * Link:    https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 * Performance:
 * Comments: Didn't think through all scenarios properly on a pen paper.
 * Difficulty: Medium
 * Time Taken: 58m
 * Attempts: 11
 */

package Arrays;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IndexesOfSubArraySum {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            IndexesOfSubArraySumSolution ob = new IndexesOfSubArraySumSolution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class IndexesOfSubArraySumSolution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        //any criteria where we can conclude, no solution possible and stop early?
        //sliding window
        int startIndex=0;
        int endIndex=0;
        int sum=0;
        while (endIndex<arr.length) {
            sum += arr[endIndex];
            if(sum == target) {
                return new ArrayList<>(
                        Arrays.asList(Integer.valueOf(startIndex+1), Integer.valueOf(endIndex+1)));
            } else if (sum > target) {
                if (startIndex == endIndex) {
                    sum -= arr[startIndex];
                    startIndex++;
                    endIndex = startIndex;
                } else {
                    sum = sum - arr[startIndex] - arr[endIndex];
                    startIndex++;
                }
            } else {
                endIndex++;
            }
        }
        return new ArrayList<>(Collections.singletonList(-1));
    }
}
