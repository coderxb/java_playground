package com.xuebing.algorithm.leetcode;

import org.junit.Test;

import java.util.List;

public class LC_0015Test {

    @Test
    public void test_scene01() {
        LC_0015 lc0015 = new LC_0015();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> ret = lc0015.solution_02(nums);
        System.out.println("Result = " + ret.toString());
    }
}
