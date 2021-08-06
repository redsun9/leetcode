package leetcode.leetcode10xx.leetcode1073;

import java.util.Arrays;

public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int maxAnsLength = Math.max(n1, n2) + 3;
        int[] ans = new int[maxAnsLength];
        int i = maxAnsLength - 1, i1 = n1 - 1, i2 = n2 - 1, carry = 0;
        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            if (i1 >= 0) carry += arr1[i1--];
            if (i2 >= 0) carry += arr2[i2--];
            ans[i--] = carry & 1;
            carry = -(carry >> 1);
        }
        while (i < maxAnsLength && ans[i] == 0) i++;
        if (i == maxAnsLength) i--;
        return Arrays.copyOfRange(ans, i, maxAnsLength);
    }
}
