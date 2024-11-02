/**
 * Author:  Waquar Shamsi
 * Date:    November 01, 2024
 * Link:    https://www.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
 * Performance: My Solution O(n^2); Optimal Solution O(n)
 * Comments: I used bubble sort; instead a smart solution is available on gfg
 * Difficulty: Easy
 */

package Arrays;
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class ConvertArrayZigZagIntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

public class ConvertArrayZigZag {

    public static boolean isZigzag(int n, int[] arr) {
        int f = 1;

        for (int i = 1; i < n; i++) {
            if (f == 1) {
                if (arr[i - 1] > arr[i]) return false;
            } else {
                if (arr[i - 1] < arr[i]) return false;
            }
            f ^= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = ConvertArrayZigZagIntArray.input(br, n);

            ConvertArrayZigZagSolution obj = new ConvertArrayZigZagSolution();
            obj.zigZag(n, arr);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == i % 2) {
                    flag = false;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("0");
            } else {

                boolean check = isZigzag(n, arr);
                if (check) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class ConvertArrayZigZagSolution {
    public static void zigZag(int n, int[] arr) {
        // code here
        // bubble sort - O(n^2)
        // sorting O(nlogn) + arranging O(n)
        //- issue is order not to be changed if already correct sequence
        //- hence choosing bubble sort? or n+nlogn+n - by validating first?
        int temp = -1;
        boolean swapped = false;
        for (int i=0; i<n; i++) {
            swapped = false;
            for(int j=i; j<n-1; j++) {
                if (j%2==0) {
                    if (arr[j] > arr[j+1]) {
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        swapped = true;
                    }
                } else {
                    if (arr[j] < arr[j+1]) {
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
