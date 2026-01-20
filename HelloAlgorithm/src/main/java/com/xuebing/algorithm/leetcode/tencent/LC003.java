package com.xuebing.algorithm.leetcode.tencent;

import java.util.Arrays;
import java.util.Objects;

/**
 * 最长回文子串
 *
 * 网址: https://leetcode-cn.com/leetbook/read/tencent/xxk4s2/
 */
public class LC003 {

    public String longestPalindrome(String str) {
        if(Objects.isNull(str)) {
            throw new RuntimeException("不可空值");
        }
        if(str.length() < 2) {
            return str;
        }
        int begin = 0;
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if(j - i < maxLength) {
                    continue;
                }
                if(isPalindrome(str, i, j)) {
                    if(maxLength < j - i + 1) {
                        begin = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }
        return str.substring(begin, begin + maxLength);
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if(str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC003 lc003 = new LC003();
        //String str = "";
        String str = "babad";
        String result = lc003.longestPalindrome(str);
        System.out.println("Result = " + result);
    }
}
