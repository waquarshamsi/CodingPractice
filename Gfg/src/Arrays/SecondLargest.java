/**
 * Author:  Waquar Shamsi
 * Date:    November 15, 2024
 * Link:    https://www.geeksforgeeks.org/problems/second-largest3735/1
 * Performance:
 * Comments:
 * Difficulty: Easy
 */

package Arrays;
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SecondLargest {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            SecondLargestSolution ob = new SecondLargestSolution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class SecondLargestSolution {
    public int getSecondLargest(int[] arr) {
        int largest = arr[0];
        Integer secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        if (Integer.MIN_VALUE != secondLargest) {
            return secondLargest;
        }
        return -1;
    }
}