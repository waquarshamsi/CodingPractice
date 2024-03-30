/**
 * Author:  Waquar Shamsi
 * Date:    March 30, 2024
 * Link:    https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=4ms(Beats 88.74% of Java Submissions), Memory=56.56MB (Beats 98.25% of Java Submissions)
 * Comments: Using ternary operator to calcualte max of two ints gave performance boost over using Math.max(), min().
 */
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxLength = 0;
        int tempCalculatedVal = 0;
        while (i < j) {
            tempCalculatedVal = height[i] < height[j] ? height[i] * (j-i) :  height[j] * (j-i);
            maxLength = maxLength > tempCalculatedVal ? maxLength : tempCalculatedVal;
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxLength;
    }
}