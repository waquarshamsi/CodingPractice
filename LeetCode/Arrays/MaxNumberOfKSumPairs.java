/**
 * Author:  Waquar Shamsi
 * Date:    March 30, 2024
 * Link:    https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=3ms(Beats 26.80% of Java Submissions), Memory=45.88MB (Beats 73.24% of Java Submissions)
 * Comments:
 */
class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while(i < j) {
            if(nums[i] + nums[j] == k) {
                count++;
                i++; j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}