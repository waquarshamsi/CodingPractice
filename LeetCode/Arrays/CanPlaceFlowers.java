/**
 * Author:  Waquar Shamsi
 * Date:    March 24, 2024
 * Link:    https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=0ms(Beats 100% of Java Submissions), Memory=42.12MB (Beats 70.83% of Java Submissions)
 * Comments: Using java streams to find the largest element in array takes more time than simple for loop iteration.
 * Approach:   if 3 consecutive 0s, then decrease n by 1.
 *              and again start counting from the 3rd 0 as the first 0.
 *              if n==0; break, solution reached return true;
 *              Edge Cases:
 *                  1. If string starts with double 0s or ends with double 0s,
 *                  first or last position should be 1 greedily.
 *              Edge Cases i missed to figure out: when n=0, when arr.length=1 or 2.
 */
class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroCounter = 0;
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            if(n <= 1) {
                return true;
            } else {
                return false;
            }
        }
        if (flowerbed.length >=2 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (flowerbed.length - 3 >=0 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            //this handles the case when initial string was 000, -> 100 -> would be made 101
            // hence taking -3 in previous condition.
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }
        for (int flower : flowerbed) {
            if (flower == 0) {
                zeroCounter++;
            } else {
                zeroCounter = 0;
            }
            if (zeroCounter == 3) {
                n--;
                zeroCounter = 1;
            }
        }
        if (n <= 0) {
            return true;
        } else {
            return false;
        }
    }
}