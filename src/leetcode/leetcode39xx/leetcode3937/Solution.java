package leetcode.leetcode39xx.leetcode3937;

public class Solution {
    public int minOperations(int[] nums, int k) {
        int[] cnt1 = new int[k], cnt2 = new int[k];
        for (int i = 0; i < nums.length; i += 2) cnt1[nums[i] % k]++;
        for (int i = 1; i < nums.length; i += 2) cnt2[nums[i] % k]++;

        int[][] a = getTwoMin(cnt1), b = getTwoMin(cnt2);
        if (a[0][0] != b[0][0]) return a[0][1] + b[0][1];
        else return Math.min(a[0][1] + b[1][1], a[1][1] + b[0][1]);
    }

    private int[][] getTwoMin(int[] cnt) {
        int k = cnt.length;
        int[] diff = new int[k];

        //can be O(k), but I'm lazy
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                diff[j] += cnt[i] * Math.min(Math.abs(i - j), k - Math.abs(i - j));
            }
        }

        int min1 = Integer.MAX_VALUE, minIdx1 = -1, min2 = Integer.MAX_VALUE, minIdx2 = -1;
        for (int i = 0; i < k; i++) {
            if (diff[i] < min2) {
                if (diff[i] < min1) {
                    min2 = min1;
                    minIdx2 = minIdx1;
                    min1 = diff[i];
                    minIdx1 = i;
                } else {
                    min2 = diff[i];
                    minIdx2 = i;
                }
            }
        }
        return new int[][]{{minIdx1, min1}, {minIdx2, min2}};
    }
}
