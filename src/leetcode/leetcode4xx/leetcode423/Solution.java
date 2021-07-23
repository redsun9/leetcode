package leetcode.leetcode4xx.leetcode423;

public class Solution {
    public String originalDigits(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;

        int[] ans = new int[10];
        ans[8] = count[6];
        count[7] -= count[6];
        count[8] -= count[6];
        count[19] -= count[6];

        ans[3] = count[7];
        count[19] -= count[7];

        ans[2] = count[19];
        count[14] -= count[19];

        ans[4] = count[20];
        count[5] -= count[20];
        count[14] -= count[20];

        ans[6] = count[23];
        count[8] -= count[23];
        count[18] -= count[23];

        ans[0] = count[25];
        count[14] -= count[25];

        ans[5] = count[5];
        count[8] -= count[5];

        ans[9] = count[8];
        ans[1] = count[14];
        ans[7] = count[18];

        int ansLength = 0;
        for (int i = 0; i < 10; i++) ansLength += ans[i];

        char[] arr = new char[ansLength];
        int ansPos = 0;
        char c = '0';
        for (int i = 0; i < 10; i++, c++) {
            int k = ans[i];
            for (int j = 0; j < k; j++) arr[ansPos++] = c;
        }
        return new String(arr);
    }
}
