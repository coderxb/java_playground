package com.xuebing.algorithm.leetcode;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * @website https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author xuebing.li
 */
public class LC_0977 {

    private int[] sortedSquares(int[] nums) {
        int aryLength = nums.length;
        int pivot = aryLength - 1;
        int[] resultNums = new int[aryLength];
        for (int i = 0, j = aryLength - 1; i <= j;) {
            if(nums[i] * nums[i] > nums[j] * nums[j]) {
                resultNums[pivot] = nums[i] * nums[i];
                i++;
            } else {
                resultNums[pivot] = nums[j] * nums[j];
                j--;
            }
            pivot--;
        }
        return resultNums;
    }

    private int[] sortedSquares_1(int[] nums) {
        int[] resultNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resultNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(resultNums);
        return resultNums;
    }

    private int[] sortedSquares_2(int[] nums) {
        int pivot = -1;
        for (int num : nums) {
            if (num < 0) {
                pivot++;
            } else {
                break;
            }
        }

        int index = 0, negativeEndIdx = pivot, positiveStartIdx = pivot + 1;
        int[] resultNums = new int[nums.length];
        while (negativeEndIdx >= 0 || positiveStartIdx < nums.length) {
            if(negativeEndIdx < 0) {
                resultNums[index] = nums[positiveStartIdx] * nums[positiveStartIdx];
                positiveStartIdx++;
            } else if(positiveStartIdx == nums.length) {
                resultNums[index] = nums[negativeEndIdx] * nums[negativeEndIdx];
                negativeEndIdx--;
            } else {
                if(nums[negativeEndIdx] * nums[negativeEndIdx] < nums[positiveStartIdx] * nums[positiveStartIdx]) {
                    resultNums[index] = nums[negativeEndIdx] * nums[negativeEndIdx];
                    negativeEndIdx--;
                } else {
                    resultNums[index] = nums[positiveStartIdx] * nums[positiveStartIdx];
                    positiveStartIdx++;
                }
            }
            index++;
        }
        return resultNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};

        LC_0977 lc0977 = new LC_0977();
        int[] results = lc0977.sortedSquares_2(nums);
        System.out.println("Result = " + Arrays.toString(results));
    }

}
