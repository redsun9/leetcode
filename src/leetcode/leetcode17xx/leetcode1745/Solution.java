package leetcode.leetcode17xx.leetcode1745;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        if (n < 3) return false;
        if (n == 3) return true;

        int[][] pals = {manacherOdd(s), manacherEven(s),};

        for (int i = 0; i < n; i++) {
            if (!isPal(0, i, pals)) continue;
            for (int j = i + 2; j < n; j++) {
                if (isPal(i + 1, j - 1, pals) && isPal(j, n - 1, pals)) return true;
            }
        }
        return false;
    }

    private static boolean isPal(int l, int r, int[][] pals) {
        int parity = (l ^ r) & 1;
        int mid = (l + r + 1) / 2;
        return pals[parity][mid] >= r - mid + 1;
    }


    //number of palindromes of odd length with center at i
    private static int[] manacherOdd(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(ans[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        return ans;
    }

    //number of palindromes of even length with center at i
    private static int[] manacherEven(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(ans[l + r - i + 1], r - i + 1);
            while (i - k - 1 >= 0 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
        return ans;
    }
}
