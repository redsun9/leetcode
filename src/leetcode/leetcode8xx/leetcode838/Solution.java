package leetcode.leetcode8xx.leetcode838;

import java.util.Arrays;

public class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = dominoes.length();
        int prevPos = -1;
        boolean prevRight = false;
        for (int i = 0; i <= n; i++) {
            if (i < n && arr[i] == 'L') {
                if (prevRight) {
                    //RL
                    int len = (i - prevPos - 1) / 2;
                    Arrays.fill(arr, prevPos + 1, prevPos + 1 + len, 'R');
                    Arrays.fill(arr, i - len, i, 'L');

                } else Arrays.fill(arr, prevPos + 1, i, 'L');
                prevPos = i;
                prevRight = false;
            } else if (i == n || arr[i] == 'R') {
                if (prevRight) {
                    Arrays.fill(arr, prevPos + 1, i, 'R');
                }
                prevPos = i;
                prevRight = true;
            }
        }
        return new String(arr);
    }
}
