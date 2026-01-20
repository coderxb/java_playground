package com.xuebing.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class DemoTest {

    @Test
    public void testDemoExample() {
        int[] nums = new int[]{-4,-1,0,3,10};

        int[] results = sortedSquares_1(nums);
        System.out.println("Result = " + Arrays.toString(results));
    }

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

    private int binarySearch(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int low=0, high=nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
