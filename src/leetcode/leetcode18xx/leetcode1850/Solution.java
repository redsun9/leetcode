package leetcode.leetcode18xx.leetcode1850;

public class Solution {
    private static void nextPermutation(char[] nums) {
        int n = nums.length;
        int k = n - 2;
        for (; k >= 0; k--) if (nums[k] < nums[k + 1]) break;
        if (k < 0) {
            reverse(nums, 0, n - 1);
        } else {
            int l = n - 1;
            for (; l > k + 1; l--) if (nums[k] < nums[l]) break;
            swap(nums, k, l);
            reverse(nums, k + 1, n - 1);
        }
    }

    private static void reverse(char[] nums, int from, int to) {
        while (from < to) swap(nums, from++, to--);
    }

    private static void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int getMinSwaps(String num, int k) {
        int n = num.length();
        char[] str = num.toCharArray();
        while (k-- != 0) nextPermutation(str);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) != str[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (num.charAt(i) == str[j]) {
                        ans += j - i;
                        while (j != i) str[j] = str[--j];
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
