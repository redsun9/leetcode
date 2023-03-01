package help_requests.necklace_cut;

public class Solution32 {
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

        int[] ans = null;

        for (int cut = 1; cut <= n / 2; cut++) {
            if (necklace[cut - 1] == 1) cnt1--;
            else if (necklace[cut - 1] == 2) cnt2--;

            if (cnt1 < 0 || cnt2 < 0) break;

            int tmpCnt1 = cnt1;
            int tmpCnt2 = cnt2;

            for (int i = cut + n / 2 - cut - 1; i >= cut; i--) {
                if (necklace[i] == 1) tmpCnt1--;
                else if (necklace[i] == 2) tmpCnt2--;
            }
            if (tmpCnt1 == 0 && tmpCnt2 == 0) ans = getMinimum(ans, cut, cut, n / 2, n);

            for (int r = cut + n / 2 - cut, l = cut; r < n; r++, l++) {
                if (necklace[r] == 1) tmpCnt1--;
                else if (necklace[r] == 2) tmpCnt2--;

                if (necklace[l] == 1) tmpCnt1++;
                else if (necklace[l] == 2) tmpCnt2++;
                if (tmpCnt1 == 0 && tmpCnt2 == 0) ans = getMinimum(ans, cut, l + 1, r + 1, n);
            }

        }
        return ans;
    }

    private static int[] getMinimum(int[] prev, int a, int b, int c, int n) {
        int cnt = a == b || b == c ? 1 : c == n ? 2 : 3;
        if (prev != null && prev.length < cnt) return prev;
        return a == b || b == c ? new int[]{n / 2} : c == n ? new int[]{a, b} : new int[]{a, b, c};
    }
}
