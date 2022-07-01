package google.foobar.level4.running_with_bunnies;

import java.util.Arrays;

public class Answer {
    private static final int INF = 1_000_000_000;

    public static int[] answer(int[][] times, int timeLimit) {
        int n = times.length;
        int numberOfBunnies = n - 2;
        int bunnyMask = (1 << numberOfBunnies) - 1;

        int[] nodeMaskToInclude = new int[n];
        for (int i = 0; i < numberOfBunnies; i++) nodeMaskToInclude[i + 1] = 1 << i;

        int totalNumberOfNodes = n << numberOfBunnies;
        int[] d = new int[totalNumberOfNodes]; // last bits for collected bunnies
        Arrays.fill(d, INF);
        d[0] = 0;

        int iterationCounter = 0;
        boolean changed = true;
        while (changed) {
            changed = false;
            if (iterationCounter++ >= totalNumberOfNodes) {
                // negative cycle detected
                int[] allBunnies = new int[numberOfBunnies];
                for (int i = 1; i < numberOfBunnies; i++) allBunnies[i] = i;
                return allBunnies;
            }

            for (int u = 0; u < n; u++) {
                int uMaskInclude = nodeMaskToInclude[u], uMaskIterate = bunnyMask ^ uMaskInclude;
                for (int v = 0; v < n; v++) {
                    if (u == v) continue;

                    //if d[v] > d[u] + w(u,v)
                    int w = times[u][v], vMaskInclude = nodeMaskToInclude[v];
                    for (int subMask = uMaskIterate; ; subMask = (subMask - 1) & uMaskIterate) {
                        int from = u << numberOfBunnies | subMask | uMaskInclude;
                        int to = v << numberOfBunnies | subMask | uMaskInclude | vMaskInclude;
                        if (d[to] > d[from] + w) {
                            changed = true;
                            d[to] = d[from] + w;
                        }
                        if (subMask == 0) break;
                    }
                }
            }
        }

        int maxCount = 0, maxMask = 0;
        for (int mask = 1, node = (n - 1) << numberOfBunnies | 1; mask <= bunnyMask; mask++, node++) {
            if (d[node] > timeLimit) continue;
            int count = Integer.bitCount(mask);
            if (count < maxCount) continue;
            if (count == maxCount && !lexicalOrder(mask, maxMask)) continue;
            maxCount = count;
            maxMask = mask;
        }

        int[] ans = new int[maxCount];
        int pos = 0;
        for (int i = 0; i < numberOfBunnies; i++) if ((maxMask >> i & 1) == 1) ans[pos++] = i;
        return ans;
    }

    private static boolean lexicalOrder(int prev1, int prev2) {
        while (true) {
            int next1 = prev1 & (prev1 - 1);
            int next2 = prev2 & (prev2 - 1);
            int cmp = (prev1 ^ next1) - (prev2 ^ next2);
            if (cmp < 0) return true;
            else if (cmp > 0) return false;
            prev1 = next1;
            prev2 = next2;
        }
    }
}
