/**
 * Author:  Waquar Shamsi
 * Date:    March 23, 2024
 * Link:    https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=0ms(Beats 100% of Java Submissions), Memory=41.33MB (Beats 90.47% of Java Submissions)
 * Comments: Number of conditional checks can be reduced to optimize further, by replacing two conditions in if block
 * to one, by computing the min of the two lengths and iterating the loop for min times only.
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int iter_1 = 0, iter_2 = 0;
        StringBuilder mergedString = new StringBuilder();
        for ( ;iter_1 < word1.length() && iter_2 < word2.length(); iter_1++, iter_2++) {
            mergedString.append(word1.charAt(iter_1));
            mergedString.append(word2.charAt(iter_2));
        }
        if (iter_1 < word1.length()) {
            mergedString.append(word1.substring(iter_1));
        }
        if (iter_2 < word2.length()) {
            mergedString.append(word2.substring(iter_2));
        }
        return mergedString.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        Object response = mergeStringsAlternately.mergeAlternately("abc", "a");
        System.out.println((String)response);
    }
}