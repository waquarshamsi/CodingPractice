/**
 * Author:  Waquar Shamsi
 * Date:    Ocotber 27, 2024
 * Link:    https://www.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
 * Performance:
 * Comments: cant have arrays of size long.
 */
package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        Map<Long, Integer> isPresent = new HashMap<>();
        //MEMO: one optimization could be to check if m>n; return "No".
        for (long a2Element : a2) {
            isPresent.put(a2Element,
                    isPresent.get(a2Element) == null ? 1 : isPresent.get(a2Element) + 1);
            //MEMO: should have used isPresent.put(a1[i], isPresent.getOrDefault(a1[i], 0) + 1);
        }
        for (long a1Element : a1) {
            isPresent.put(a1Element,
                    isPresent.get(a1Element) == null ? 0 : isPresent.get(a1Element) - 1);
            //MEMO: no need for this additional loop, instead use containsKey in next loop with -1 operation;
            // hence traversing smaller array a2 twice; no traversal over longer array a1
        }
        boolean isTruePresent = false;
        for (long a2Element : a2) {
            if (isPresent.get(a2Element) > 0) {
                isTruePresent = true;
                //MEMO: should have returned "No" directly here for better code.
            }
        }
        if (isTruePresent) {
            return "No";
        }
        return "Yes";
    }
}


public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int)(n)];
            long a2[] = new long[(int)(m)];


            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }

            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));

            System.out.println("~");
        }
    }
}
