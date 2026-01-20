package com.xuebing.algorithm.leetcode.tencent;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 *
 * 网址： https://leetcode-cn.com/leetbook/read/tencent/xx6c46/
 */
public class LC002 {

    @SuppressWarnings("DuplicatedCode")
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int num1Index = 0;
        int num2Index = 0;
        int mergeNumsLength = nums1Length + nums2Length;
        int[] halfMergeNums = new int[mergeNumsLength/2 + 1];
        for (int i = 0; i < halfMergeNums.length; i++) {
            if(num1Index < nums1Length && num2Index < nums2Length){
                if(nums1[num1Index] < nums2[num2Index]) {
                    halfMergeNums[i] = nums1[num1Index];
                    num1Index++;
                } else {
                    halfMergeNums[i] = nums2[num2Index];
                    num2Index++;
                }
            } else {
                if(num1Index < nums1Length) {
                    halfMergeNums[i] = nums1[num1Index];
                    num1Index++;
                }
                if(num2Index < nums2Length) {
                    halfMergeNums[i] = nums2[num2Index];
                    num2Index++;
                }
            }
        }

        if(mergeNumsLength%2 == 1) {
            return halfMergeNums[mergeNumsLength/2];
        } else {
            return (halfMergeNums[mergeNumsLength/2] + halfMergeNums[mergeNumsLength/2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        LC002 lc002 = new LC002();
        //int[] nums2 = new int[]{1};
        //int[] nums1 = new int[]{2};

        int[] nums1 = {2,3,5,6,7,8};
        int[] nums2 = {9,12,24};

        double medianSortedArrays = lc002.findMedianSortedArrays(nums1, nums2);
        System.out.println("Result = " + medianSortedArrays);
    }

}
