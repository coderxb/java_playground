package com.xuebing.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @Description https://leetcode.cn/problems/3sum/
 */
public class LC_0015 {

    /**
     * 暴力解法，三重循环
     * @param nums 数组
     * @return List<List<Integer>>
     */
    public List<List<Integer>> solution_01(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ret;
        }
        //数组排序
        Arrays.sort(nums);
        int targetNum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (targetNum == nums[i] + nums[j] + nums[k]) {
                        List<Integer> subItem = new ArrayList<Integer>();
                        subItem.add(nums[i]);
                        subItem.add(nums[j]);
                        subItem.add(nums[k]);
                        if (!ret.contains(subItem)) {
                            ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> solution_02(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ret;
        }
        //数组排序
        Arrays.sort(nums);
        int targetNum = 0;

        int low, quick;
        for (int i = 0; i < nums.length; i++) {
            // 大于零直接返回
            if (nums[i] > targetNum) {
                return ret;
            }
            // 去重
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            low = i + 1;
            quick = nums.length - 1;
            while (low < quick) {
                int sum = nums[i] + nums[low] + nums[quick];
                if (sum > targetNum) {
                    quick--;
                } else if (sum < targetNum) {
                    low++;
                } else {
                    ret.add(Arrays.asList(nums[i],nums[low],nums[quick]));
                    while (low < quick && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low< quick && nums[quick] == nums[quick-1]) {
                        quick--;
                    }
                    low++;
                    quick--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC_0015 lc0015 = new LC_0015();

        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = lc0015.solution_02(nums);
        System.out.println("Result = " + result.toString());
    }

}
