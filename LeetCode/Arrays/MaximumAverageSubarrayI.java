/**
 * Author:  Waquar Shamsi
 * Date:    April 01, 2024
 * Link:    https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=2ms(Beats 100.00% of Java Submissions), Memory=55.46MB (Beats 75.52% of Java Submissions)
 * Comments:
 */
class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum = 0;
        int i = 0;
        while(i < k) {
            sum += nums[i++];
        }
        maxSum = sum;
        while(i < nums.length) {
            sum += (nums[i] - nums[i-k]);
            maxSum = sum > maxSum ? sum : maxSum;
            i++;
        }
        return (double)maxSum/k;
    }
}
