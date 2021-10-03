package leetcode.leetcode20xx.leetcode2023;

public class Solution {
    public int numOfPairs(String[] nums, String target) {
        int n = target.length();
        int[] pref = new int[n + 1]; // number of t[0,i)
        int[] suff = new int[n + 1]; // number of t[i,n)


        int i, j;
        for (String num : nums) {
            int m = num.length();
            if (m > n) continue;

            i = 0;
            while (i < m && num.charAt(i) == target.charAt(i)) i++;
            if (i == m) pref[m]++;

            i = n - 1;
            j = m - 1;
            while (j >= 0 && num.charAt(j) == target.charAt(i--)) j--;
            if (j == -1) suff[n - m]++;
        }

        int ans = 0;
        for (i = 0; i <= n; i++) ans += pref[i] * suff[i];
        if ((n & 1) == 0) {
            //check if [0,n/2)==[n/2,n)
            i = 0;
            j = n / 2;
            while (j < n && target.charAt(i++) == target.charAt(j)) j++;
            if (j == n) ans -= suff[n / 2];
        }
        return ans;
    }
}
