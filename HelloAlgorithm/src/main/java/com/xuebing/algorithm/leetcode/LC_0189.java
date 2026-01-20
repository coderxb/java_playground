package com.xuebing.algorithm.leetcode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * @website https://leetcode-cn.com/problems/rotate-array/
 * @author xuebing.li
 */
public class LC_0189 {

    /**
     * 提示:
     * 1 <= nums.length <= 2 * 104
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     */
    public void rotate(int[] nums, int k) {
        if(k == 0) {
            return;
        }
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < length; i++) {
            newNums[(i + k) % length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        LC_0189 lc_0189 = new LC_0189();

        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 2;

        lc_0189.rotate(nums, k);
        System.out.println("Result = " + Arrays.toString(nums));
    }
}
