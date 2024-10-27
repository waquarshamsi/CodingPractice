package Strings;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // brute force n^2,
        // sorting nlogn + n
        // hashmap n
        Map<String, Integer> frequencyMap = new HashMap<>();
        int secondMost = 0;
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        int max = Collections.max(frequencyMap.values());
        for (String str : arr) {
            if (frequencyMap.get(str) > secondMost && frequencyMap.get(str) < max) {
                secondMost = frequencyMap.get(str);
            }
        }

        for (String str : arr) {
            if (frequencyMap.get(str) == secondMost) {
                return str;
            }
        }
        return "";
    }
}

public class SecondMostRepeatedStringInASequence {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
