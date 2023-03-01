package help_requests.necklace_cut;

import java.util.HashMap;

/*
Giving the necklace consisting of gems of four different types,
split it evenly into two parts by making the least amount of cuts
 */

// O(n^2) - time, O(N) - space
public class Solution4 {
    public static int[] getMinimumCuts(int[] necklace) {
        int n = necklace.length;
        if (n == 0) return new int[0];
        if ((n & 1) != 0) return null;

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int gem : necklace) {
            if (gem == 1) cnt1++;
            else if (gem == 2) cnt2++;
            else if (gem == 3) cnt3++;
        }
        if ((cnt1 & 1) != 0 || (cnt2 & 1) != 0 || (cnt3 & 1) != 0) return null;
        cnt1 >>>= 1;
        cnt2 >>>= 1;
        cnt3 >>>= 1;

        int[] ans = tryOneOrTwoCut(necklace, cnt1, cnt2, cnt3, n);
        if (ans != null) return ans;
        ans = tryThreeCuts(necklace, cnt1, cnt2, cnt3, n);
        if (ans != null) return ans;
        return tryFourCuts(necklace, cnt1, cnt2, cnt3, n);
    }

    private static int[] tryOneOrTwoCut(int[] necklace, int cnt1, int cnt2, int cnt3, int n) {
        int[] ans = findPiece(necklace, n / 2, 0, n, cnt1, cnt2, cnt3);
        if (ans == null || ans[0] != 0) return ans;
        return new int[]{ans[1]};
    }

    // cuts a,b,c. cnt[0+a] + cnt[b,c]= cnt, a+c-b = n/2
    private static int[] tryThreeCuts(int[] necklace, int cnt1, int cnt2, int cnt3, int n) {
        for (int cut = 1; cut < n / 2; cut++) {
            if (necklace[cut - 1] == 1) cnt1--;
            else if (necklace[cut - 1] == 2) cnt2--;
            else if (necklace[cut - 1] == 3) cnt3--;

            int[] piece = findPiece(necklace, n / 2 - cut, cut + 1, n - 1, cnt1, cnt2, cnt3);
            if (piece != null) return new int[]{cut, piece[0], piece[1]};
        }
        return null;
    }

    private static int[] findPiece(int[] necklace, int len, int start, int end, int cnt1, int cnt2, int cnt3) {
        if (start >= end || start + len > end || cnt1 < 0 || cnt2 < 0 || cnt3 < 0) return null;
        for (int i = start + len - 1; i >= start; i--) {
            if (necklace[i] == 1) cnt1--;
            else if (necklace[i] == 2) cnt2--;
            else if (necklace[i] == 3) cnt3--;
        }
        if (cnt1 == 0 && cnt2 == 0 && cnt3 == 0) return new int[]{start, start + len};

        for (int r = start + len, l = start; r < end; r++, l++) {
            if (necklace[r] == 1) cnt1--;
            else if (necklace[r] == 2) cnt2--;
            else if (necklace[r] == 3) cnt3--;

            if (necklace[l] == 1) cnt1++;
            else if (necklace[l] == 2) cnt2++;
            else if (necklace[l] == 3) cnt3++;

            if (cnt1 == 0 && cnt2 == 0 && cnt3 == 0) return new int[]{l + 1, r + 1};
        }
        return null;
    }

    private static int[] tryFourCuts(int[] necklace, int cnt1, int cnt2, int cnt3, int n) {
        Triple[] prefSum = new Triple[n + 1];
        prefSum[0] = new Triple(0, 0, 0);
        for (int i = 0; i < n; i++) prefSum[i + 1] = prefSum[i].plus(necklace[i]);

        int partTotalLen = n / 2;
        Triple total = new Triple(cnt1, cnt2, cnt3);
        for (int firstPieceLen = 1, secondPieceLen = partTotalLen - 1; firstPieceLen < partTotalLen; firstPieceLen++, secondPieceLen--) {
            HashMap<Triple, Integer> map = new HashMap<>();
            for (
                    int start1 = 1, end1 = start1 + firstPieceLen, start2 = end1 + 1, end2 = start2 + secondPieceLen;
                    end2 < n;
                    start1++, end1++, start2++, end2++
            ) {
                map.put(prefSum[end1].minus(prefSum[start1]), start1);
                Integer leftCutStart = map.get(total.minus(prefSum[end2].minus(prefSum[start2])));
                if (leftCutStart != null) return new int[]{leftCutStart, leftCutStart + firstPieceLen, start2, end2};
            }
        }
        return null;
    }

    private record Triple(int cnt1, int cnt2, int cnt3) {
        Triple plus(int gem) {
            return switch (gem) {
                case 1 -> new Triple(cnt1 + 1, cnt2, cnt3);
                case 2 -> new Triple(cnt1, cnt2 + 1, cnt3);
                case 3 -> new Triple(cnt1, cnt2, cnt3 + 1);
                default -> this;
            };
        }

        Triple minus(Triple that) {
            return new Triple(this.cnt1 - that.cnt1, this.cnt2 - that.cnt2, this.cnt3 - that.cnt3);
        }
    }
}
