package leetcode.leetcode22xx.leetcode2272;

import java.util.ArrayList;
import java.util.List;

// Space: O(n*k)
// Time: O(k*k*n), and even O(k*n)

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution2 {
    private static final int ALPHABET_SIZE = 26;

    public int largestVariance(String s) {
        int n = s.length();
        int[][] count = new int[n + 1][ALPHABET_SIZE];
        List<Integer>[] positions = new List[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) positions[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.arraycopy(count[i], 0, count[i + 1], 0, ALPHABET_SIZE);
            int c = s.charAt(i) - 'a';
            count[i + 1][c]++;
            positions[c].add(i);
        }
        int maxOccurence = 0, totalDifferent = 0, minOccurence = Integer.MAX_VALUE;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (count[n][i] == 0) continue;
            maxOccurence = Math.max(maxOccurence, count[n][i]);
            minOccurence = Math.min(minOccurence, count[n][i]);
            totalDifferent++;
        }

        // trivial cases
        if (totalDifferent == 1) return 0;
        if (maxOccurence == 1) return 0;
        if (minOccurence == 1) return maxOccurence - 1;

        int ans = 1;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (count[n][i] <= ans + 1) continue;
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (i == j) continue;
                List<Integer> a = positions[j];
                int n2 = a.size();
                if (n2 == 0) continue;
                int leftIndex = 0, rightIndex = 0; // [0, a.get(1))
                while (rightIndex < n2) {
                    rightIndex = Math.max(rightIndex, leftIndex);
                    int left = leftIndex == 0 ? -1 : a.get(leftIndex - 1);
                    int right = rightIndex == n2 - 1 ? n : a.get(rightIndex + 1);
                    if (rightIndex != leftIndex && count[a.get(leftIndex)][i] == count[left + 1][i]) {
                        leftIndex++;
                        continue;
                    }
                    int tmp = count[right][i] - count[left + 1][i] - (rightIndex - leftIndex + 1);
                    ans = Math.max(ans, tmp);
                    if (tmp <= 0) leftIndex = rightIndex + 1;
                    rightIndex++;
                }
            }
        }

        return ans;
    }
}
