package com.xuebing.algorithm.leetcode.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC - 两数之和
 *
 * 网址: https://leetcode-cn.com/leetbook/read/tencent/xxqfy5/
 */
public class LC001 {

    public int[] twoSumForHash(int[] nums, int target) {
        if(nums.length <= 0) {
            return new int[] {0,0};
        }
        Map<Integer, Integer> tmpMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(tmpMap.containsKey(target - nums[i])) {
                return new int[]{tmpMap.get(target - nums[i]), i};
            }
            tmpMap.put(nums[i], i);
        }
        return new int[] {0,0};
    }

    public int[] twoSumForLoop(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        // int[] nums = new int[]{3,2,4};
        int target = 9;
        LC001 lc001 = new LC001();
        int[] result = lc001.twoSumForHash(nums, target);

        System.out.println("Result = " + Arrays.toString(result));
    }

}
