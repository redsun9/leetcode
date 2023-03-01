package help_requests.necklace_cut;

/*
Giving the necklace consisting of gems of two different types,
split it evenly into two parts by making the least amount of cuts
 */
public class Solution2 {
    public static int[] getMinimumCuts(int[] necklace) {
        int n = necklace.length;
        if (n == 0) return new int[0];
        if ((n & 1) != 0) return null;

        int cnt = 0;
        for (int gem : necklace) if (gem == 1) cnt++;
        if ((cnt & 1) != 0) return null;

        cnt >>>= 1;
        for (int i = n / 2 - 1; i >= 0; i--) if (necklace[i] == 1) cnt--;
        if (cnt == 0) return new int[]{n / 2};

        for (int r = n / 2, l = 0; r < n; r++, l++) {
            if (necklace[r] == 1) cnt--;
            if (necklace[l] == 1) cnt++;
            if (cnt == 0) return new int[]{l + 1, r + 1};
        }
        return null;
    }
}
