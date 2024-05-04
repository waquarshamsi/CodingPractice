/**
 * Author:  Waquar Shamsi
 * Date:    April 02, 2024
 * Link:    https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1220690634/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=9ms(Beats 95.49% of Java Submissions), Memory=44.49MB (Beats 67.71% of Java Submissions)
 * Comments: switch case better than if ( || )
 */
class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int currentVowelCount = 0;
        int iter = 0;
        int stringlength = s.length();
        int maxCountVowel = 0;
        while (iter < k) {
            switch (s.charAt(iter)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    currentVowelCount++;
            }
            iter++;
        }
        maxCountVowel = currentVowelCount;
        while (iter < stringlength) {
            switch (s.charAt(iter)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    currentVowelCount++;
            }
            switch (s.charAt(iter - k)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    currentVowelCount--;
            }
            maxCountVowel = currentVowelCount > maxCountVowel ? currentVowelCount : maxCountVowel;
            iter++;
        }
        return maxCountVowel;
    }
}