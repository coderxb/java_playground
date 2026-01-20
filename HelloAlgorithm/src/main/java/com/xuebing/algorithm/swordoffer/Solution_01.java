package com.xuebing.algorithm.swordoffer;

import com.xuebing.algorithm.utils.ArrayUtil;

/**
 * Created by xuebing on 2017/11/29.
 */
public class Solution_01 {

    public boolean find(int target, int [][] array) {
        if (array == null || array.length <= 0)
            throw new NullPointerException("Give array data is empty!");

        for (int i = 0; i < array.length; i++) {
            int[] dataSet = array[i];
            int low = 0;
            int high = dataSet.length - 1;
            while (high >= low) {
                int mid = (high + low) / 2;
                if (target > dataSet[mid]) {
                    low = mid + 1;
                } else if (target < dataSet[mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
