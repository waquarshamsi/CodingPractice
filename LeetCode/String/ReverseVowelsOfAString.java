/**
 * Author:  Waquar Shamsi
 * Date:    March 24, 2024
 * Link:    https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=3ms(Beats 81.20% of Java Submissions), Memory=44.68MB (Beats 77.66% of Java Submissions)
 * Comments: Using <List>.contains(), took way more time of 11ms than using switch case which took just 3ms.
 *             This java syntax is way cooler - 'if( f<e && w[f] != ('a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U'))'
 * Approach:   Use two pointers i and j from start and end respectively, whenever both point to vowel, swap chars,
 *              else just move the pointer further until a vowel found.
 */
class ReverseVowelsOfAString {
    private boolean isVowel(char character) {
        switch(character) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
    public String reverseVowels(String s) {
        //using two pointer logic to reduce from two passes to one pass O(n) instead of O(2n)
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        char temp;
        while (i < j) {
            if(isVowel(charArray[i]) && isVowel(charArray[j])) {
                temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++; j--;
            } else if (isVowel(charArray[i])) {
                j--;
            } else {
                i++;
            }
        }
        return new String(charArray);
    }
}