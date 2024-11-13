/**
 * Author:  Waquar Shamsi
 * Date:    July 03, 2024
 * Link:    https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * Performance: Time=0ms(Beats 100% of Java Submissions), Memory=49.92MB (Beats 81.33% of Java Submissions)
 * Comments: 
 */

class Solution {

    private int singleNonDuplicate(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2; //add comment that using start+end)/2 instead might lead to arithmetic overflow
        if (mid == 0 || mid == nums.length - 1) {
            return nums[mid];
        }
        if ((mid-1 >= 0 && nums[mid] != nums[mid-1]) && (mid+1 <= end && nums[mid] != nums[mid+1])) {
            return nums[mid];
        }
        if (mid % 2 == 0) {
            if (mid - 1 >= 0 && nums[mid] == nums[mid-1]) {
                return singleNonDuplicate(nums, start, mid - 1);
            } else if (mid + 1 <= end) {
                return singleNonDuplicate(nums, mid + 1, end);
            } 
        } else {
            if (mid + 1 <= end && nums[mid] == nums[mid+1]) {
                return singleNonDuplicate(nums, start, mid - 1);
            } else if (mid - 1 >= 0) {
                return singleNonDuplicate(nums, mid + 1, end);
            }
        }
        return nums[mid];
    }

    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }
}