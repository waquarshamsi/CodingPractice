/**
 * Author:  Waquar Shamsi
 * Date:    March 26, 2024
 * Link:    https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=6ms(Beats 84.59%% of Java Submissions), Memory=43.04MB (Beats 65.89% of Java Submissions)
 * Comments: Using split("\\s+") took more time than simply checking for blank and strip() every word, if i had used
 *          toCharArray(), performed all operations on that and then used newString(char[]) it might have
 *          given performance boost
 */
class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArray = s.strip().split(" ");
        for (int iter = stringArray.length - 1; iter > 0; iter--) {
            if(!stringArray[iter].isBlank()) {
                stringBuilder.append(stringArray[iter].strip());
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(stringArray[0]);
        return stringBuilder.toString();
    }
}