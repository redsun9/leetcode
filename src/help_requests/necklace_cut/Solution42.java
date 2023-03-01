package help_requests.necklace_cut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution42 {
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

        Triple[] prefSum = new Triple[n + 1];
        prefSum[0] = new Triple(0, 0, 0);
        for (int i = 0; i < n; i++) prefSum[i + 1] = prefSum[i].plus(necklace[i]);

        int partTotalLen = n / 2;
        Triple total = new Triple(cnt1, cnt2, cnt3);

        List<Integer> ans = null;
        int ansLen = 5;

        for (int firstPieceLen = 1, secondPieceLen = partTotalLen - 1; firstPieceLen < partTotalLen; firstPieceLen++, secondPieceLen--) {
            HashMap<Triple, Integer> map = new HashMap<>();
            for (
                    int start1 = 0, end1 = start1 + firstPieceLen, start2 = end1, end2 = start2 + secondPieceLen;
                    end2 <= n;
                    start1++, end1++, start2++, end2++
            ) {
                map.put(prefSum[end1].minus(prefSum[start1]), start1);
                Integer leftCutStart = map.get(total.minus(prefSum[end2].minus(prefSum[start2])));
                if (leftCutStart != null) {
                    List<Integer> canonized = canonize(leftCutStart, leftCutStart + firstPieceLen, start2, end2, n);
                    if (canonized.size() < ansLen) {
                        ans = canonized;
                        ansLen = canonized.size();
                    }
                }
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

    private static List<Integer> canonize(int a, int b, int c, int d, int n) {
        List<Integer> ans = new ArrayList<>();
        if (a != 0) ans.add(a);
        if (b != c) {
            ans.add(b);
            ans.add(c);
        }
        if (d != n) ans.add(d);
        return ans;
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
