package help_requests.necklace_cut;

/*
Giving the necklace consisting of gems of three different types,
split it evenly into two parts by making the least amount of cuts
 */

// O(n^2) - time, O(1) - space
public class Solution3 {
    public static int[] getMinimumCuts(int[] necklace) {
        int n = necklace.length;
        if (n == 0) return new int[0];
        if ((n & 1) != 0) return null;

        int cnt1 = 0, cnt2 = 0;
        for (int gem : necklace) {
            if (gem == 1) cnt1++;
            else if (gem == 2) cnt2++;
        }
        if ((cnt1 & 1) != 0 || (cnt2 & 1) != 0) return null;
        cnt1 >>>= 1;
        cnt2 >>>= 1;

        int[] ans = tryOneOrTwoCut(necklace, cnt1, cnt2, n);
        if (ans != null) return ans;
        return tryThreeCuts(necklace, cnt1, cnt2, n);
    }

    private static int[] tryOneOrTwoCut(int[] necklace, int cnt1, int cnt2, int n) {
        int[] ans = findPiece(necklace, n / 2, 0, n, cnt1, cnt2);
        if (ans == null || ans[0] != 0) return ans;
        return new int[]{ans[1]};
    }

    // cuts a,b,c. cnt[0+a] + cnt[b,c]= cnt, a+c-b = n/2
    private static int[] tryThreeCuts(int[] necklace, int cnt1, int cnt2, int n) {
        for (int cut = 1; cut < n / 2; cut++) {
            if (necklace[cut - 1] == 1) cnt1--;
            else if (necklace[cut - 1] == 2) cnt2--;

            int[] piece = findPiece(necklace, n / 2 - cut, cut + 1, n - 1, cnt1, cnt2);
            if (piece != null) return new int[]{cut, piece[0], piece[1]};
        }
        return null;
    }

    private static int[] findPiece(int[] necklace, int len, int start, int end, int cnt1, int cnt2) {
        if (start >= end || start + len > end || cnt1 < 0 || cnt2 < 0) return null;
        for (int i = start + len - 1; i >= start; i--) {
            if (necklace[i] == 1) cnt1--;
            else if (necklace[i] == 2) cnt2--;
        }
        if (cnt1 == 0 && cnt2 == 0) return new int[]{start, start + len};

        for (int r = start + len, l = start; r < end; r++, l++) {
            if (necklace[r] == 1) cnt1--;
            else if (necklace[r] == 2) cnt2--;

            if (necklace[l] == 1) cnt1++;
            else if (necklace[l] == 2) cnt2++;

            if (cnt1 == 0 && cnt2 == 0) return new int[]{l + 1, r + 1};
        }
        return null;
    }
}
