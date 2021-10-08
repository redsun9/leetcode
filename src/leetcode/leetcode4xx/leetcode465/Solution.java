package leetcode.leetcode4xx.leetcode465;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
public class Solution {
    private int[][] posTmp, negTmp;
    private long[] posPowers, negPowers;
    private int posNumber, negNumber;
    private final Map<Long, Integer> cache = new HashMap<>();

    /**
     * @param edges: a directed graph where each edge is represented by a tuple
     * @return the number of edges
     */
    public int balanceGraph(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            map.compute(edge[0], (k, v) -> v == null ? -edge[2] : v - edge[2]);
            map.compute(edge[1], (k, v) -> v == null ? edge[2] : v + edge[2]);
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer value : map.values()) if (value != 0) count.compute(value, (k, v) -> v == null ? 1 : v + 1);
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getKey() < 0) continue;
            int b = Math.min(entry.getValue(), count.getOrDefault(-entry.getKey(), 0));
            if (b != 0) {
                ans += b;
                entry.setValue(entry.getValue() - b);
                count.compute(-entry.getKey(), (k, v) -> v - b);
            }
        }

        posNumber = 0;
        negNumber = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 0) continue;
            if (entry.getKey() > 0) posNumber++;
            else negNumber++;
        }


        int total = 0;
        posTmp = new int[2][posNumber];
        negTmp = new int[2][negNumber];

        int posPos = 0, negPos = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 0) continue;
            total += entry.getValue();
            if (entry.getKey() > 0) {
                posTmp[0][posPos] = entry.getKey();
                posTmp[1][posPos] = entry.getValue();
                posPos++;
            } else {
                negTmp[0][negPos] = entry.getKey();
                negTmp[1][negPos] = entry.getValue();
                negPos++;
            }
        }

        posPowers = new long[posNumber + 1];
        negPowers = new long[negNumber + 1];
        posPowers[0] = 1L;
        for (int i = 0; i < posNumber; i++) posPowers[i + 1] = posPowers[i] * (posTmp[1][i] + 1);
        negPowers[0] = posPowers[posNumber];
        for (int i = 0; i < negNumber; i++) negPowers[i + 1] = negPowers[i] * (negTmp[1][i] + 1);
        return ans + total - dfs(0, negPowers[negNumber] - 1);
    }


    //divide numbers such that number of groups with sum equals to zero is maximum
    private int dfs(int curr, long key) {
        if (key == 0) return 0;
        Integer ans = cache.get(key);
        if (ans == null) {
            ans = 0;
            if (curr == 0) {
                int i = 0;
                while (posTmp[1][i] == 0) i++;
                posTmp[1][i]--;
                ans = dfs(posTmp[0][i], key - posPowers[i]);
                posTmp[1][i]++;
            } else if (curr > 0) {
                for (int i = 0; i < negNumber; i++) {
                    if (negTmp[1][i] == 0) continue;
                    curr = curr + negTmp[0][i];
                    negTmp[1][i]--;
                    ans = Math.max(ans, (curr == 0 ? 1 : 0) + dfs(curr, key - negPowers[i]));
                    curr = curr - negTmp[0][i];
                    negTmp[1][i]++;
                }
            } else {
                for (int i = 0; i < posNumber; i++) {
                    if (posTmp[1][i] == 0) continue;
                    curr = curr + posTmp[0][i];
                    posTmp[1][i]--;
                    ans = Math.max(ans, (curr == 0 ? 1 : 0) + dfs(curr, key - posPowers[i]));
                    curr = curr - posTmp[0][i];
                    posTmp[1][i]++;
                }
            }
            cache.put(key, ans);
        }
        return ans;
    }
}
