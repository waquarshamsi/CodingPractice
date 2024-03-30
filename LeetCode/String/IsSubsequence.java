/**
 * Author:  Waquar Shamsi
 * Date:    March 30, 2024
 * Link:    https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=1ms(Beats 90.85% of Java Submissions), Memory=40.86MB (Beats 97.59% of Java Submissions)
 * Comments: using charAt to access the string instead of using toCharArray() and iterating as chars, helped improve
 * space performance and also computing the string lenght() once, storing in a variable and using it multiple times
 * helped improve the time perforamnce, so always use int y = x.length(), instead of recomputing it multple times
 * in java.
 */
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int ss = s.length();
        int ts = t.length();
        if (ss == 0) {
            return true;
        }
        for(int j = 0; j < ts; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i==ss) {
                return true;
            }
        }
        return false;
    }
}