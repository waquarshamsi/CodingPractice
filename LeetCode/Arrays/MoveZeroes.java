/**
 * Author:  Waquar Shamsi
 * Date:    March 30, 2024
 * Link:    https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=3ms(Beats 26.80% of Java Submissions), Memory=45.88MB (Beats 73.24% of Java Submissions)
 * Comments: Removing swap operations, by using two iterations, helped improve the performance by 1ms but with a prior
 * check when input array is of size 1.
 */
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        short iter1 = 0, iter2 = 0;
        int temp;
        while (iter2 < nums.length) {
            if (iter1 != iter2) {
                temp = nums[iter1];
                nums[iter1] = nums[iter2];
                nums[iter2] = temp;
            }
            if (nums[iter1] != 0) {
                iter1++;
            }
            iter2++;
        }
    }
}