package leetcode.leetcode35xx.leetcode3518;

public class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;
        int countOdd = 0, indexOdd = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                countOdd++;
                indexOdd = i;
            }
        }
        if (n % 2 != countOdd) return "";

        char[] ans = new char[n];
        if (countOdd == 1) ans[n / 2] = (char) ('a' + indexOdd);
        for (int i = 0; i < 26; i++) count[i] /= 2;
        k--;

        for (int l = 0, r = n - 1; l < r; l++, r--) {
            boolean found = false;
            for (int c = 0; !found && c < 26; c++) {
                if (count[c] == 0) continue;
                count[c]--;
                int comb = comb(count, k);
                if (comb == -1) {
                    ans[l] = (char) ('a' + c);
                    ans[r] = (char) ('a' + c);
                    found = true;
                } else {
                    count[c]++;
                    k -= comb;
                }
            }
            if (!found) return "";
        }
        if (k != 0) return "";
        return new String(ans);
    }

    private static int comb(int[] count, int k) {
        if (k == 0) return -1;
        long ans = 1;
        for (int c = 0, a = 1; c < 26; c++) {
            for (int b = 1; b <= count[c]; b++, a++) {
                ans = ans * a / b;
                if (ans > k) return -1;
            }
        }
        return (int) ans;
    }
}
